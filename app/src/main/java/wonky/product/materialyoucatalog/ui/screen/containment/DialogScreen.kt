package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
import wonky.product.materialyoucatalog.ui.components.dialog.MYBasicDialog
import wonky.product.materialyoucatalog.ui.components.dialog.MYFullScreenDialog
import wonky.product.materialyoucatalog.ui.screen.*
import wonky.product.materialyoucatalog.ui.screen.navigation.KindTopAppBar

@Composable
fun DialogScreen() {
    var showBasicDialog by remember { mutableStateOf(false) }
    var showFullScreenDialog by remember { mutableStateOf(false) }

    var showBasicDialogIcon by remember { mutableStateOf(false) }

    val basicDialogCode =
        """
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text("Basic Dialog")
            },
            text = {
                Text("Content Area\n This is the content area for basic dialog.")
            },
            confirmButton = {
                TextButton(onClick = {}) {
                    Text("Confirm")
                }
    
            },
            dismissButton = {
                TextButton(onClick = {}) {
                    Text("Dismiss")
                }
    
            },
            icon = Icon(Icons.Filled.DateRange, null)
        )
    """
    val basicDialogRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(AlertDialog|TextButton|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(onDismissRequest\\s*=|title\\s*=|text\\s*=|confirmButton\\s*=|dismissButton\\s*=|icon\\s*=|onClick\\s*=)\\s*", parameterColor))
    }

    val fullScreenDialogCode =
        """
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = onDismiss
        ) {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxSize()
    
            ) {
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Filled.Close, contentDescription = null)
                        }
                        Text("Full-screen dialog title")
                        TextButton(onClick = onDismiss) {
                            Text("Save")
                        }
                    }
    
                }
            }
        }
    """
    val fullScreenDialogRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(DialogProperties|Dialog|Surface|Column|Row|IconButton|TextButton|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(properties\\s*=|usePlatformDefaultWidth\\s*=|onDismissRequest\\s*=|color\\s*=|modifier\\s*=|verticalAlignment\\s*=|horizontalArrangement\\s*=|onClick\\s*=)\\s*", parameterColor))
    }


    MaterialContents {
        Overview(content = stringResource(R.string.overview_dialog))
        MaterialElementScreen(
            title = "Basic Dialog",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(basicDialogCode,basicDialogRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(fullScreenDialogCode, fullScreenDialogRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
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