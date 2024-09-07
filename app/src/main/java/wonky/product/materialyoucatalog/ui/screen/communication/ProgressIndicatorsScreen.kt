package wonky.product.materialyoucatalog.ui.screen.communication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
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

    val linearProgressIndicatorCode =
        """
        LinearProgressIndicator()
    """
    val linearProgressIndicatorRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(LinearProgressIndicator)\\s*", functionColor))
    }

    val circularProgressIndicatorCode =
        """
        CircularProgressIndicator()
    """
    val circularProgressIndicatorRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(CircularProgressIndicator)\\s*", functionColor))
    }

    val determinateLinearProgressIndicatorCode =
        """
        LinearProgressIndicator(progress = ${determinateLinearIndicatorProgress})
    """
    val determinateLinearProgressIndicatorRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(LinearProgressIndicator)\\s*", functionColor))
        add(Pair("(progress\\s*=)\\s*", parameterColor))
    }

    val determinateCircularProgressIndicatorCode =
        """
        CircularProgressIndicator(progress = ${determinateCircularIndicatorProgress})
    """
    val determinateCircularProgressIndicatorRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(CircularProgressIndicator)\\s*", functionColor))
        add(Pair("(progress\\s*=)\\s*", parameterColor))
    }




    MaterialContents {
        Overview(stringResource(R.string.overview_progress_indicators))
        MaterialElementScreen(
            title = "Indeterminate Linear Progress",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(linearProgressIndicatorCode, linearProgressIndicatorRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYLinearProgressIndicator()
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Indeterminate Circular Progress",
            hasSourceCode = true,
            sourceCodeContent ={
                Text(
                    text = colorize(circularProgressIndicatorCode, circularProgressIndicatorRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                MYCircularProgressIndicator()
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Determinate Linear Progress",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(determinateLinearProgressIndicatorCode, determinateLinearProgressIndicatorRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
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
            title = "Determinate Circular Progress",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        determinateCircularProgressIndicatorCode,
                        determinateCircularProgressIndicatorRegexColorList
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            },
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