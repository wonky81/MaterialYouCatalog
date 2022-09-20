package wonky.product.materialyoucatalog.ui.screen.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.navigation.MYBottomAppBar
import wonky.product.materialyoucatalog.ui.screen.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BottomAppBarScreen(

){
    var fabShow by remember { mutableStateOf(true) }
    var appBarElevation by remember { mutableStateOf(ElevationLevel.Level2) }
    var seeShowCase by remember { mutableStateOf(false)  }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_bottomappbar))
        MaterialElementScreen(
            title = "Bottom App Bar",
            componentContent = {
                MYBottomAppBar(
                    modifier = Padding6h(),
                    fabShow = fabShow,
                    tonalElevation = appBarElevation.dp
                )
            },
            controlContent = {
                CheckBoxWithText(
                    checked = fabShow,
                    onCheckedChange = { fabShow = it },
                    text = "FAB Show"
                )
                ElevationSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "Elevation",
                    elevation = appBarElevation,
                    onChangeElevation = { appBarElevation = it},
                )
                Spacer6()
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    FilledTonalButton(
                        onClick = { seeShowCase = true }
                    ) {
                        Text("Show Case")
                    }
                }
                Spacer6()

            }
        )
        if(seeShowCase){
            Dialog(
                properties = DialogProperties(usePlatformDefaultWidth = false),
                onDismissRequest = { seeShowCase = false }
            ) {
                Surface(modifier = Modifier.fillMaxHeight()) {
                    DialogCloseButton(
                        onClick = { seeShowCase = false }
                    )
                    MYBottomAppBar(
                        fabShow = fabShow,
                        tonalElevation = appBarElevation.dp
                    )
                }
            }
        }
        
    }
}