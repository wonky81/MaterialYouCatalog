package wonky.product.materialyoucatalog.ui.screen.layouts

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import wonky.product.materialyoucatalog.ui.screen.ColumnAlignmentPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.ColumnArrangementPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview
import wonky.product.materialyoucatalog.ui.screen.RowAlignmentPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.RowArrangementPropertiesDropDownSelector

enum class ColumnArrangementProperties(val arrangementVertical: Arrangement.Vertical){
    Center(Arrangement.Center),
    SpaceEvenly(Arrangement.SpaceEvenly),
    SpaceBetween(Arrangement.SpaceBetween),
    SpaceAround(Arrangement.SpaceAround),
    Bottom(Arrangement.Bottom),
    Top(Arrangement.Top)
}
enum class RowArrangementProperties(val arrangementHorizontal: Arrangement.Horizontal){
    Center(Arrangement.Center),
    SpaceEvenly(Arrangement.SpaceEvenly),
    SpaceBetween(Arrangement.SpaceBetween),
    SpaceAround(Arrangement.SpaceAround),
    Start(Arrangement.Start),
    End(Arrangement.End)
}

enum class ColumnAlignmentProperties(val alignmentHorizontal: Alignment.Horizontal){
    CenterHorizontally(Alignment.CenterHorizontally),
    End(Alignment.End),
    Start(Alignment.Start)
}

enum class RowAlignmentProperties(val alignmentVertical: Alignment.Vertical){
    CenterVertically(Alignment.CenterVertically),
    Top(Alignment.Top),
    Bottom(Alignment.Bottom)
}

@Composable
fun ColumnAndRowScreen() {

    var columnHorizontal by remember { mutableStateOf(ColumnAlignmentProperties.CenterHorizontally) }
    var columnVertical by remember { mutableStateOf(ColumnArrangementProperties.Center) }

    var rowHorizontal by remember { mutableStateOf(RowArrangementProperties.Center) }
    var rowVertical by remember { mutableStateOf(RowAlignmentProperties.CenterVertically) }

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
                ColumnArrangementPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Vertical",
                    currentSelection = columnVertical,
                    onChangeSelection = {
                        columnVertical = it
                    }
                )

                ColumnAlignmentPropertiesDropDownSelector(
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
                RowAlignmentPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Vertical",
                    currentSelection = rowVertical,
                    onChangeSelection = {
                        rowVertical = it
                    }
                )

                RowArrangementPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Horizontal",
                    currentSelection = rowHorizontal,
                    onChangeSelection = {
                        rowHorizontal = it
                    }
                )


            }
        )
    }

}