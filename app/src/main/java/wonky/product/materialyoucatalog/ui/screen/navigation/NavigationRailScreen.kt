package wonky.product.materialyoucatalog.ui.screen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.navigation.MYBottomAppBar
import wonky.product.materialyoucatalog.ui.components.navigation.MYNavigationRail
import wonky.product.materialyoucatalog.ui.screen.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavigationRailScreen() {
    var showLabel by remember { mutableStateOf(true) }
    var seeShowCase by remember { mutableStateOf(false)  }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_navigationrail))
        MaterialElementScreen(
            title = "Navigation Rail",
            componentContent = {
                MYNavigationRail(
                    headerString = "Header",
                    showLabel = showLabel
                )
            },
            controlContent = {
                CheckBoxWithText(
                    checked = showLabel,
                    onCheckedChange = { showLabel = it },
                    text = "Always Show Label"
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
                    MYNavigationRail(
                        headerString = "Header",
                        showLabel = showLabel
                    )
                }
            }
        }
        
    }
}