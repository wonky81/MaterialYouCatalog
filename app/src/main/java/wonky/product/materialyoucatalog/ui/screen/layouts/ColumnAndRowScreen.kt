package wonky.product.materialyoucatalog.ui.screen.layouts

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.screen.AlignmentHorizontalPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.AlignmentVerticalPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.ArrangementHorizontalPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.ArrangementVerticalPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview
import wonky.product.materialyoucatalog.ui.screen.Spacer16v
import wonky.product.materialyoucatalog.ui.screen.Spacer4h

enum class ArrangementHorizontalProperties(val arrangementHorizontal: Arrangement.Horizontal) {
    Center(Arrangement.Center),
    SpaceEvenly(Arrangement.SpaceEvenly),
    SpaceBetween(Arrangement.SpaceBetween),
    SpaceAround(Arrangement.SpaceAround),
    Start(Arrangement.Start),
    End(Arrangement.End)
}

enum class ArrangementVerticalProperties(val arrangementVertical: Arrangement.Vertical) {
    Center(Arrangement.Center),
    Top(Arrangement.Top),
    Bottom(Arrangement.Bottom),
    SpaceEvenly(Arrangement.SpaceEvenly),
    SpaceBetween(Arrangement.SpaceBetween),
    SpaceAround(Arrangement.SpaceAround),
}

enum class AlignmentHorizontalProperties(val alignmentHorizontal: Alignment.Horizontal) {
    CenterHorizontally(Alignment.CenterHorizontally),
    End(Alignment.End),
    Start(Alignment.Start)
}

enum class AlignmentVerticalProperties(val alignmentVertical: Alignment.Vertical) {
    CenterVertically(Alignment.CenterVertically),
    Top(Alignment.Top),
    Bottom(Alignment.Bottom)
}

data class FlowItem(
    val itemNo: Int,
    val itemColor: Color = randomColorList[randomColorList.indices.random()]
)

val FlowItemRange = 2..20

