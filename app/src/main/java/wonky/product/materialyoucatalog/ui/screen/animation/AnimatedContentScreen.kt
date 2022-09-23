package wonky.product.materialyoucatalog.ui.screen.animation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.animation.AnimateContentSample
import wonky.product.materialyoucatalog.ui.components.animation.AnimateDpAsStateSample
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@Composable
fun AnimatedContentScreen(){

    var number by remember { mutableStateOf(1) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_animated_content))
        MaterialElementScreen(
            modifier = Modifier.height(126.dp),
            title = "AnimatedContent Sample",
            componentContent = {
                AnimateContentSample(number = number)
            },
            controlContent = {
                FilledTonalButton(
                    onClick = { number++ },
                ) {
                    Text("add")
                }
            }
        )
    }
}