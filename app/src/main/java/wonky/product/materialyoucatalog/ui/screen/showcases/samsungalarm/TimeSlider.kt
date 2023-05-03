package wonky.product.materialyoucatalog.ui.screen.showcases.samsungalarm

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FloatSpringSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.verticalDrag
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

data class TimeSliderConfig(
    val contentHeight: Float = 0f,
    val numItems: Int = 0,
    val visibleItems: Int = 0,
    val circularFraction: Float = 1f
)

@Stable
interface TimerSliderState{
    val verticalOffset: Float
    val firstVisibleItem: Int
    val lastVisibleItem: Int

    suspend fun snapTo(value: Float)
    suspend fun decayTo(velocity: Float, value: Float)
    suspend fun stop()
    fun offsetFor(index: Int): IntOffset
    fun setup(config: TimeSliderConfig)
}

class TimeSliderStateImpl(
    currentOffset: Float = 0f,
) : TimerSliderState {
    private val animatable = Animatable(currentOffset)
    private var itemHeight = 0f
    private var config = TimeSliderConfig()
    private var initialOffset = 0f

    private val decayAnimationSpec = FloatSpringSpec(
        dampingRatio = Spring.DampingRatioLowBouncy,
        stiffness = Spring.StiffnessLow
    )

    private val minOffset: Float
        get() = -(config.numItems-1)*itemHeight

    override val verticalOffset: Float
        get() = animatable.value
    override val firstVisibleItem: Int
        get() = ((-verticalOffset-initialOffset)/itemHeight).toInt().coerceAtLeast(0)
    override val lastVisibleItem: Int
        get() = (((-verticalOffset-initialOffset)/itemHeight).toInt() + config.visibleItems).coerceAtMost(config.numItems-1)

    override suspend fun snapTo(value: Float) {
        animatable.snapTo(value.coerceIn(-(config.numItems-1)*itemHeight,0f))
    }

    override suspend fun decayTo(velocity: Float, value: Float) {
        val constrainedValue = value.coerceIn(minOffset,0f).absoluteValue
        val reminder = (constrainedValue/itemHeight) - (constrainedValue/itemHeight).toInt()
        val extra = if(reminder<=0.5f) 0 else 1
        val target = ((constrainedValue/itemHeight).toInt()+extra) * itemHeight
        animatable.animateTo(
            targetValue = -target,
            initialVelocity = velocity,
            animationSpec = decayAnimationSpec,
        )
    }

    override suspend fun stop() {
        animatable.stop()
    }

    override fun setup(config: TimeSliderConfig) {
        this.config = config
        itemHeight = config.contentHeight / config.visibleItems
        initialOffset = (config.contentHeight-itemHeight) / 2f
    }

    override fun offsetFor(index: Int): IntOffset {
        val y = (verticalOffset+initialOffset+index*itemHeight)
        return IntOffset(
            x = 0,
            y = y.roundToInt()
        )
    }

    companion object{
        val mySaver = Saver<TimeSliderStateImpl, List<Any>>(
            save = { listOf(it.verticalOffset) },
            restore = {
                TimeSliderStateImpl(it[0] as Float)
            }
        )
    }

}

@Composable
fun rememberTimeSliderState(): TimerSliderState {
    val state = rememberSaveable(saver = TimeSliderStateImpl.mySaver) {
        TimeSliderStateImpl()
    }
    return state
}

fun Modifier.drag(
    state: TimerSliderState
) = pointerInput(Unit){
    val decay = splineBasedDecay<Float>(this)
    coroutineScope {
        while(true){
            val pointerId = awaitPointerEventScope { awaitFirstDown().id }
            state.stop()
            val tracker = VelocityTracker()
            awaitPointerEventScope {
                verticalDrag(pointerId){ change ->
                    val verticalDragOffset = state.verticalOffset+change.positionChange().y
                    launch {
                        state.snapTo(verticalDragOffset)
                    }
                    tracker.addPosition(change.uptimeMillis,change.position)
                    change.consumePositionChange()
                }
            }
            val velocity = tracker.calculateVelocity().y
            val targetValue = decay.calculateTargetValue(state.verticalOffset,velocity)
            launch {
                state.decayTo(velocity,targetValue)
            }
        }
    }
}