package wonky.product.materialyoucatalog.ui.components.selection

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MYSlider(
    modifier: Modifier = Modifier,
    enabled:Boolean,
    value:Float,
    onValueChange: (Float) -> Unit
){
    Slider(
        modifier = modifier,
        enabled = enabled,
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
fun MYDiscreteSlider(
    modifier: Modifier = Modifier,
    enabled:Boolean,
    value:Float,
    steps:Int,
    onValueChange: (Float) -> Unit
){
    Slider(
        modifier = modifier,
        enabled = enabled,
        value = value,
        steps = steps,
        onValueChange = onValueChange
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYRangeSlider(
    modifier: Modifier = Modifier,
    enabled:Boolean,
    value:ClosedFloatingPointRange<Float>,
    steps:Int,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit
){
    RangeSlider(
        modifier = modifier,
        enabled = enabled,
        value = value,
        steps = steps,
        onValueChange = onValueChange
    )
}

