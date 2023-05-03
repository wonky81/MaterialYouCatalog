package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.RichTooltipState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ToolTipScreen() {

    MaterialContents {
        Overview(content = stringResource(R.string.overview_tooltip))
        MaterialElementScreen(
            title = "Plain Tooltip",
            componentContent = {
                Column {
                    PlainTooltipBox(tooltip = {
                        Text("Plain tooltip")
                    }) {
                        IconButton(
                            modifier = Modifier.tooltipAnchor(),
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

        val richTooltipState = remember { RichTooltipState()}
        val composableScope = rememberCoroutineScope()

        MaterialElementScreen(
            title = "Rich Tooltip",
            componentContent = {
                Column {
                    RichTooltipBox(
                        text = { Text(stringResource(R.string.rich_tooltips_message))},
                        title = { Text("Rich tooltip")},
                        action = {
                            TextButton(onClick = {
                                composableScope.launch {
                                    richTooltipState.dismiss()
                                }
                            }) {
                                Text("I understood")
                            }
                        },
                        tooltipState = richTooltipState
                    ) {
                        IconButton(
                            modifier = Modifier.tooltipAnchor(),
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