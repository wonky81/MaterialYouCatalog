package wonky.product.materialyoucatalog.ui.components.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYModalNavigationDrawer(){
    ModalNavigationDrawer(drawerContent = { DrawerItems() }) {
        Text("ModelNavigationDrawer")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYPermanentNavigationDrawer(){
    PermanentNavigationDrawer(drawerContent = { DrawerItems() }) {
        Text("ModelNavigationDrawer")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYDismissibleNavigationDrawer(){
    DismissibleNavigationDrawer(drawerContent = { DrawerItems() }) {
        Text("ModelNavigationDrawer")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerItems(){
    Column {
        NavigationDrawerItem(
            icon = { Icon(Icons.Filled.Add,null)},
            badge = {Text("!")},
            label = { Text("First Item") },
            selected = true,
            onClick = { /*TODO*/ }
        )
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        NavigationDrawerItem(
            icon = { Icon(Icons.Filled.Add,null)},
            label = { Text("Second Item") },
            selected = false,
            onClick = { /*TODO*/ }
        )
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
        NavigationDrawerItem(
            icon = { Icon(Icons.Filled.Add,null)},
            label = { Text("Third Item") },
            selected = false,
            onClick = { /*TODO*/ }
        )
    }
}
