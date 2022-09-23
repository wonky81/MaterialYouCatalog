package wonky.product.materialyoucatalog.ui.screen.navigation

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
import wonky.product.materialyoucatalog.ui.components.navigation.*
import wonky.product.materialyoucatalog.ui.screen.*

enum class KindTopAppBar{
    CenterAligned,
    Large,
    Medium,
    Small
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AppBarScreen() {
    var seeTopAppBarShowCase by remember { mutableStateOf(false)  }
    var kindShowCase by remember { mutableStateOf(KindTopAppBar.CenterAligned)  }

    var fabShow by remember { mutableStateOf(true) }
    var appBarElevation by remember { mutableStateOf(ElevationLevel.Level2) }
    var seeBottomAppBarShowCase by remember { mutableStateOf(false)  }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_appbar))

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
                        onClick = { seeBottomAppBarShowCase = true }
                    ) {
                        Text("Show Case")
                    }
                }
                Spacer6()

            }
        )

        MaterialElementScreen(
            title = "Center Aligned TopAppBar",
            componentContent = {
                MYCenterAlignedTopAppBar(
                    modifier = Padding6h()
                )
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.CenterAligned
                        seeTopAppBarShowCase = true
                    }
                ) {
                    Text("Show Case")
                }

            }
        )
        MaterialElementScreen(
            title = "Large TopAppBar",
            componentContent = {
                MYLargeTopAppBar(
                    modifier = Padding6h()
                )
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.Large
                        seeTopAppBarShowCase = true
                    }
                ) {
                    Text("Show Case")
                }
            }
        )
        MaterialElementScreen(
            title = "Medium TopAppBar",
            componentContent = {
                MYMediumTopAppBar(
                    modifier = Padding6h()
                )
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.Medium
                        seeTopAppBarShowCase = true
                    }
                ) {
                    Text("Show Case")
                }
            }
        )
        MaterialElementScreen(
            title = "Small TopAppBar",
            componentContent = {
                MYSmallTopAppBar(
                    modifier = Padding6h()
                )
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.Small
                        seeTopAppBarShowCase = true
                    }
                ) {
                    Text("Show Case")
                }
            }
        )

        if(seeTopAppBarShowCase){
            Dialog(
                properties = DialogProperties(usePlatformDefaultWidth = false),
                onDismissRequest = { seeTopAppBarShowCase = false }
            ) {
                Surface(modifier = Modifier.fillMaxHeight()) {
                    DialogCloseButton(
                        onClick = { seeTopAppBarShowCase = false },
                        position = Alignment.Center
                    )
                    when(kindShowCase){
                        KindTopAppBar.CenterAligned -> {
                            MYCenterAlignedTopAppBar()
                        }
                        KindTopAppBar.Large ->{
                            MYLargeTopAppBar()

                        }
                        KindTopAppBar.Medium -> {
                            MYMediumTopAppBar()

                        }
                        KindTopAppBar.Small -> {
                            MYSmallTopAppBar()

                        }
                    }
                }
            }
        }

        if(seeBottomAppBarShowCase){
            Dialog(
                properties = DialogProperties(usePlatformDefaultWidth = false),
                onDismissRequest = { seeBottomAppBarShowCase = false }
            ) {
                Surface(modifier = Modifier.fillMaxHeight()) {
                    DialogCloseButton(
                        onClick = { seeBottomAppBarShowCase = false }
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