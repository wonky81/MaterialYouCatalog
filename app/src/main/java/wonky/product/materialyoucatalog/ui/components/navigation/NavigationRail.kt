package wonky.product.materialyoucatalog.ui.components.navigationrail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme

@Composable
fun MYNavigationRail(){
    NavigationRail(
        header = {
                 Text("Header")
        },
        content = {
            NavigationRailItem(
                selected = true,
                icon = { Icon(Icons.Filled.Add,null) },
                label = { Text(" Item 1")},
                onClick = { /*TODO*/ }
            )
            NavigationRailItem(
                selected = false,
                icon = { Icon(Icons.Filled.Call,null) },
                label = { Text(" Item 2")},
                onClick = { /*TODO*/ }
            )
            NavigationRailItem(
                selected = false,
                icon = { Icon(Icons.Filled.Notifications,null) },
                label = { Text(" Item 3")},
                onClick = { /*TODO*/ }
            )
        }
    )
}

