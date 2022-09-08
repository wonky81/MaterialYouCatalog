package wonky.product.materialyoucatalog.ui.screen.navigation

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.topappbar.MYCenterAlignedTopAppBar
import wonky.product.materialyoucatalog.ui.components.topappbar.MYLargeTopAppBar
import wonky.product.materialyoucatalog.ui.components.topappbar.MYMediumTopAppBar
import wonky.product.materialyoucatalog.ui.components.topappbar.MYSmallTopAppBar
import wonky.product.materialyoucatalog.ui.screen.ComponentArrangement


@Composable
fun TopAppBarScreen() {
    ComponentArrangement(
        { MYCenterAlignedTopAppBar() },
        { MYLargeTopAppBar() },
        { MYMediumTopAppBar() },
        { MYSmallTopAppBar() },
    )
}