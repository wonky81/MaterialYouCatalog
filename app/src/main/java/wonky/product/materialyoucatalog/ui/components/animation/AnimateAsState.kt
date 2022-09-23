package wonky.product.materialyoucatalog.ui.components.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R


@Composable
fun AnimateDpAsStateSample(
    expanded: Boolean,
){

    val animatedSizeDp: Dp by animateDpAsState(targetValue = if(expanded) 100.dp else 50.dp)
    AlarmIconObject(size = animatedSizeDp)
}

@Composable
fun AnimateColorAsStateSample(
    needColorChange:Boolean = false,
    startColor: Color = MaterialTheme.colorScheme.primary,
    endColor: Color = MaterialTheme.colorScheme.error
){
    val backgroundColor by animateColorAsState(
        targetValue = if(needColorChange) endColor else startColor,
        animationSpec = tween(
            durationMillis = 1000,
            delayMillis = 50,
            easing = LinearEasing
        )
    )
    AlarmIconObject(backgroundColor = backgroundColor)
}

@Composable
fun AnimateFloatAsStateSample(
    isRotated:Boolean,
){

    val rotationAngle by animateFloatAsState(
        targetValue = if(isRotated) 360F else 0f,
        animationSpec = tween(
            durationMillis = 1500,
        )
    )

    AlarmIconObject(
        modifier = Modifier.rotate(rotationAngle)
    )

}

@Composable
fun CircleImage(
    modifier: Modifier = Modifier,
    imageSize: Dp
) {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(imageSize)
            .clip(CircleShape)
            .border(5.dp, Color.Gray, CircleShape)
    )
}