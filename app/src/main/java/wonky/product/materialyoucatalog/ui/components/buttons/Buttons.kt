package wonky.product.materialyoucatalog.ui.components.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme


@Composable
fun MYButton(){
    Button(onClick = { /*TODO*/ }) {
        Text("Button")
    }
}

@Composable
fun MYElevatedButton(){
    ElevatedButton(onClick = { /*TODO*/ }) {
        Text("ElevatedButton")
    }
}

@Composable
fun MYFilledTonalButton(){
    FilledTonalButton(onClick = { /*TODO*/ }) {
        Text("FilledTonalButton")
    }
}

@Composable
fun MYOutlinedButton(){
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text("OutlinedButton")
    }
}

@Composable
fun MYTextButton(){
    TextButton(onClick = { /*TODO*/ }) {
        Text("TextButton")
    }
}

@Composable
fun MYIconButton(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.AddCircle,
                contentDescription = null
            )
        }
        Text("IconButton")
    }
}

@Composable
fun MYFloatingActionButton(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Text("FloatingActionButton")
    }
}

@Composable
fun MYExtendedFloatingActionButton(){
    ExtendedFloatingActionButton(
        text = {
            Text("Extended FAB")
        },
        icon = {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Extended FAB"
            )
        },
        onClick = { /*TODO*/ }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialYouCatalogTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MYButton()
            MYElevatedButton()
            MYFilledTonalButton()
            MYOutlinedButton()
            MYTextButton()
            MYIconButton()
            MYFloatingActionButton()
            MYExtendedFloatingActionButton()
        }
    }
}