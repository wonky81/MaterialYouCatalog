package wonky.product.materialyoucatalog.ui.screen.communication

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.communication.MYCircularProgressIndicator
import wonky.product.materialyoucatalog.ui.components.communication.MYLinearProgressIndicator
import wonky.product.materialyoucatalog.ui.screen.MainWarningMessage
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@Composable
fun ProgressIndicatorScreen() {
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
                MainWarningMessage(stringResource(R.string.not_available_message))
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Determinate Circular Progress Indicator",
            componentContent = {
                MainWarningMessage(stringResource(R.string.not_available_message))
            },
            controlContent = {

            }
        )
    }
}