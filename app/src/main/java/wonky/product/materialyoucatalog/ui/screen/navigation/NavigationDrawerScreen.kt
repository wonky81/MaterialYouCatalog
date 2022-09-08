package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.navigationbar.MYNavigationBar
import wonky.product.materialyoucatalog.ui.components.navigationdrawer.MYDismissibleNavigationDrawer
import wonky.product.materialyoucatalog.ui.components.navigationdrawer.MYModalNavigationDrawer
import wonky.product.materialyoucatalog.ui.components.navigationdrawer.MYPermanentNavigationDrawer

@Composable
fun NavigationDrawerScreen() {


    ComponentArrangement(
        { MYModalNavigationDrawer() },
    )


/*    ComponentArrangement(
        { MYPermanentNavigationDrawer() },
    )*/

/*    ComponentArrangement(
        { MYDismissibleNavigationDrawer() },
    )*/
}