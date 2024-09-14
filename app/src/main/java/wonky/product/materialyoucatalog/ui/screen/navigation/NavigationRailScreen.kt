package wonky.product.materialyoucatalog.ui.screen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
import wonky.product.materialyoucatalog.ui.components.navigation.MYBottomAppBar
import wonky.product.materialyoucatalog.ui.components.navigation.MYNavigationRail
import wonky.product.materialyoucatalog.ui.screen.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavigationRailScreen() {
    var showLabel by remember { mutableStateOf(true) }
    var seeShowCase by remember { mutableStateOf(false)  }

    val navigationRailCode =
        """
        var selectedMenu by remember { mutableStateOf(1) }
    
        NavigationRail(
            header = {
                     Text("Header")
            },
            content = {
                NavigationRailItem(
                    selected = selectedMenu == 1,
                    alwaysShowLabel = $showLabel,
                    icon = { Icon(Icons.Filled.Add,null) },
                    label = { Text("Item 1")},
                    onClick = { selectedMenu = 1 }
                )
                NavigationRailItem(
                    selected = selectedMenu == 2,
                    alwaysShowLabel = $showLabel,
                    icon = { Icon(Icons.Filled.Call,null) },
                    label = { Text("Item 2")},
                    onClick = { selectedMenu = 2 }
                )
                NavigationRailItem(
                    selected = selectedMenu == 3,
                    alwaysShowLabel = $showLabel,
                    icon = { Icon(Icons.Filled.Notifications,null) },
                    label = { Text("Item 3")},
                    onClick = { selectedMenu = 3 }
                )
            }
        )
    """
    val navigationRailRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(NavigationRailItem|NavigationRail|mutableStateOf|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(label\\s*=|header\\s*=|content\\s*=|selected(?!M)\\s*=|alwaysShowLabel\\s*=|icon\\s*=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(Header|Item 1|Item 2|Item 3|1|2|3|true|false|null\\s*)", valueColor))
    }


    MaterialContents {
        Overview(content = stringResource(R.string.overview_navigationrail))
        MaterialElementScreen(
            title = "Navigation Rail",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(navigationRailCode,navigationRailRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
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