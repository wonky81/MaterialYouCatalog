package wonky.product.materialyoucatalog.ui.screen.selection

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.selection.MYDiscreteSlider
import wonky.product.materialyoucatalog.ui.components.selection.MYRangeSlider
import wonky.product.materialyoucatalog.ui.components.selection.MYSlider
import wonky.product.materialyoucatalog.ui.screen.*

@Composable
fun SliderScreen() {
    var continuousSliderEnabled by remember { mutableStateOf(true) }
    var continuousSliderValue by remember { mutableStateOf(0.0f) }

    var discreteSliderEnabled by remember { mutableStateOf(true) }
    var discreteSliderValue by remember { mutableStateOf(10.0f) }
    var discreteSliderSteps by remember { mutableStateOf(9) }

    var rangeSliderEnabled by remember { mutableStateOf(true) }
    var rangeSliderValue by remember { mutableStateOf(0.0f..10.0f) }
    var rangeSliderSteps by remember { mutableStateOf(9) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_sliders))
        MaterialElementScreen(
            title = "Continuous Slider",
            componentContent = {
                MYSlider(
                    modifier = Padding6h(),
                    enabled = continuousSliderEnabled,
                    value = continuousSliderValue,
                    onValueChange = { continuousSliderValue = it}
                )
            },
            controlContent = {
                CheckBoxWithText(
                    checked = continuousSliderEnabled,
                    onCheckedChange = { continuousSliderEnabled = it},
                    text = "Enabled")
                Row(modifier = Modifier.padding(start = 12.dp)){
                    Text(
                        text = "Slider Value : "
                    )
                    Text(
                        text = continuousSliderValue.toString()
                    )
                }

            }
        )

        MaterialElementScreen(
            title = "Discrete Slider",
            componentContent = {
                MYDiscreteSlider(
                    modifier = Padding6h(),
                    enabled = discreteSliderEnabled,
                    value = discreteSliderValue,
                    steps = discreteSliderSteps,
                    onValueChange = { discreteSliderValue = it}
                )
            },
            controlContent = {
                CheckBoxWithText(
                    checked = discreteSliderEnabled,
                    onCheckedChange = { discreteSliderEnabled = it},
                    text = "Enabled")
                Row(modifier = Modifier.padding(start = 12.dp)){
                    Text(
                        text = "Slider Value : "
                    )
                    Text(
                        text = discreteSliderValue.toString()
                    )
                }
                Row(modifier = Modifier.padding(start = 12.dp)){
                    Text(
                        text = "Slider Steps : "
                    )
                    Text(
                        text = discreteSliderSteps.toString()
                    )
                }

            }
        )

        MaterialElementScreen(
            title = "Range Slider",
            componentContent = {
                MYRangeSlider(
                    modifier = Padding6h(),
                    enabled = rangeSliderEnabled,
                    value = rangeSliderValue,
                    steps = rangeSliderSteps,
                    onValueChange = { rangeSliderValue = it}
                )
            },
            controlContent = {
                CheckBoxWithText(
                    checked = rangeSliderEnabled,
                    onCheckedChange = { rangeSliderEnabled = it},
                    text = "Enabled")
                Row(modifier = Modifier.padding(start = 12.dp)){
                    Text(
                        text = "Slider Value : "
                    )
                    Text(
                        text = rangeSliderValue.toString()
                    )
                }
                Row(modifier = Modifier.padding(start = 12.dp)){
                    Text(
                        text = "Slider Steps : "
                    )
                    Text(
                        text = rangeSliderSteps.toString()
                    )
                }

            }
        )
    }
}
