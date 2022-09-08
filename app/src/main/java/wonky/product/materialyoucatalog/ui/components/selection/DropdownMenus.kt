package wonky.product.materialyoucatalog.ui.components.dropdownmenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.components.dialog.MYFullScreenDialog
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme


@Composable
fun MYDropdownMenu(){
    DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
        DropdownMenuItem(
            leadingIcon = { Icon(Icons.Filled.Call, null)},
            text = { Text("First Item")},
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            leadingIcon = { Icon(Icons.Filled.Home, null)},
            text = { Text("Second Item")},
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            leadingIcon = { Icon(Icons.Filled.Send, null)},
            text = { Text("Third Item")},
            onClick = { /*TODO*/ }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYExposedDropdownMenu(){
    ExposedDropdownMenuBox(
        expanded = true,
        onExpandedChange ={

        }
    ) {
        DropdownMenuItem(
            leadingIcon = { Icon(Icons.Filled.Call, null)},
            text = { Text("First Item")},
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            leadingIcon = { Icon(Icons.Filled.Home, null)},
            text = { Text("Second Item")},
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            leadingIcon = { Icon(Icons.Filled.Send, null)},
            text = { Text("Third Item")},
            onClick = { /*TODO*/ }
        )
    }
}

