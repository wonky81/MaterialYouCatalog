package wonky.product.materialyoucatalog.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun MYNavigationRail(
    headerString: String,
    showLabel: Boolean,

){
    var selectedMenu by remember { mutableStateOf(1) }


    NavigationRail(
        header = {
                 Text(headerString)
        },
        content = {
            NavigationRailItem(
                selected = selectedMenu == 1,
                alwaysShowLabel = showLabel,
                icon = { Icon(Icons.Filled.Add,null) },
                label = { Text(" Item 1")},
                onClick = { selectedMenu = 1 }
            )
            NavigationRailItem(
                selected = selectedMenu == 2,
                alwaysShowLabel = showLabel,
                icon = { Icon(Icons.Filled.Call,null) },
                label = { Text(" Item 2")},
                onClick = { selectedMenu = 2 }
            )
            NavigationRailItem(
                selected = selectedMenu == 3,
                alwaysShowLabel = showLabel,
                icon = { Icon(Icons.Filled.Notifications,null) },
                label = { Text(" Item 3")},
                onClick = { selectedMenu = 3 }
            )
        }
    )
}

