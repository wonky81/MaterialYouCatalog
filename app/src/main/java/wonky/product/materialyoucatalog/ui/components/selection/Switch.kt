package wonky.product.materialyoucatalog.ui.components.switch

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable

@Composable
fun MYSwitchChecked(){
    Switch(checked = true, onCheckedChange = {})
}

@Composable
fun MYSwitchNotChecked(){
    Switch(checked = false, onCheckedChange = {})
}

