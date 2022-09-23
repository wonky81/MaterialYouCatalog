package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import wonky.product.materialyoucatalog.R


private const val SplashWaitTime: Long = 1500

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onTimeout: () -> Unit
) {
    val currentOnTimeout by rememberUpdatedState(newValue = onTimeout)

    LaunchedEffect(Unit) {
        delay(SplashWaitTime)
        currentOnTimeout()
    }
/*    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = MaterialTheme.colorScheme.primary
    )*/



    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.app_title),
            modifier = Modifier
                .padding(top = 64.dp),
            fontSize = 32.sp
        )

        Image(
            painter = painterResource(id = R.drawable.jetpack_icon),
            contentDescription = null,
            modifier = Modifier
                .size(220.dp)
                .padding(top = 120.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}