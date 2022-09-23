package wonky.product.materialyoucatalog.ui.components.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateContentSample(
    number: Int = 1,
    started: Boolean = false
) {
    AnimatedContent(
        targetState = number,
        transitionSpec = {  scaleIn(
            animationSpec = tween(500)
        ) with scaleOut(
            animationSpec = tween(500)
        )
/*            if(targetState>initialState){
                fadeIn() with fadeOut()
            }else{
                slideInHorizontally() with slideOutHorizontally()
            }*/
        }
    ) { targetNumber ->
        Text(
            text = "$targetNumber",
            style = MaterialTheme.typography.displaySmall
        )
    }

}

@Preview(showBackground = true, widthDp = 1280, heightDp = 1280)
@Composable
fun AnimateContentSamplePreview() {

    MaterialYouCatalogTheme(
        context = LocalContext.current,
        currentTheme = "",
        dynamicColor = true
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            AnimateContentSample()
        }

    }

}