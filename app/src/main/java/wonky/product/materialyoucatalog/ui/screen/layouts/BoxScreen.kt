package wonky.product.materialyoucatalog.ui.screen.layouts

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
import wonky.product.materialyoucatalog.ui.screen.BoxAlignmentPropertiesDropDownSelector
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

enum class BoxContentAlignmentProperties(val alignment: Alignment){
    TopStart(Alignment.TopStart),
    TopCenter(Alignment.TopCenter),
    TopEnd(Alignment.TopEnd),
    CenterStart(Alignment.CenterStart),
    Center(Alignment.Center),
    CenterEnd(Alignment.CenterEnd),
    BottomStart(Alignment.BottomStart),
    BottomCenter(Alignment.BottomCenter),
    BottomEnd(Alignment.BottomEnd),
}
@Composable
fun BoxScreen() {

    var boxContentAlignment by remember { mutableStateOf(BoxContentAlignmentProperties.Center) }
    var boxItem1Alignment by remember { mutableStateOf(BoxContentAlignmentProperties.CenterStart) }
    var boxItem2Alignment by remember { mutableStateOf(BoxContentAlignmentProperties.Center) }
    var boxItem3Alignment by remember { mutableStateOf(BoxContentAlignmentProperties.CenterEnd) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_box))
        MaterialElementScreen(
            modifier = Modifier.height(180.dp),
            title = "Box Content Alignment",
            componentContent = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                    contentAlignment = boxContentAlignment.alignment,
                ) {
                    Text(
                        text = "Box Item",
                        color = Color.Red
                    )
                }
            },
            controlContent = {
                BoxAlignmentPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Box Content Alignment",
                    currentSelection = boxContentAlignment,
                    onChangeSelection = {
                        boxContentAlignment = it
                    }
                )
            }
        )

        MaterialElementScreen(
            modifier = Modifier.height(180.dp),
            title = "Box Items Alignment",
            componentContent = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                ) {
                    Text(
                        modifier = Modifier.align(boxItem1Alignment.alignment),
                        text = "Item 1",
                        color = Color.Red
                    )
                    Text(
                        modifier = Modifier.align(boxItem2Alignment.alignment),
                        text = "Item 2",
                        color = Color.Green
                    )
                    Text(
                        modifier = Modifier.align(boxItem3Alignment.alignment),
                        text = "Item 3",
                        color = Color.Blue
                    )
                }
            },
            controlContent = {
                BoxAlignmentPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Box Item1 Alignment",
                    currentSelection = boxItem1Alignment,
                    onChangeSelection = {
                        boxItem1Alignment = it
                    }
                )
                BoxAlignmentPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Box Item2 Alignment",
                    currentSelection = boxItem2Alignment,
                    onChangeSelection = {
                        boxItem2Alignment = it
                    }
                )
                BoxAlignmentPropertiesDropDownSelector(
                    modifier = Modifier.padding(start = 12.dp),
                    supportText = "Box Item3 Alignment",
                    currentSelection = boxItem3Alignment,
                    onChangeSelection = {
                        boxItem3Alignment = it
                    }
                )
            }
        )
    }
}