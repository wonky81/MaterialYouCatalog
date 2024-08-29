package wonky.product.materialyoucatalog.ui.screen.containment

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselScreen() {

    MaterialContents {
        Overview(content = stringResource(R.string.overview_carousel))
        MaterialElementScreen(
            title = "HorizontalMultiBrowseCarousel",
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