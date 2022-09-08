package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.dropdownmenu.MYExposedDropdownMenu
import wonky.product.materialyoucatalog.ui.components.navigationbar.MYNavigationBar

@Composable
fun NavigationBarScreen() {

    ComponentArrangement(
        { MYNavigationBar() },
    )
}