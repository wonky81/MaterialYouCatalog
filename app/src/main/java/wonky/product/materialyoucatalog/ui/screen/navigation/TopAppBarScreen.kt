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
fun TopAppBarScreen() {
    var seeShowCase by remember { mutableStateOf(false)  }
    var kindShowCase by remember { mutableStateOf(KindTopAppBar.CenterAligned)  }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_topappbar))
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
                        seeShowCase = true
                    }
                ) {
                    Text("Show Case")
                }

            }
        )
        MaterialElementScreen(
            title = "Large TopAppBar",
            componentContent = {
                MYLargeTopAppBar()
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.Large
                        seeShowCase = true
                    }
                ) {
                    Text("Show Case")
                }
            }
        )
        MaterialElementScreen(
            title = "Medium TopAppBar",
            componentContent = {
                MYMediumTopAppBar()
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.Medium
                        seeShowCase = true
                    }
                ) {
                    Text("Show Case")
                }
            }
        )
        MaterialElementScreen(
            title = "Small TopAppBar",
            componentContent = {
                MYSmallTopAppBar()
            },
            controlContent = {
                FilledTonalButton(
                    onClick = {
                        kindShowCase = KindTopAppBar.Small
                        seeShowCase = true
                    }
                ) {
                    Text("Show Case")
                }
            }
        )

        if(seeShowCase){
            Dialog(
                properties = DialogProperties(usePlatformDefaultWidth = false),
                onDismissRequest = { seeShowCase = false }
            ) {
                Surface(modifier = Modifier.fillMaxHeight()) {
                    DialogCloseButton(
                        onClick = { seeShowCase = false },
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
    }
}