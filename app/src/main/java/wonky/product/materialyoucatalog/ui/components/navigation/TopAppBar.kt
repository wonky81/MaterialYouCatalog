package wonky.product.materialyoucatalog.ui.components.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYCenterAlignedTopAppBar(){
    CenterAlignedTopAppBar(
        title = { Text("Title")},
        navigationIcon = { Icon(Icons.Filled.Share,null)},
        actions = {
            Icon(Icons.Filled.Settings,null)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYLargeTopAppBar(){
    LargeTopAppBar(
        title = { Text("Title")},
        navigationIcon = { Icon(Icons.Filled.Share,null)},
        actions = {
            Icon(Icons.Filled.Settings,null)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYMediumTopAppBar(){
    MediumTopAppBar(
        title = { Text("Title")},
        navigationIcon = { Icon(Icons.Filled.Share,null)},
        actions = {
            Icon(Icons.Filled.Settings,null)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYSmallTopAppBar(){
    SmallTopAppBar(
        title = { Text("Title")},
        navigationIcon = { Icon(Icons.Filled.Share,null)},
        actions = {
            Icon(Icons.Filled.Settings,null)
        }
    )
}