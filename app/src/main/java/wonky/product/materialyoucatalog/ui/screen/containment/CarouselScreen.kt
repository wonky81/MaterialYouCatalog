package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselScreen() {
    val horizontalMultiBrowseCarouselCode =
        """
        data class CarouselItem(
            val id:Int,
            @DrawableRes val imageResId: Int,
            val contentDescription: String?
        )

        val carouselItems = listOf(
            CarouselItem(0, R.drawable.sea, null),
            CarouselItem(1, R.drawable.universe, null),
            CarouselItem(2, R.drawable.mountain, null),
        )
        HorizontalMultiBrowseCarousel(
            state = rememberCarouselState{ carouselItems.count() },
            modifier = Modifier.width(412.dp).height(221.dp),
            preferredItemWidth = 186.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ){ i ->
            Image(
                painter = painterResource(carouselItems[i].imageResId),
                contentDescription = carouselItems[i].contentDescription,
                modifier = Modifier.height(205.dp).maskClip(MaterialTheme.shapes.extraLarge),
                contentScale = ContentScale.Crop
            )
        }
    """
    val horizontalMultiBrowseCarouselRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(listOf|CarouselItem|maskClip|painterResource|PaddingValues|HorizontalMultiBrowseCarousel|count|width|height)\\s*", functionColor))
        add(Pair("(state\\s*=|modifier\\s*=|preferredItemWidth\\s*=|itemSpacing\\s*=|contentPadding\\s*=|painter\\s*=|contentDescription\\s*=|contentScale\\s*=)\\s*", parameterColor))
    }

    val horizontalUncontainedCarouselCode =
        """
        data class CarouselItem(
            val id:Int,
            @DrawableRes val imageResId: Int,
            val contentDescription: String?
        )

        val carouselItems = listOf(
            CarouselItem(0, R.drawable.sea, null),
            CarouselItem(1, R.drawable.universe, null),
            CarouselItem(2, R.drawable.mountain, null),
        )

        HorizontalUncontainedCarousel(
            state = rememberCarouselState{ carouselItems.count()},
            modifier = Modifier.width(412.dp).height(221.dp),
            itemWidth = 186.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp),
        ){ i ->
            Image(
                painter = painterResource(carouselItems[i].imageResId),
                contentDescription = carouselItems[i].contentDescription,
                modifier = Modifier.height(205.dp).maskClip(MaterialTheme.shapes.extraLarge),
                contentScale = ContentScale.Crop
            )
        }
    """
    val horizontalUncontainedCarouselRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(listOf|CarouselItem|maskClip|painterResource|PaddingValues|HorizontalUncontainedCarousel|count|width|height)\\s*", functionColor))
        add(Pair("(state\\s*=|modifier\\s*=|itemWidth\\s*=|itemSpacing\\s*=|contentPadding\\s*=|painter\\s*=|contentDescription\\s*=|contentScale\\s*=)\\s*", parameterColor))
    }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_carousel))
        MaterialElementScreen(
            title = "HorizontalMultiBrowseCarousel",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(horizontalMultiBrowseCarouselCode,horizontalMultiBrowseCarouselRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {

                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    HorizontalMultiBrowseCarousel(
                        state = rememberCarouselState{ carouselItems.count() },
                        modifier = Modifier.width(412.dp).height(221.dp),
                        preferredItemWidth = 186.dp,
                        itemSpacing = 8.dp,
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ){ i ->
                        Image(
                            painter = painterResource(carouselItems[i].imageResId),
                            contentDescription = carouselItems[i].contentDescription,
                            modifier = Modifier.height(205.dp).maskClip(MaterialTheme.shapes.extraLarge),
                            contentScale = ContentScale.Crop
                        )
                    }

                }
            },
            controlContent = {

            }
        )
        MaterialElementScreen(
            title = "HorizontalUncontainedCarousel",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(horizontalUncontainedCarouselCode,horizontalUncontainedCarouselRegexColorList),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {

                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    HorizontalUncontainedCarousel(
                        state = rememberCarouselState{ carouselItems.count()},
                        modifier = Modifier.width(412.dp).height(221.dp),
                        itemWidth = 186.dp,
                        itemSpacing = 8.dp,
                        contentPadding = PaddingValues(horizontal = 16.dp),
                    ){ i ->
                        Image(
                            painter = painterResource(carouselItems[i].imageResId),
                            contentDescription = carouselItems[i].contentDescription,
                            modifier = Modifier.height(205.dp).maskClip(MaterialTheme.shapes.extraLarge),
                            contentScale = ContentScale.Crop
                        )
                    }

                }
            },
            controlContent = {

            }
        )
    }

}


data class CarouselItem(
    val id:Int,
    @DrawableRes val imageResId: Int,
    val contentDescription: String?
)

val carouselItems = listOf(
    CarouselItem(0, R.drawable.sea, null),
    CarouselItem(1, R.drawable.universe, null),

    CarouselItem(2, R.drawable.mountain, null),
)