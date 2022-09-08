package wonky.product.materialyoucatalog.ui.components.selection

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable

@Composable
fun MYSlider(){
    Slider(value = 0.5f, onValueChange = {})
}

@Composable
fun MYDiscreteSlider(){
    Slider(value = 0.5f, steps = 5, onValueChange = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYRangeSlider(){
    RangeSlider(value = 0f..0.5f, onValueChange = {})
}

