package wonky.product.materialyoucatalog.ui.components.dialog

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloseFullscreen
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import wonky.product.materialyoucatalog.ui.screen.DialogCloseButton


@Composable
fun MYBasicDialog(
    showIcon: Boolean = false,
    onDismiss: () -> Unit

) {
    var icon: @Composable (() -> Unit)? = null
    if (showIcon) icon = { Icon(Icons.Filled.DateRange, null) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Basic Dialog")
        },
        text = {
            Text("Content Area\n This is the content area for basic dialog.")
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Confirm")
            }

        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Dismiss")
            }

        },
        icon = icon
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MYFullScreenDialog(
    onDismiss: () -> Unit
) {
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
}

