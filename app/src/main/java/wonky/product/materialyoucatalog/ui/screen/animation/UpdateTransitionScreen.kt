package wonky.product.materialyoucatalog.ui.screen.animation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.animation.AnimateDpAsStateSample
import wonky.product.materialyoucatalog.ui.components.animation.MusicCardObject
import wonky.product.materialyoucatalog.ui.components.animation.MusicCardState
import wonky.product.materialyoucatalog.ui.components.animation.UpdateTransitionSample
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview


@Composable
fun UpdateTransitionScreen(){

    var currentState by remember { mutableStateOf(MusicCardState.Collapsed) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_update_transition))
        MaterialElementScreen(
            modifier = Modifier.height(126.dp),
            title = "UpdateTransition Sample",
            componentContent = {
                MusicCardObject(currentState = currentState)
            },
            controlContent = {
                FilledTonalButton(
                    onClick = { currentState = if(currentState==MusicCardState.Collapsed) MusicCardState.Expanded else MusicCardState.Collapsed },
                ) {
                    Text(if(currentState==MusicCardState.Collapsed) "Expand" else "Collapse")
                }
            }
        )
    }
}