package wonky.product.materialyoucatalog.ui.screen.showcases.circularcarousel

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FloatSpringSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.horizontalDrag
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

private const val TAG = "CircularCarouselScreen"


@Composable
fun CircularCarouselScreen(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(136.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularCarousel(numItems = 24) {
            Surface(
                shape = RectangleShape,
                color = when{
                    it%3==0 -> Color.Green
                    it%3==1 -> Color.Red
                    it%3==2 -> Color.Blue
                    else -> Color.Black
                },
                modifier = Modifier.size(32.dp)
            ) {
                Text(it.toString())
            }

        }
    }
}

@Composable
fun CircularCarousel(
    numItems: Int,
    modifier: Modifier = Modifier,
    itemFraction: Float = .25f,
    state: CircularCarouselState = rememberCircularCarouselState(),
    contentFactory: @Composable (Int) -> Unit,
){
    require(numItems>0) { "The number of items must be greater than 0"}
    require(itemFraction>0f && itemFraction<.5f){ "Item fraction must be in the (0f, .f) range"}

    Layout(
        modifier = modifier.drag(state),
        content = {
            val angleStep = 360f / numItems.toFloat()
            repeat(numItems){ index ->
                val itemAngle = (state.angle+angleStep*index.toFloat()).normalizeAngle()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            cameraDistance = 12f * density
                            rotationY = itemAngle
                        }
                ){
                    contentFactory(index)
                }
            }
        }
    ){ measureables, constraints ->
        Log.d(TAG, "CircularCarousel: width = ${constraints.maxWidth} , height = ${constraints.maxHeight}")
        val itemDimension = constraints.maxHeight * itemFraction
        val itemConstraints = Constraints.fixed(
            width = itemDimension.toInt(),
            height = itemDimension.toInt()
        )
        val placeables = measureables.map { measurable ->  measurable.measure(itemConstraints)}
        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ){
            val availableHorizontalSpace = constraints.maxWidth-itemDimension
            val horizontalOffset = availableHorizontalSpace / 2.0
            val verticalOffset = (constraints.maxHeight - itemDimension).toInt() / 2
            val angleStep = 2.0 * PI / numItems.toDouble()
            Log.d(TAG, "CircularCarousel: size = ${placeables.size}")
            placeables.forEachIndexed { index, placeable ->
                val itemAngle = (state.angle.toDouble().degreesToRadians() + (angleStep*index.toDouble())) % 360.0
                val offset = getCoordinates(
                    width = availableHorizontalSpace / 2.0,
                    height = (constraints.maxHeight.toDouble() / 2.0 - itemDimension),
                    angle = itemAngle
                )
                placeable.placeRelative(
                    x = (horizontalOffset+offset.x).roundToInt(),
                    y = offset.y.roundToInt()+verticalOffset
                )
            }
            
        }
    }

}

private fun getCoordinates(width: Double, height: Double, angle: Double): Offset{
    val x = width * sin(angle)
    val y = height * cos(angle)
    return Offset(
        x = x.toFloat(),
        y = y.toFloat()
    )
}

@Stable
interface CircularCarouselState{
    val angle: Float
    suspend fun stop()
    suspend fun snapTo(angle: Float)
    suspend fun decayTo(angle: Float, velocity: Float)
}

class CircularCarouselStateImpl: CircularCarouselState{

    private val _angle = Animatable(0f)

    override val angle: Float
        get() = _angle.value

    private val decayAnimationSpec = FloatSpringSpec(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = Spring.StiffnessVeryLow
    )

    override suspend fun stop() {
        _angle.stop()
    }

    override suspend fun snapTo(angle: Float) {
        _angle.snapTo(angle)
    }

    override suspend fun decayTo(angle: Float, velocity: Float) {
        _angle.animateTo(
            targetValue = angle,
            initialVelocity = velocity,
            animationSpec = decayAnimationSpec
        )
    }
}

@Composable
fun rememberCircularCarouselState(): CircularCarouselState = remember {
    CircularCarouselStateImpl()
}

private fun Double.degreesToRadians(): Double = this / 360.0 * 2.0 * PI

private fun Float.normalizeAngle(): Float = (this % 360f).let{ angle -> if(this < 0f) 360f + angle else angle}

private fun Modifier.drag(
    state: CircularCarouselState
) = pointerInput(Unit) {
    val decay = splineBasedDecay<Float>(this)
    coroutineScope {
        while(true){
            val pointerInput = awaitPointerEventScope { awaitFirstDown() }
            state.stop()
            val tracker = VelocityTracker()
            val degreesPerPixel = 180f / size.width.toFloat()
            awaitPointerEventScope {
                val isTopHalf = pointerInput.position.y < size.height / 2f
                val signum = when {
                    isTopHalf -> -1f
                    else -> 1f
                }
                horizontalDrag(pointerInput.id){ change ->
                    val horizontalDragOffset = state.angle + signum*change.positionChange().x * degreesPerPixel
                    launch {
                        state.snapTo(horizontalDragOffset)
                    }
                    tracker.addPosition(change.uptimeMillis, change.position)
                    if(change.positionChange()!= Offset.Zero) change.consume()
                }
                val velocity = tracker.calculateVelocity().x
                val targetAngle = decay.calculateTargetValue(
                    state.angle,
                    signum*velocity*degreesPerPixel
                )
                launch {
                    state.decayTo(
                        angle = targetAngle,
                        velocity = signum*velocity * degreesPerPixel
                    )
                }
            }
        }
    }
}