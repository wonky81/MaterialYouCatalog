package wonky.product.materialyoucatalog.ui.components.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYBasicDialog(

) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = {
            Text("Basic Dialog")
        },
        text = {
            Text("Content Area\n This is the content area for basic dialog.")
        },
        confirmButton = {
            Text("Confirm")
        },
        dismissButton = {
            Text("Dismiss")
        },
        icon = {
            Icon(Icons.Filled.DateRange,null)
        }
    )

}

@Composable
fun MYFullScreenDialog(

) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Column() {
            Text("Dialog")
        }
    }
}

