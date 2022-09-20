package wonky.product.materialyoucatalog.ui.components.selection

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

@Composable
fun MYSwitch(
    enabled: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    thumbContent: @Composable () -> Unit
){
    Switch(
        enabled = enabled,
        checked = checked,
        onCheckedChange = onCheckedChange,
        thumbContent = thumbContent
    )
}
