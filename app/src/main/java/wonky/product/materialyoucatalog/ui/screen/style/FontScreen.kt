package wonky.product.materialyoucatalog.ui.screen.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.style.*
import wonky.product.materialyoucatalog.ui.screen.*

@Composable
fun FontScreen(){
    MaterialContents {
        Overview(stringResource(R.string.overview_text_font))
        SubTitleLarge(title = "Typography" )
        Spacer8v()
        DisplayLargeText(text = "Display Large")
        DisplayMediumText(text = "Display Medium")
        DisplaySmallText(text = "Display Small")
        HeadlineLargeText(text = "Headline Large")
        HeadlineMediumText(text = "Headline Medium")
        HeadlineSmallText(text = "Headline Small")
        TitleLargeText(text = "Title Large")
        TitleMediumText(text = "Title Medium")
        TitleSmallText(text = "Title Small")
        BodyLargeText(text ="Body Large")
        BodyMediumText(text ="Body Medium")
        BodySmallText(text ="Body Small")
        LabelLargeText(text = "Label Large")
        LabelMediumText(text = "Label Medium")
        LabelSmallText(text = "Label Small")
    }
}