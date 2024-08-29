package wonky.product.materialyoucatalog.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.MainViewModel
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.drawer.DrawerMenu


@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    onSelected: (DrawerMenu) -> Unit
) {

    val menuList by mainViewModel.menuList.collectAsState()


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Overview(stringResource(R.string.overview_m3))
        Spacer6v()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),

            ) {
            items(menuList.size) { index ->
                MenuItem(
                    modifier = Modifier.padding(4.dp),
                    item = menuList[index],
                    onSelected = onSelected
                )
            }

        }
        Spacer16v()
    }
}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    item: DrawerMenu,
    onSelected: (menu: DrawerMenu) -> Unit
) {

    ElevatedCard(
        modifier = modifier.fillMaxSize(),
        onClick = { onSelected(item) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Icon(
                imageVector = item.icon,
                contentDescription = item.title
            )

//            androidx.compose.material.IconButton() { }
//            IconButton(
//                imageVector = item.icon,
//                contentDescription = item.title
//            )
            Spacer6v()
            Text(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                text = item.title
            )
        }
    }
}
