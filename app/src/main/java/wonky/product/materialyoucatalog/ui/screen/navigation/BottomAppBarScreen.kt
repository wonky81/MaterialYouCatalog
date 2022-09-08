package wonky.product.materialyoucatalog.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import wonky.product.materialyoucatalog.ui.components.bottomappbar.MYBottomAppBar
import wonky.product.materialyoucatalog.ui.screen.ComponentArrangement

@Composable
fun BottomAppBarScreen(

){
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxHeight()
    ) {
        MYBottomAppBar()
    }
}