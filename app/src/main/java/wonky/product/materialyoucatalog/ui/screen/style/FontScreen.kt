package wonky.product.materialyoucatalog.ui.screen.style

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Slider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.style.*
import wonky.product.materialyoucatalog.ui.screen.*
import kotlin.math.roundToInt

@Composable
fun FontScreen() {
    // should be in Range 11.sp ~ 57.sp
    var fontSizeSliderValue by remember { mutableStateOf(0f)  }
    var fontSize = convert(fontSizeSliderValue)


    MaterialContents {
        Overview(stringResource(R.string.overview_text_font))
        SubTitleLarge(title = "Typography")
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
        BodyLargeText(text = "Body Large")
        BodyMediumText(text = "Body Medium")
        BodySmallText(text = "Body Small")
        LabelLargeText(text = "Label Large")
        LabelMediumText(text = "Label Medium")
        LabelSmallText(text = "Label Small")




/*        MaterialElementScreen(
            title = "Font Size in DP",
            componentContent = {
                Column(
                    modifier = Modifier.height(300.dp)
                ) {
                    Text(
                        text = " ${fontSize.spToDp()} dp ",
                        fontSize = fontSize.sp
                    )
                }
            },
            controlContent = {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Slider(
                        value = fontSizeSliderValue,
                        onValueChange = { fontSizeSliderValue = it }
                    )
                }
            }
        )*/
    }
}

fun convert(value: Float) = value*57f+11f

@Composable
fun Float.spToDp() = with(LocalDensity.current){ this@spToDp.toDp()}