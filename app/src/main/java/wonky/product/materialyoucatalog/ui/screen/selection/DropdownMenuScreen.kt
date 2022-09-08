package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.dropdownmenu.MYDropdownMenu
import wonky.product.materialyoucatalog.ui.components.dropdownmenu.MYExposedDropdownMenu


@Composable
fun DropdownMenuScreen() {

    ComponentArrangement(
        { MYDropdownMenu() },
        { MYExposedDropdownMenu() },
    )
}