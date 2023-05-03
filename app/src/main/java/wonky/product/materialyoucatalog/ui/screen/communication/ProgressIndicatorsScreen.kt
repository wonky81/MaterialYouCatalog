package wonky.product.materialyoucatalog.ui.screen.communication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.communication.MYCircularProgressIndicator
import wonky.product.materialyoucatalog.ui.components.communication.MYLinearProgressIndicator
import wonky.product.materialyoucatalog.ui.components.communication.MyDeterminateCircularProgressIndicator
import wonky.product.materialyoucatalog.ui.components.communication.MyDeterminateLinearProgressIndicator
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@Composable
fun ProgressIndicatorScreen() {

    var determinateLinearIndicatorProgress by remember { mutableStateOf(0f) }
    var determinateCircularIndicatorProgress by remember { mutableStateOf(0f) }

    MaterialContents {
        Overview(stringResource(R.string.overview_progress_indicators))
        MaterialElementScreen(
            title = "Indeterminate Linear Progress Indicator",
            componentContent = {
                MYLinearProgressIndicator()
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Indeterminate Circular Progress Indicator",
            componentContent = {
                MYCircularProgressIndicator()
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Determinate Linear Progress Indicator",
            componentContent = {
                MyDeterminateLinearProgressIndicator(progress = determinateLinearIndicatorProgress)
            },
            controlContent = {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Text("Value : ${"%.2f".format(determinateLinearIndicatorProgress)}")
                    Spacer(modifier = Modifier.width(12.dp))
                    Slider(
                        value = determinateLinearIndicatorProgress,
                        onValueChange = { determinateLinearIndicatorProgress = it}
                    )
                }
            }
        )

        MaterialElementScreen(
            title = "Determinate Circular Progress Indicator",
            componentContent = {
                MyDeterminateCircularProgressIndicator(progress = determinateCircularIndicatorProgress)
            },
            controlContent = {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Text("Value : ${"%.2f".format(determinateCircularIndicatorProgress)}")
                    Spacer(modifier = Modifier.width(12.dp))
                    Slider(
                        value = determinateCircularIndicatorProgress,
                        onValueChange = { determinateCircularIndicatorProgress = it}
                    )
                }

            }
        )
    }
}