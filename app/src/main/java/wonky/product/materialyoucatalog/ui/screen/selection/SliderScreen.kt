package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.selection.MYDiscreteSlider
import wonky.product.materialyoucatalog.ui.components.selection.MYRangeSlider
import wonky.product.materialyoucatalog.ui.components.selection.MYSlider

@Composable
fun SliderScreen() {
    ComponentArrangement(
        { MYSlider() },
        { MYDiscreteSlider() },
        { MYRangeSlider() }
    )
}