val randomColorList = listOf(
    Color.Gray,
    Color.Cyan,
    Color.Blue,
    Color.Red,
    Color.Black,
    Color.Magenta,
    Color.Green
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ColumnAndRowScreen() {

    var columnHorizontal by remember { mutableStateOf(AlignmentHorizontalProperties.CenterHorizontally) }
    var columnVertical by remember { mutableStateOf(ArrangementVerticalProperties.Center) }

    var rowHorizontal by remember { mutableStateOf(ArrangementHorizontalProperties.Center) }
    var rowVertical by remember { mutableStateOf(AlignmentVerticalProperties.CenterVertically) }

    var flowRowHorizontal by remember { mutableStateOf(ArrangementHorizontalProperties.Center) }
    var flowRowVertical by remember { mutableStateOf(ArrangementVerticalProperties.Center) }
    var flowRowItemCount by remember { mutableStateOf(1) }
    var flowRowItems = remember {
        mutableStateListOf<FlowItem>().apply {
            repeat(8) { add(FlowItem(flowRowItemCount++)) }
        }
    }

    var flowColumnHorizontal by remember { mutableStateOf(ArrangementHorizontalProperties.Center) }
    var flowColumnVertical by remember { mutableStateOf(ArrangementVerticalProperties.Center) }
    var flowColumnItemCount by remember { mutableStateOf(1) }
    var flowColumnItems = remember {
        mutableStateListOf<FlowItem>().apply {
            repeat(8) { add(FlowItem(flowColumnItemCount++)) }
        }
    }


    MaterialContents {
        Overview(content = stringResource(R.string.overview_column_and_row))
        MaterialElementScreen(
            modifier = Modifier.height(180.dp),
            title = "Column",
            componentContent = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                    horizontalAlignment = columnHorizontal.alignmentHorizontal,
                    verticalArrangement = columnVertical.arrangementVertical
                ) {
                    Text(
                        text = "Item 1",
                        color = Color.Red
                    )
                    Text(
                        text = "Item 2",
                        color = Color.Green
                    )
                    Text(
                        text = "Item 3",
                        color = Color.Blue
                    )
                }
            },
            controlContent = {
                ArrangementVerticalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Vertical",
                    currentSelection = columnVertical,
                    onChangeSelection = {
                        columnVertical = it
                    }
                )

                AlignmentHorizontalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Horizontal",
                    currentSelection = columnHorizontal,
                    onChangeSelection = {
                        columnHorizontal = it
                    }
                )
            }
        )

        MaterialElementScreen(
            modifier = Modifier.height(180.dp),
            title = "Row",
            componentContent = {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                    horizontalArrangement = rowHorizontal.arrangementHorizontal,
                    verticalAlignment = rowVertical.alignmentVertical
                ) {
                    Text(
                        text = "Item 1",
                        color = Color.Red
                    )
                    Text(
                        text = "Item 2",
                        color = Color.Green
                    )
                    Text(
                        text = "Item 3",
                        color = Color.Blue
                    )
                }
            },
            controlContent = {
                AlignmentVerticalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Vertical",
                    currentSelection = rowVertical,
                    onChangeSelection = {
                        rowVertical = it
                    }
                )

                ArrangementHorizontalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Horizontal",
                    currentSelection = rowHorizontal,
                    onChangeSelection = {
                        rowHorizontal = it
                    }
                )


            }
        )

        MaterialElementScreen(
            modifier = Modifier.height(180.dp),
            title = "FlowColumn",
            componentContent = {
                FlowColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                    horizontalArrangement = flowColumnHorizontal.arrangementHorizontal,
                    verticalArrangement = flowColumnVertical.arrangementVertical
                ) {
                    flowColumnItems.forEach {
                        Text(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            text = "Item ${it.itemNo}",
                            color = it.itemColor
                        )
                    }
                }
            },
            controlContent = {
                ArrangementHorizontalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Horizontal",
                    currentSelection = flowColumnHorizontal,
                    onChangeSelection = {
                        flowColumnHorizontal = it
                    }
                )
                ArrangementVerticalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Vertical",
                    currentSelection = flowColumnVertical,
                    onChangeSelection = {
                        flowColumnVertical = it
                    }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Button(
                        onClick = {
                            flowColumnItems.add(FlowItem(flowColumnItemCount++))
                        },
                        enabled = flowColumnItemCount <= FlowItemRange.last
                    ) {
                        Text("Add Item")
                    }
                    Spacer4h()
                    Button(
                        onClick = {
                            flowColumnItems.removeLast()
                            flowColumnItemCount--
                        },
                        enabled = flowColumnItemCount > FlowItemRange.first
                    ) {
                        Text("Remove Item")
                    }
                }
            }
        )

        MaterialElementScreen(
            modifier = Modifier.height(180.dp),
            title = "FlowRow",
            componentContent = {
                FlowRow(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                    horizontalArrangement = flowRowHorizontal.arrangementHorizontal,
                    verticalArrangement = flowRowVertical.arrangementVertical
                ) {
                    flowRowItems.forEach {
                        Text(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            text = "Item ${it.itemNo}",
                            color = it.itemColor
                        )
                    }
                }
            },
            controlContent = {
                ArrangementHorizontalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Horizontal",
                    currentSelection = flowRowHorizontal,
                    onChangeSelection = {
                        flowRowHorizontal = it
                    }
                )
                ArrangementVerticalPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Vertical",
                    currentSelection = flowRowVertical,
                    onChangeSelection = {
                        flowRowVertical = it
                    }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Button(
                        onClick = {
                            flowRowItems.add(FlowItem(flowRowItemCount++))
                        },
                        enabled = flowRowItemCount <= FlowItemRange.last
                    ) {
                        Text("Add Item")
                    }
                    Spacer4h()
                    Button(
                        onClick = {
                            flowRowItems.removeLast()
                            flowRowItemCount--
                        },
                        enabled = flowRowItemCount > FlowItemRange.first
                    ) {
                        Text("Remove Item")
                    }
                }
            }
        )
        Spacer16v()
    }

}