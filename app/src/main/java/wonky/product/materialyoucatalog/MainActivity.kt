package wonky.product.materialyoucatalog

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import wonky.product.materialyoucatalog.ui.components.bottomappbar.MYBottomAppBar
import wonky.product.materialyoucatalog.ui.screen.*
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            var dynamicColorEnabled by remember { mutableStateOf(true) }
            val currentTheme by mainViewModel.currentTheme

            MaterialYouCatalogTheme(
                context = applicationContext,
                currentTheme = currentTheme,
                dynamicColor = dynamicColorEnabled
            ) {
                ProvideWindowInsets(consumeWindowInsets = false, windowInsetsAnimationsEnabled = true) {
                    val systemUiController = rememberSystemUiController()
                    systemUiController.setSystemBarsColor(MaterialTheme.colorScheme.background)

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppScreen(
                            mainViewModel = mainViewModel,
                            dynamicColorEnabled = dynamicColorEnabled,
                            onChangeDynamicColorEnabled = { dynamicColorEnabled = it}
                        )
                    }
                }
            }
        }
    }
}

enum class SplashState {
    Shown,
    Completed
}

@Composable
fun AppScreen(
    mainViewModel: MainViewModel,
    dynamicColorEnabled: Boolean,
    onChangeDynamicColorEnabled: (Boolean) -> Unit
){
    Surface(color = MaterialTheme.colorScheme.primary) {
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

        val contentTopPadding by transition.animateDp(
            transitionSpec = { spring(stiffness = Spring.StiffnessLow) },
            label = "contentTopPadding"
        ) {
            if (it == SplashState.Shown) 100.dp else 0.dp
        }

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


//ButtonScreen()
//MYBottomAppBar()
//CardScreen()
//ChipScreen()
//DialogScreen()
//DropdownMenuScreen()
//NavigationBarScreen()
//NavigationDrawerScreen()
//NavigationRailScreen()
//ProgressIndicatorScreen()
//SliderScreen()
//SwitchScreen()
//TextFieldScreen()
//TopAppBarScreen()