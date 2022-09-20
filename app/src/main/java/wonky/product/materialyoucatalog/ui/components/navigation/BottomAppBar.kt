package wonky.product.materialyoucatalog.ui.components.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.screen.ElevationLevel
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme

@Composable
fun MYBottomAppBar(
    modifier: Modifier = Modifier,
    fabShow: Boolean = true,
    tonalElevation: Dp = ElevationLevel.Level2.dp
) {

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomAppBar(
            modifier = modifier,
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = null
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = null
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = null
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = null
                    )
                }
            },
            floatingActionButton = {
                if(fabShow){
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = null
                        )
                    }
                }

            },
            tonalElevation = tonalElevation
        )
    }
}
