package wonky.product.materialyoucatalog.ui.screen.actions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
import wonky.product.materialyoucatalog.ui.components.actions.MYButton
import wonky.product.materialyoucatalog.ui.components.actions.MYElevatedButton
import wonky.product.materialyoucatalog.ui.components.actions.MYFilledIconButton
import wonky.product.materialyoucatalog.ui.components.actions.MYFilledIconToggleButton
import wonky.product.materialyoucatalog.ui.components.actions.MYFilledTonalButton
import wonky.product.materialyoucatalog.ui.components.actions.MYFilledTonalIconButton
import wonky.product.materialyoucatalog.ui.components.actions.MYFilledTonalIconToggleButton
import wonky.product.materialyoucatalog.ui.components.actions.MYIconButton
import wonky.product.materialyoucatalog.ui.components.actions.MYIconToggleButton
import wonky.product.materialyoucatalog.ui.components.actions.MYMultiChoiceSegmentedButton
import wonky.product.materialyoucatalog.ui.components.actions.MYOutlinedIconButton
import wonky.product.materialyoucatalog.ui.components.actions.MYOutlinedIconToggleButton
import wonky.product.materialyoucatalog.ui.components.actions.MYRadioButton
import wonky.product.materialyoucatalog.ui.components.actions.MYSingleChoiceSegmentedButton
import wonky.product.materialyoucatalog.ui.components.actions.MYTextButton
import wonky.product.materialyoucatalog.ui.components.selection.MYSwitch
import wonky.product.materialyoucatalog.ui.screen.CheckBoxWithText
import wonky.product.materialyoucatalog.ui.screen.ElevationLevel
import wonky.product.materialyoucatalog.ui.screen.ElevationSelector
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@Composable
fun ButtonScreen(
    onChangeBottomSheetContent: (@Composable () -> Unit) -> Unit,
    onChangeBottomSheetHeight: (Dp) -> Unit
) {


    var elevatedButtonDefaultElevation by remember { mutableStateOf(ElevationLevel.Level1) }
    var elevatedButtonDisabledElevation by remember { mutableStateOf(ElevationLevel.Level1) }
    var filledButtonDefaultElevation by remember { mutableStateOf(ElevationLevel.Level1) }
    var filledButtonDisabledElevation by remember { mutableStateOf(ElevationLevel.Level1) }
    var filledTonalButtonDefaultElevation by remember { mutableStateOf(ElevationLevel.Level1) }
    var filledTonalButtonDisabledElevation by remember { mutableStateOf(ElevationLevel.Level1) }
    var elevatedButtonEnabled by remember { mutableStateOf(true) }
    var filledButtonEnabled by remember { mutableStateOf(true) }
    var filledTonalButtonEnabled by remember { mutableStateOf(true) }
    var switchEnabled by remember { mutableStateOf(true) }
    var switchChecked by remember { mutableStateOf(true) }
    var textButtonEnabled by remember { mutableStateOf(true) }
    var iconToggleButtonEnabled by remember { mutableStateOf(true) }
    var iconToggleButtonChecked by remember { mutableStateOf(false) }
    var filledIconToggleButtonEnabled by remember { mutableStateOf(true) }
    var filledIconToggleButtonChecked by remember { mutableStateOf(false) }
    var filledTonalIconToggleButtonEnabled by remember { mutableStateOf(true) }
    var filledTonalIconToggleButtonChecked by remember { mutableStateOf(false) }
    var outlinedIconToggleButtonEnabled by remember { mutableStateOf(true) }
    var outlinedIconToggleButtonChecked by remember { mutableStateOf(false) }
    var iconButtonEnabled by remember { mutableStateOf(true) }
    var filledIconButtonEnabled by remember { mutableStateOf(true) }
    var filledTonalIconButtonEnabled by remember { mutableStateOf(true) }
    var outlinedIconButtonEnabled by remember { mutableStateOf(true) }
    var singleChoiceSegButtonEnabled by remember { mutableStateOf(true) }
    var multiChoiceSegButtonEnabled by remember { mutableStateOf(true) }
    val elevatedButtonCode by remember(
        elevatedButtonEnabled,
        elevatedButtonDefaultElevation,
        elevatedButtonDisabledElevation
    ) {
        mutableStateOf(
            """
    ElevatedButton(
        enabled = ${elevatedButtonEnabled},
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation =  ${elevatedButtonDefaultElevation}.dp,
            disabledElevation = ${elevatedButtonDisabledElevation}.dp
        )
    ){
        Text("Elevated Button")
    }
    """
        )
    }
    val elevatedButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(ElevatedButton|elevatedButtonElevation)\\s*", functionColor))
        add(Pair("(enabled\\s*=|elevation\\s*=|defaultElevation\\s*=|disabledElevation\\s*=)\\s*", parameterColor))
        add(Pair("(true|false|Level\\d+\\.\\s*dp)",valueColor))
    }


    val filledButtonCode by remember(
        filledButtonEnabled,
        filledButtonDefaultElevation,
        filledButtonDisabledElevation
    ) {
        mutableStateOf(
            """
    Button(
        enabled = ${filledButtonEnabled},
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation =  ${filledButtonDefaultElevation}.dp,
            disabledElevation = ${filledButtonDisabledElevation}.dp
        )
    ){
        Text("Button")
    }
    """
        )
    }
    val filledButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(Button\\(|buttonElevation)\\s*", functionColor))
        add(Pair("(enabled\\s*=|elevation\\s*=|defaultElevation\\s*=|disabledElevation\\s*=)\\s*", parameterColor))
        add(Pair("(true|false|Level\\d+\\.\\s*dp)",valueColor))
    }

    val filledTonalButtonCode by remember(
        filledTonalButtonEnabled,
        filledTonalButtonDefaultElevation,
        filledTonalButtonDisabledElevation
    ) {
        mutableStateOf(
            """
    FilledTonalButton(
        enabled = ${filledTonalButtonEnabled},
        elevation = ButtonDefaults.filledTonalButtonElevation(
            defaultElevation =  ${filledTonalButtonDefaultElevation}.dp,
            disabledElevation = ${filledTonalButtonDisabledElevation}.dp
        )
    ){
        Text("FilledTonal Button")
    }
    """
        )
    }
    val filledTonalButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(FilledTonalButton|filledTonalButtonElevation)\\s*", functionColor))
        add(Pair("(enabled\\s*=|elevation\\s*=|defaultElevation\\s*=|disabledElevation\\s*=)\\s*", parameterColor))
        add(Pair("(true|false|Level\\d+\\.\\s*dp)",valueColor))
    }

    val radioButtonCode =
    """
    var selected by remember { mutableStateOf(1) }
    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = selected==1 , onClick = { selected=1 })
        RadioButton(selected = selected==2 , onClick = { selected=2 })
        RadioButton(selected = selected==3 , onClick = { selected=3 })
    }
    """
    val radioButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(RadioButton|Row|remember)\\s*", functionColor))
        add(Pair("(selected\\s+=|onClick\\s*=)\\s*", parameterColor))
        add(Pair("(1|2|3\\s*)",valueColor))
    }

    val switchButtonCode =
        """
    Switch(
        enabled = ${switchEnabled},
        checked = ${switchChecked},
        onCheckedChange = { ${switchChecked} = it },
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null
        )
    }
    """
    val switchButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(Switch|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|checked\\s*=|onCheckedChange\\s*=|imageVector\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }


    val singleChoiceSegmentedButtonCode =
        """
    var selectedIndex by remember { mutableStateOf(0) }
    val options = listOf("First", "Second", "Third")
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = { selectedIndex = index },
                selected = index==selectedIndex,
                enabled = ${singleChoiceSegButtonEnabled}
            ){
                Text(label)
            }
        }
    }
    """
    val singleChoiceSegmentedButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(SingleChoiceSegmentedButtonRow|forEachIndexed|remember|SegmentedButton(?!Defaults)|itemShape|Text)\\s*", functionColor))
        add(Pair("(shape\\s*=|index\\s+=|count\\s*=|onClick\\s*=|selected\\s*=|enabled\\s*=)\\s*", parameterColor))
        add(Pair("(First|Second|Third|true|false\\s*)",valueColor))
    }


    val multiChoiceSegmentedButtonCode =
        """
    val checkedList = remember { mutableStateListOf<Int>() }
    val options = listOf("Favorites", "Trending", "Saved")
    val icons = listOf(
        Icons.Filled.StarBorder,
        Icons.AutoMirrored.Filled.TrendingUp,
        Icons.Filled.BookmarkBorder
    )
    MultiChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                icon = {
                    SegmentedButtonDefaults.Icon(active = index in checkedList) {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = null,
                            modifier = Modifier.size(SegmentedButtonDefaults.IconSize)
                        )
                    }
                },
                onCheckedChange = {
                    if (index in checkedList) {
                        checkedList.remove(index)
                    } else {
                        checkedList.add(index)
                    }
                },
                checked = index in checkedList,
                enabled = ${multiChoiceSegButtonEnabled}
            ) {
                Text(label)
            }
        }
    }
    """
    val multiChoiceSegmentedButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(MultiChoiceSegmentedButtonRow|forEachIndexed|remember|SegmentedButton(?!Defaults)|itemShape|Text|Icon(?!(Size|s))|remove|add)\\s*", functionColor))
        add(Pair("(shape\\s*=|index\\s+=|count\\s*=|icon\\s*=|checked\\s*=|enabled\\s*=|onCheckedChange|imageVector\\s*=|contentDescription\\s*=|modifier\\s*=)\\s*", parameterColor))
        add(Pair("(Favorites|Trending(?!Up)|Saved|true|false\\s*)",valueColor))
    }


    val iconButtonCode =
        """
        IconButton(
            enabled = ${iconButtonEnabled},
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val iconButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(IconButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val filledIconButtonCode =
        """
        FilledIconButton(
            enabled = ${filledIconButtonEnabled},
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val filledIconButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(FilledIconButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val filledTonalIconButtonCode =
        """
        FilledTonalIconButton(
            enabled = ${filledTonalIconButtonEnabled},
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val filledTonalIconButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(FilledTonalIconButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val outlinedIconButtonCode =
        """
        OutlinedIconButton(
            enabled = ${outlinedIconButtonEnabled},
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val outlinedIconButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(OutlinedIconButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val iconToggleButtonCode =
        """
        IconToggleButton(
            enabled = ${iconToggleButtonEnabled},
            checked = ${iconToggleButtonChecked},
            onCheckedChange = { ${iconToggleButtonChecked} = it }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val iconToggleButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(IconToggleButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=|checked\\s*=|onCheckedChange\\s*)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val filledIconToggleButtonCode =
        """
        FilledIconToggleButton(
            enabled = ${filledIconToggleButtonEnabled},
            checked = ${filledIconToggleButtonChecked},
            onCheckedChange = {${filledIconToggleButtonChecked} = it }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val filledIconToggleButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(FilledIconToggleButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=|checked\\s*=|onCheckedChange\\s*)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val filledTonalIconToggleButtonCode =
        """
        FilledTonalIconToggleButton(
            enabled = ${filledTonalIconToggleButtonEnabled},
            checked = ${filledTonalIconToggleButtonChecked},
            onCheckedChange = {${filledTonalIconToggleButtonChecked} = it }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val filledTonalIconToggleButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(FilledTonalIconToggleButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=|checked\\s*=|onCheckedChange\\s*)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val outlinedIconToggleButtonCode =
        """
        OutlinedIconToggleButton(
            enabled = ${outlinedIconToggleButtonEnabled},
            checked = ${outlinedIconToggleButtonChecked},
            onCheckedChange = {${outlinedIconToggleButtonChecked} = it }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    """
    val outlinedIconToggleButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(OutlinedIconToggleButton|Icon(?!s))\\s*", functionColor))
        add(Pair("(enabled\\s*=|contentDescription\\s*=|checked\\s*=|onCheckedChange\\s*)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }

    val textButtonCode =
        """
        TextButton(
            enabled = ${textButtonEnabled},
    
        ) {
            Text("textButton")
        }
    """
    val textButtonRegexColorList = mutableListOf<Pair<String,Color>>().apply {
        add(Pair("(TextButton(?!\")|Text)\\s*", functionColor))
        add(Pair("(enabled\\s*=)\\s*", parameterColor))
        add(Pair("(true|false\\s*)",valueColor))
    }



    MaterialContents {

        Overview(stringResource(R.string.overview_buttons))
        MaterialElementScreen(
            title = "Elevated Button",
            hasSourceCode = true,
            sourceCodeContent = {
                    Text(
                        text = colorize(elevatedButtonCode,elevatedButtonRegexColorList),
                        style = MaterialTheme.typography.bodySmall
                    )
            },
            componentContent = {
                MYElevatedButton(
                    enabled = elevatedButtonEnabled,
                    defaultElevation = elevatedButtonDefaultElevation.dp,
                    disabledElevation = elevatedButtonDisabledElevation.dp
                )
            },
            controlContent = {

                Column {
                    CheckBoxWithText(
                        checked = elevatedButtonEnabled,
                        onCheckedChange = { elevatedButtonEnabled = it },
                        text = "Enabled"
                    )
                    ElevationSelector(
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Default Elevation",
                        elevation = elevatedButtonDefaultElevation,
                        onChangeElevation = { elevatedButtonDefaultElevation = it },
                    )
                    ElevationSelector(
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Disabled Elevation",
                        elevation = elevatedButtonDisabledElevation,
                        onChangeElevation = { elevatedButtonDisabledElevation = it },
                    )
                }
            }
        )
        MaterialElementScreen(
            title = "Filled Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(filledButtonCode,filledButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYButton(
                    enabled = filledButtonEnabled,
                    defaultElevation = filledButtonDefaultElevation.dp,
                    disabledElevation = filledButtonDisabledElevation.dp
                )
            },
            controlContent = {
                Column {
                    CheckBoxWithText(
                        checked = filledButtonEnabled,
                        onCheckedChange = { filledButtonEnabled = it },
                        text = "Enabled"
                    )
                    ElevationSelector(
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Default Elevation",
                        elevation = filledButtonDefaultElevation,
                        onChangeElevation = { filledButtonDefaultElevation = it },
                    )
                    ElevationSelector(
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Disabled Elevation",
                        elevation = filledButtonDisabledElevation,
                        onChangeElevation = { filledButtonDisabledElevation = it },
                    )
                }
            }
        )
        MaterialElementScreen(
            title = "Filled Tonal Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(filledTonalButtonCode,filledTonalButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYFilledTonalButton(
                    enabled = filledTonalButtonEnabled,
                    defaultElevation = filledTonalButtonDefaultElevation.dp,
                    disabledElevation = filledTonalButtonDisabledElevation.dp
                )
            },
            controlContent = {
                Column {
                    CheckBoxWithText(
                        checked = filledTonalButtonEnabled,
                        onCheckedChange = { filledTonalButtonEnabled = it },
                        text = "Enabled"
                    )
                    ElevationSelector(
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Default Elevation",
                        elevation = filledTonalButtonDefaultElevation,
                        onChangeElevation = { filledTonalButtonDefaultElevation = it },
                    )
                    ElevationSelector(
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Disabled Elevation",
                        elevation = filledTonalButtonDisabledElevation,
                        onChangeElevation = { filledTonalButtonDisabledElevation = it },
                    )
                }

            }
        )

        MaterialElementScreen(
            title = "Radio Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(radioButtonCode,radioButtonRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {
                MYRadioButton()
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Switch Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(switchButtonCode,switchButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYSwitch(
                    enabled = switchEnabled,
                    checked = switchChecked,
                    onCheckedChange = { switchChecked = it }
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null
                    )
                }
            },
            controlContent = {
                CheckBoxWithText(
                    checked = switchEnabled,
                    onCheckedChange = { switchEnabled = it },
                    text = "Enabled"
                )
            }
        )

        MaterialElementScreen(
            title = "Single Choice Segmented Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(singleChoiceSegmentedButtonCode,singleChoiceSegmentedButtonRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {
                MYSingleChoiceSegmentedButton(singleChoiceSegButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(
                    checked = singleChoiceSegButtonEnabled,
                    onCheckedChange = { singleChoiceSegButtonEnabled = it },
                    text = "Enabled"
                )
            }
        )

        MaterialElementScreen(
            title = "Multi Choice Segmented Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(multiChoiceSegmentedButtonCode, multiChoiceSegmentedButtonRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {
                MYMultiChoiceSegmentedButton(multiChoiceSegButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(
                    checked = multiChoiceSegButtonEnabled,
                    onCheckedChange = { multiChoiceSegButtonEnabled = it },
                    text = "Enabled"
                )
            }
        )


        MaterialElementScreen(
            title = "Icon Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(iconButtonCode, iconButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYIconButton(iconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(
                    checked = iconButtonEnabled,
                    onCheckedChange = { iconButtonEnabled = it },
                    text = "Enabled"
                )
            }
        )

        MaterialElementScreen(
            title = "Filled Icon Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(filledIconButtonCode, filledIconButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYFilledIconButton(filledIconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(
                    checked = filledIconButtonEnabled,
                    onCheckedChange = { filledIconButtonEnabled = it },
                    text = "Enabled"
                )
            }
        )

        MaterialElementScreen(
            title = "Filled Tonal Icon Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(filledTonalIconButtonCode, filledTonalIconButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYFilledTonalIconButton(filledTonalIconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(
                    checked = filledTonalIconButtonEnabled,
                    onCheckedChange = { filledTonalIconButtonEnabled = it },
                    text = "Enabled"
                )
            }
        )

        MaterialElementScreen(
            title = "Outlined Icon Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(outlinedIconButtonCode, outlinedIconButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYOutlinedIconButton(outlinedIconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(
                    checked = outlinedIconButtonEnabled,
                    onCheckedChange = { outlinedIconButtonEnabled = it },
                    text = "Enabled"
                )
            }
        )


        MaterialElementScreen(
            title = "Icon Toggle Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(iconToggleButtonCode, iconToggleButtonRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYIconToggleButton(
                    enabled = iconToggleButtonEnabled,
                    checked = iconToggleButtonChecked,
                    onCheckedChange = { iconToggleButtonChecked = it }

                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = iconToggleButtonEnabled,
                        onCheckedChange = { iconToggleButtonEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = iconToggleButtonChecked,
                        onCheckedChange = { iconToggleButtonChecked = it },
                        text = "Checked"
                    )
                }
            }
        )

        MaterialElementScreen(
            title = "Filled Icon Toggle Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        filledIconToggleButtonCode,
                        filledIconToggleButtonRegexColorList
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYFilledIconToggleButton(
                    enabled = filledIconToggleButtonEnabled,
                    checked = filledIconToggleButtonChecked,
                    onCheckedChange = { filledIconToggleButtonChecked = it }
                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = filledIconToggleButtonEnabled,
                        onCheckedChange = { filledIconToggleButtonEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = filledIconToggleButtonChecked,
                        onCheckedChange = { filledIconToggleButtonChecked = it },
                        text = "Checked"
                    )
                }

            }
        )

        MaterialElementScreen(
            title = "Filled Tonal Icon Toggle Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        filledTonalIconToggleButtonCode,
                        filledTonalIconToggleButtonRegexColorList
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYFilledTonalIconToggleButton(
                    enabled = filledTonalIconToggleButtonEnabled,
                    checked = filledTonalIconToggleButtonChecked,
                    onCheckedChange = { filledTonalIconToggleButtonChecked = it }
                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = filledTonalIconToggleButtonEnabled,
                        onCheckedChange = { filledTonalIconToggleButtonEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = filledTonalIconToggleButtonChecked,
                        onCheckedChange = { filledTonalIconToggleButtonChecked = it },
                        text = "Checked"
                    )
                }
            }
        )

        MaterialElementScreen(
            title = "Outlined Icon Toggle Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        outlinedIconToggleButtonCode,
                        outlinedIconToggleButtonRegexColorList
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYOutlinedIconToggleButton(
                    enabled = outlinedIconToggleButtonEnabled,
                    checked = outlinedIconToggleButtonChecked,
                    onCheckedChange = { outlinedIconToggleButtonChecked = it }
                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = outlinedIconToggleButtonEnabled,
                        onCheckedChange = { outlinedIconToggleButtonEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = outlinedIconToggleButtonChecked,
                        onCheckedChange = { outlinedIconToggleButtonChecked = it },
                        text = "Checked"
                    )
                }
            }
        )

        MaterialElementScreen(
            title = "Text Button",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        textButtonCode,
                        textButtonRegexColorList
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYTextButton(
                    enabled = textButtonEnabled
                )
            },
            controlContent = {
                CheckBoxWithText(
                    checked = textButtonEnabled,
                    onCheckedChange = { textButtonEnabled = it },
                    text = "Enabled"
                )

            }
        )
    }

    LaunchedEffect(true) {
        onChangeBottomSheetHeight(320.dp)
    }
    onChangeBottomSheetContent {
        ControlScreen(
            buttonEnabled = filledTonalButtonEnabled,
            defaultElevation = elevatedButtonDefaultElevation.dp.value,
            pressedElevation = elevatedButtonDefaultElevation.dp.value,
            disabledElevation = elevatedButtonDefaultElevation.dp.value,
            onChangeDefaultElevation = { },
            onChangePressedElevation = {},
            onChangeDisabledElevation = { },
            onChangeButtonEnabled = { filledTonalButtonEnabled = it }
        )
    }

}

@Composable
fun ControlScreen(
    buttonEnabled: Boolean,
    defaultElevation: Float,
    pressedElevation: Float,
    disabledElevation: Float,
    onChangeDefaultElevation: (value: Float) -> Unit,
    onChangePressedElevation: (value: Float) -> Unit,
    onChangeDisabledElevation: (value: Float) -> Unit,
    onChangeButtonEnabled: (isEnabled: Boolean) -> Unit,

    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text("Default Elevation : (${defaultElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(
            value = defaultElevation,
            steps = 13,
            valueRange = 0f..12f,
            onValueChange = onChangeDefaultElevation
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text("Pressed Elevation : (${pressedElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(
            value = pressedElevation,
            steps = 13,
            valueRange = 0f..12f,
            onValueChange = onChangePressedElevation
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text("Disabled Elevation : (${disabledElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(
            value = disabledElevation,
            steps = 13,
            valueRange = 0f..12f,
            onValueChange = onChangeDisabledElevation
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text("Button Enabled")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Switch(checked = buttonEnabled, onCheckedChange = onChangeButtonEnabled)
    }


}

