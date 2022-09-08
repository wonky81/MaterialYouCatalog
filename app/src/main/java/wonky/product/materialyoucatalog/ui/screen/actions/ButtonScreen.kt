package wonky.product.materialyoucatalog.ui.screen.actions

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.actions.MYButton
import wonky.product.materialyoucatalog.ui.components.actions.MYElevatedButton
import wonky.product.materialyoucatalog.ui.components.actions.MYFilledTonalButton
import wonky.product.materialyoucatalog.ui.screen.*

@Composable
fun ButtonScreen(
    onChangeBottomSheetContent: (@Composable () -> Unit) -> Unit,
    onChangeBottomSheetHeight: (Dp) -> Unit
) {
    var elevatedButtonDefaultElevation by remember{ mutableStateOf(ElevationLevel.Level1) }
    var elevatedButtonDisabledElevation by remember{ mutableStateOf(ElevationLevel.Level1) }
    var elevatedButtonEnabled by remember{ mutableStateOf(true) }
    var filledButtonEnabled by remember{ mutableStateOf(true) }
    var filledTonalButtonEnabled by remember{ mutableStateOf(true) }

    MaterialContents {
        Overview(stringResource(R.string.overview_buttons))
        MaterialElementScreen(
            title = "Elevated Button",
            componentContent = {
                MYElevatedButton(
                    enabled = elevatedButtonEnabled,
                    elevation = ButtonDefaults
                        .elevatedButtonElevation(
                            defaultElevation = elevatedButtonDefaultElevation.dp,
                            pressedElevation = 1.dp,
                            focusedElevation = 1.dp,
                            hoveredElevation = 3.dp,
                            disabledElevation = elevatedButtonDisabledElevation.dp
                        )
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(
                        checked = elevatedButtonEnabled,
                        onCheckedChange = { elevatedButtonEnabled = it },
                        text = "Enabled"
                    )
                }
            }
        )
        MaterialElementScreen(
            title = "Filled Button",
            componentContent = {
                MYButton(
                    enabled = filledButtonEnabled,
                    elevation = ButtonDefaults.buttonElevation()
                )
            },
            controlContent = {

            }
        )
        MaterialElementScreen(
            title = "Filled Tonal Button",
            componentContent = {
                MYFilledTonalButton(
                    enabled = filledTonalButtonEnabled,
                    elevation = ButtonDefaults.filledTonalButtonElevation()
                )
            },
            controlContent = {

            }
        )
        LaunchedEffect(true) {
            onChangeBottomSheetHeight(320.dp)
        }
        onChangeBottomSheetContent{
            ControlScreen(
                buttonEnabled = filledTonalButtonEnabled,
                defaultElevation = elevatedButtonDefaultElevation.dp.value,
                pressedElevation = elevatedButtonDefaultElevation.dp.value,
                disabledElevation = elevatedButtonDefaultElevation.dp.value,
                onChangeDefaultElevation = { },
                onChangePressedElevation = {},
                onChangeDisabledElevation = { },
                onChangeButtonEnabled = { filledTonalButtonEnabled = it}
            )
        }

    }
}

@Composable
fun ControlScreen(
    buttonEnabled: Boolean,
    defaultElevation: Float,
    pressedElevation: Float,
    disabledElevation: Float,
    onChangeDefaultElevation: (value:Float) -> Unit,
    onChangePressedElevation: (value:Float) -> Unit,
    onChangeDisabledElevation: (value:Float) -> Unit,
    onChangeButtonEnabled: (isEnabled: Boolean) -> Unit,

){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Default Elevation : (${defaultElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = defaultElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangeDefaultElevation)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Pressed Elevation : (${pressedElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = pressedElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangePressedElevation)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Disabled Elevation : (${disabledElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = disabledElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangeDisabledElevation)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Button Enabled")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Switch(checked = buttonEnabled, onCheckedChange = onChangeButtonEnabled)
    }


}

