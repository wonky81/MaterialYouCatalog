package wonky.product.materialyoucatalog.ui.screen.actions

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.actions.*
import wonky.product.materialyoucatalog.ui.components.selection.MYSwitch
import wonky.product.materialyoucatalog.ui.components.selection.MYSwitchChecked
import wonky.product.materialyoucatalog.ui.screen.*

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


    MaterialContents {
        Overview(stringResource(R.string.overview_buttons))
        MaterialElementScreen(
            title = "Elevated Button",
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
            componentContent = {
                MYRadioButton()
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Switch Button",
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
                    text = "Enabled")
            }
        )

        MaterialElementScreen(
            title = "Segmented Button",
            componentContent = {
                MainWarningMessage(stringResource(R.string.not_available_message))
            },
            controlContent = {

            }
        )


        MaterialElementScreen(
            title = "Icon Button",
            componentContent = {
                MYIconButton(iconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(checked = iconButtonEnabled, onCheckedChange = {iconButtonEnabled = it}, text = "Enabled" )
            }
        )

        MaterialElementScreen(
            title = "Filled Icon Button",
            componentContent = {
                MYFilledIconButton(filledIconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(checked = filledIconButtonEnabled, onCheckedChange = {filledIconButtonEnabled = it}, text = "Enabled" )
            }
        )

        MaterialElementScreen(
            title = "Filled Tonal Icon Button",
            componentContent = {
                MYFilledTonalIconButton(filledTonalIconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(checked = filledTonalIconButtonEnabled, onCheckedChange = {filledTonalIconButtonEnabled = it}, text = "Enabled" )
            }
        )

        MaterialElementScreen(
            title = "Outlined Icon Button",
            componentContent = {
                MYOutlinedIconButton(outlinedIconButtonEnabled)
            },
            controlContent = {
                CheckBoxWithText(checked = outlinedIconButtonEnabled, onCheckedChange = {outlinedIconButtonEnabled = it}, text = "Enabled" )
            }
        )


        MaterialElementScreen(
            title = "Icon Toggle Button",
            componentContent = {
                MYIconToggleButton(
                    enabled = iconToggleButtonEnabled,
                    checked = iconToggleButtonChecked,
                    onCheckedChange = { iconToggleButtonChecked = it }

                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(checked = iconToggleButtonEnabled, onCheckedChange = {iconToggleButtonEnabled = it}, text = "Enabled" )
                    CheckBoxWithText(checked = iconToggleButtonChecked, onCheckedChange = {iconToggleButtonChecked = it}, text = "Checked" )
                }
             }
        )

        MaterialElementScreen(
            title = "Filled Icon Toggle Button",
            componentContent = {
                MYFilledIconToggleButton(
                    enabled = filledIconToggleButtonEnabled,
                    checked = filledIconToggleButtonChecked,
                    onCheckedChange = { filledIconToggleButtonChecked = it }
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(checked = filledIconToggleButtonEnabled, onCheckedChange = {filledIconToggleButtonEnabled = it}, text = "Enabled" )
                    CheckBoxWithText(checked = filledIconToggleButtonChecked, onCheckedChange = {filledIconToggleButtonChecked = it}, text = "Checked" )
                }

            }
        )

        MaterialElementScreen(
            title = "Filled Tonal Icon Toggle Button",
            componentContent = {
                MYFilledTonalIconToggleButton(
                    enabled = filledTonalIconToggleButtonEnabled,
                    checked = filledTonalIconToggleButtonChecked,
                    onCheckedChange = { filledTonalIconToggleButtonChecked = it }
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(checked = filledTonalIconToggleButtonEnabled, onCheckedChange = {filledTonalIconToggleButtonEnabled = it}, text = "Enabled" )
                    CheckBoxWithText(checked = filledTonalIconToggleButtonChecked, onCheckedChange = {filledTonalIconToggleButtonChecked = it}, text = "Checked" )
                }
            }
        )

        MaterialElementScreen(
            title = "Outlined Icon Toggle Button",
            componentContent = {
                MYOutlinedIconToggleButton(
                    enabled = outlinedIconToggleButtonEnabled,
                    checked = outlinedIconToggleButtonChecked,
                    onCheckedChange = { outlinedIconToggleButtonChecked = it }
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(checked = outlinedIconToggleButtonEnabled, onCheckedChange = {outlinedIconToggleButtonEnabled = it}, text = "Enabled" )
                    CheckBoxWithText(checked = outlinedIconToggleButtonChecked, onCheckedChange = {outlinedIconToggleButtonChecked = it}, text = "Checked" )
                }
            }
        )

        MaterialElementScreen(
            title = "Text Button",
            componentContent = {
                MYTextButton(
                    enabled = textButtonEnabled
                )
            },
            controlContent = {
                CheckBoxWithText(checked = textButtonEnabled, onCheckedChange = {textButtonEnabled = it}, text = "Enabled" )

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

