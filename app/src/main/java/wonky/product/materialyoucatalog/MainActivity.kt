package wonky.product.materialyoucatalog

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import wonky.product.materialyoucatalog.ad.FullScreenAd
import wonky.product.materialyoucatalog.ui.screen.*
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        FullScreenAd.loadInterstitial(this)
        setContent {
            var dynamicColorEnabled by remember { mutableStateOf(true) }
            val currentTheme by mainViewModel.currentTheme

            MaterialYouCatalogTheme(
                context = applicationContext,
                currentTheme = currentTheme,
                dynamicColor = dynamicColorEnabled
            ) {
                ProvideWindowInsets(
                    consumeWindowInsets = false,
                    windowInsetsAnimationsEnabled = true
                ) {
                    AppScreen(
                        mainViewModel = mainViewModel,
                        dynamicColorEnabled = dynamicColorEnabled,
                        onChangeDynamicColorEnabled = { dynamicColorEnabled = it }
                    )
                }
            }
        }
        MobileAds.initialize(this){}
    }

    override fun onDestroy() {
        FullScreenAd.removeInterstitial()
        super.onDestroy()
    }
}

enum class SplashState {
    Shown,
    Completed
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppScreen(
    mainViewModel: MainViewModel,
    dynamicColorEnabled: Boolean,
    onChangeDynamicColorEnabled: (Boolean) -> Unit
) {
    val transitionState = remember { MutableTransitionState(SplashState.Shown) }
    val transition = updateTransition(transitionState, label = "splashTransition")


    val splashAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) },
        label = "splashAlpha"
    ) {
        if (it == SplashState.Shown) 1f else 0f
    }

    val contentAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 300) },
        label = "contentAlpha"
    ) {
        if (it == SplashState.Shown) 0f else 1f
    }

    val backgroundColor by transition.animateColor(
        label = "backgroundColor"
    ) {
        if (it == SplashState.Shown) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
    }

    val contentTopPadding by transition.animateDp(
        transitionSpec = { spring(stiffness = Spring.StiffnessLow) },
        label = "contentTopPadding"
    ) {
        if (it == SplashState.Shown) 100.dp else 0.dp
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(backgroundColor)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Box {
            SplashScreen(
                modifier = Modifier.alpha(splashAlpha),
                onTimeout = { transitionState.targetState = SplashState.Completed }
            )
            MainScreen(
                mainViewModel = mainViewModel,
                modifier = Modifier.alpha(contentAlpha),
                dynamicColorEnabled = dynamicColorEnabled,
                onChangeDynamicColorEnabled = onChangeDynamicColorEnabled
            )
        }
    }

}