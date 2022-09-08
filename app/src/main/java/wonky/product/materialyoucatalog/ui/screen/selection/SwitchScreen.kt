package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.runtime.Composable
import wonky.product.materialyoucatalog.ui.components.switch.MYSwitchChecked
import wonky.product.materialyoucatalog.ui.components.switch.MYSwitchNotChecked

@Composable
fun SwitchScreen() {
    ComponentArrangement(
        { MYSwitchChecked() },
        { MYSwitchNotChecked() },
    )
}
