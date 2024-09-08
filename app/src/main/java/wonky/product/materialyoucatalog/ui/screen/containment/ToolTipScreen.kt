package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ToolTipScreen() {
    val tooltipState = rememberTooltipState(isPersistent = true)
    val composableScope = rememberCoroutineScope()


    val tooltipBoxCode =
        """
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip{
                    Text("Plain tooltip")
                }
            },
            state = rememberTooltipState()
        ){
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccessTime,
                    contentDescription = null
                )
            }
        }
    """
    val tooltipBoxRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(TooltipBox|IconButton|rememberPlainTooltipPositionProvider|rememberTooltipState|PlainTooltip|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(positionProvider\\s*=|tooltip\\s*=|state\\s*=|imageVector\\s*=|contentDescription\\s*=|onClick\\s*=)\\s*", parameterColor))
    }

    val richTooltipBoxCode =
        """
        TooltipBox(
            positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
            tooltip = {
                RichTooltip{
                    Text(stringResource(R.string.rich_tooltips_message))
                }
            },
            state = rememberTooltipState()
        ){
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccessTime,
                    contentDescription = null
                )
            }
        }
    """
    val richTooltipBoxRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(TooltipBox|rememberRichTooltipPositionProvider|RichTooltip|rememberTooltipState|IconButton|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(positionProvider\\s*=|tooltip\\s*=|state\\s*=|imageVector\\s*=|contentDescription\\s*=|onClick\\s*=)\\s*", parameterColor))
    }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_tooltip))
        MaterialElementScreen(
            title = "Plain Tooltip",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(tooltipBoxCode,tooltipBoxRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                Column {
                    TooltipBox(
                        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                        tooltip = {
                            PlainTooltip{
                                Text("Plain tooltip")
                            }
                        },
                        state = rememberTooltipState()
                    ){
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.AccessTime,
                                contentDescription = null
                            )
                        }
                    }
                }
            },
            controlContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Long press on the icon above to see a tooltip.")
                }
            }
        )

        MaterialElementScreen(
            title = "Rich Tooltip",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(richTooltipBoxCode,richTooltipBoxRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
            componentContent = {
                Column {
                    TooltipBox(
                        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                        tooltip = {
                            RichTooltip{
                                Text(stringResource(R.string.rich_tooltips_message))
                            }
                        },
                        state = rememberTooltipState()
                    ){
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.AccessTime,
                                contentDescription = null
                            )
                        }
                    }
                }

            },
            controlContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Long press on the icon above to see a tooltip.")
                }
            }
        )
    }
}