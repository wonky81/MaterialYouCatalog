package wonky.product.materialyoucatalog.ui.screen.animation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.animation.AnimateColorAsStateSample
import wonky.product.materialyoucatalog.ui.components.animation.AnimateDpAsStateSample
import wonky.product.materialyoucatalog.ui.components.animation.AnimateFloatAsStateSample
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview


@Composable
fun AnimateAsStateScreen() {
    var expandedByDp by remember { mutableStateOf(false ) }
    var colorChangedByColor by remember { mutableStateOf(false ) }
    var isRotatedByFloat by remember{ mutableStateOf(false) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_animate_as_state))
        MaterialElementScreen(
            modifier = Modifier.height(126.dp),
            title = "AnimateDpAsState Sample",
            componentContent = {
                AnimateDpAsStateSample(
                    expanded = expandedByDp
                )
            },
            controlContent = {
                FilledTonalButton(
                    onClick = { expandedByDp = !expandedByDp },
                ) {
                    Text(if(expandedByDp) "Shrink" else "Expand")
                }
            }
        )

        MaterialElementScreen(
            title = "AnimateColorAsState Sample",
            componentContent = {
                AnimateColorAsStateSample(
                    needColorChange = colorChangedByColor
                )

            },
            controlContent = {
                FilledTonalButton(
                    onClick = { colorChangedByColor = !colorChangedByColor },
                ) {
                    Text("Change")
                }
            }
        )

        MaterialElementScreen(
            title = "AnimateFloatAsState Sample",
            componentContent = {
                AnimateFloatAsStateSample(
                    isRotated = isRotatedByFloat,
                )

            },
            controlContent = {
                FilledTonalButton(
                    onClick = { isRotatedByFloat = !isRotatedByFloat },
                ) {
                    Text("Rotate")
                }
            }
        )

    }

}