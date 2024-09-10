package wonky.product.materialyoucatalog.ui.screen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
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

    val bottomAppBarCode =
        """
        BottomAppBar(
            modifier = Modifier.padding(horizontal = 6.dp),
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = null
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = null
                    )
                }
            },
            floatingActionButton = {
                if(${fabShow}){
                    FloatingActionButton(
                        onClick = {},
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = null
                        )
                    }
                }

            },
            tonalElevation = ${appBarElevation.dp}
        )
    """
    val bottomAppBarRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(BottomAppBar(?!D)|IconButton|padding|FloatingActionButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(tonalElevation\\s*=|containerColor\\s*=|modifier\\s*=|actions\\s*=|horizontal\\s*=|contentDescription\\s*=|floatingActionButton\\s*=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(true|false|6.dp|null\\s*)", valueColor))
    }

    val centerAlignedAppBarCode =
        """
        CenterAlignedTopAppBar(
            modifier = Modifier.padding(horizontal = 6.dp),
            title = { Text("Title")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu,null)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Settings,null)
                }

            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            ),
        )
    """
    val centerAlignedAppBarRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(padding|CenterAlignedTopAppBar|Text|IconButton|centerAlignedTopAppBarColors|Icon(?!s))\\s*", functionColor))
        add(Pair("(horizontal\\s*=|actionIconContentColor\\s*=|navigationIconContentColor\\s*=|title\\s*=|containerColor\\s*=|modifier\\s*=|actions\\s*=|titleContentColor\\s*=|navigationIcon\\s*=|colors\\s*=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(6.dp|null\\s*)", valueColor))
    }

    val largeTopAppBarCode =
        """
        LargeTopAppBar(
            modifier = Modifier.padding(horizontal = 6.dp),
            title = { Text("Title")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu,null)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Settings,null)
                }

            },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    """
    val largeTopAppBarRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(padding|LargeTopAppBar|Text|IconButton|largeTopAppBarColors|Icon(?!s))\\s*", functionColor))
        add(Pair("(horizontal\\s*=|actionIconContentColor\\s*=|navigationIconContentColor\\s*=|title\\s*=|containerColor\\s*=|modifier\\s*=|actions\\s*=|titleContentColor\\s*=|navigationIcon\\s*=|colors\\s*=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(6.dp|null\\s*)", valueColor))
    }

    val mediumTopAppBarCode =
        """
        MediumTopAppBar(
            modifier = Modifier.padding(horizontal = 6.dp),
            title = { Text("Title")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu,null)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Settings,null)
                }

            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    """
    val mediumTopAppBarRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(padding|LargeTopAppBar|Text|IconButton|mediumTopAppBarColors|Icon(?!s))\\s*", functionColor))
        add(Pair("(horizontal\\s*=|actionIconContentColor\\s*=|navigationIconContentColor\\s*=|title\\s*=|containerColor\\s*=|modifier\\s*=|actions\\s*=|titleContentColor\\s*=|navigationIcon\\s*=|colors\\s*=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(6.dp|null\\s*)", valueColor))
    }

    val smallTopAppBarCode =
        """
        TopAppBar(
            modifier = Modifier.padding(horizontal = 6.dp),
            title = { Text("Title")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu,null)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Settings,null)
                }

            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    """
    val smallTopAppBarRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(padding|TopAppBar|Text|IconButton|topAppBarColors|Icon(?!s))\\s*", functionColor))
        add(Pair("(horizontal\\s*=|actionIconContentColor\\s*=|navigationIconContentColor\\s*=|title\\s*=|containerColor\\s*=|modifier\\s*=|actions\\s*=|titleContentColor\\s*=|navigationIcon\\s*=|colors\\s*=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(6.dp|null\\s*)", valueColor))
    }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_appbar))

        MaterialElementScreen(
            title = "Bottom App Bar",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(bottomAppBarCode,bottomAppBarRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(centerAlignedAppBarCode,centerAlignedAppBarRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(largeTopAppBarCode,largeTopAppBarRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(mediumTopAppBarCode,mediumTopAppBarRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(smallTopAppBarCode,smallTopAppBarRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {
                MYTopAppBar(
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
                            MYTopAppBar()

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