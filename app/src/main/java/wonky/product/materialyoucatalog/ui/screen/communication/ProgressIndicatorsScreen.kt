package wonky.product.materialyoucatalog.ui.screen.communication

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.communication.MYCircularProgressIndicator
import wonky.product.materialyoucatalog.ui.components.communication.MYLinearProgressIndicator
import wonky.product.materialyoucatalog.ui.screen.*

@Composable
fun ProgressIndicatorScreen() {
    MaterialContents {
        Overview(stringResource(R.string.overview_progress_indicators))
        SubTitleLarge(title = "Indeterminate Linear Progress Indicator" )
        Spacer8v()
        MYLinearProgressIndicator()
        Spacer16v()
        SubTitleLarge(title = "Indeterminate Circular Progress Indicator" )
        Spacer8v()
        MYCircularProgressIndicator()
        Spacer16v()
        SubTitleLarge(title = "Determinate Linear Progress Indicator" )
        Spacer8v()
        MainWarningMessage(stringResource(R.string.not_available_message))
        Spacer16v()
        SubTitleLarge(title = "Determinate Circular Progress Indicator" )
        Spacer8v()
        MainWarningMessage(stringResource(R.string.not_available_message))
    }
}