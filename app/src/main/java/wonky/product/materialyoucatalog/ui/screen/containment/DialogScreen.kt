package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.dialog.MYBasicDialog
import wonky.product.materialyoucatalog.ui.components.dialog.MYFullScreenDialog
import wonky.product.materialyoucatalog.ui.screen.ComponentArrangement

@Composable
fun DialogScreen() {

    ComponentArrangement(
        { MYBasicDialog() },
        { MYFullScreenDialog() },
    )
}