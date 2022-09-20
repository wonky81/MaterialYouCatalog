package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.containment.MYElevatedCard
import wonky.product.materialyoucatalog.ui.components.containment.MYFilledCard
import wonky.product.materialyoucatalog.ui.components.containment.MYOutlinedCard
import wonky.product.materialyoucatalog.ui.screen.ElevationLevel
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview


private const val TAG = "CardScreen"


@Composable
fun CardScreen(
    onChangeBottomSheetContent: (@Composable () -> Unit) -> Unit,
    onChangeBottomSheetHeight: (Dp) -> Unit
) {

    MaterialContents {
        Overview(stringResource(R.string.overview_card))
        MaterialElementScreen(
            title = "Filled Card",
            componentContent = {
                ElevationLevel.values().forEach {
                    MYFilledCard(
                        text = "Filled Card ( ${it.dp} )",
                        defaultElevation = it.dp,
                        disabledElevation =  it.dp
                    )
                }
            },
            controlContent = {

            }
        )
        MaterialElementScreen(
            title = "Elevated Card",
            componentContent = {
                ElevationLevel.values().forEach {
                    MYElevatedCard(
                        text = "Elevated Card ( ${it.dp} )",
                        defaultElevation = it.dp,
                        disabledElevation =  it.dp
                    )
                }
            },
            controlContent = {

            }
        )
        MaterialElementScreen(
            title = "Outlined Card",
            componentContent = {
                ElevationLevel.values().forEach {
                    MYOutlinedCard(
                        text = "Outlined Card ( ${it.dp} )",
                        defaultElevation = it.dp,
                        disabledElevation =  it.dp
                    )
                }
            },
            controlContent = {

            }
        )

    }
}

@Composable
fun ControlScreen(
    cardDefaultElevation: Float,
    pressedElevation: Float,
    disabledElevation: Float,
    onChangeDefaultElevation: (value:Float) -> Unit,
    onChangePressedElevation: (value:Float) -> Unit,
    onChangeDisabledElevation: (value:Float) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Default Elevation : (${cardDefaultElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = cardDefaultElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangeDefaultElevation)
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
}

