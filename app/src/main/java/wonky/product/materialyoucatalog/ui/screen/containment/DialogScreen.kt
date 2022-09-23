package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.dialog.MYBasicDialog
import wonky.product.materialyoucatalog.ui.components.dialog.MYFullScreenDialog
import wonky.product.materialyoucatalog.ui.screen.*
import wonky.product.materialyoucatalog.ui.screen.navigation.KindTopAppBar

@Composable
fun DialogScreen() {
    var showBasicDialog by remember { mutableStateOf(false) }
    var showFullScreenDialog by remember { mutableStateOf(false) }

    var showBasicDialogIcon by remember { mutableStateOf(false) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_dialog))
        MaterialElementScreen(
            title = "Basic Dialog",
            componentContent = {
                FilledTonalButton(
                    onClick = { showBasicDialog = true }
                ) {
                    Text("Show Case")
                }

            },
            controlContent = {
                CheckBoxWithText(checked = showBasicDialogIcon, onCheckedChange = { showBasicDialogIcon = it }, text = "Show Icon")
            }
        )

        MaterialElementScreen(
            title = "Full-screen Dialog",
            componentContent = {
                FilledTonalButton(
                    onClick = { showFullScreenDialog = true }
                ) {
                    Text("Show Case")
                }

            },
            controlContent = { }
        )

        if(showBasicDialog){
            MYBasicDialog(
                showIcon = showBasicDialogIcon,
                onDismiss = { showBasicDialog = false}
            )
        }

        if(showFullScreenDialog){
            MYFullScreenDialog( onDismiss = { showFullScreenDialog = false} )
        }
    }
}