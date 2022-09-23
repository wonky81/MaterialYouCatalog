package wonky.product.materialyoucatalog.ui.components.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import wonky.product.materialyoucatalog.ui.components.navigation.MYCenterAlignedTopAppBar
import wonky.product.materialyoucatalog.ui.theme.MaterialYouCatalogTheme


@Preview(showBackground = true, widthDp = 1280, heightDp = 1280)
@Composable
fun ObjectPreview() {

    MaterialYouCatalogTheme(
        context = LocalContext.current,
        currentTheme = "",
        dynamicColor = true
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            AlarmIconObject()
        }

    }

}

@Composable
fun AnimatedVisibility_ShowHide(
    isVisible: Boolean,
    enterTransition: EnterTransition,
    exitTransition: ExitTransition
){
    AnimatedVisibility(
        visible = isVisible,
        enter = enterTransition,
        exit = exitTransition
    ) {
        AlarmIconObject()
    }
}

@Composable
fun AnimatedVisibility_ShowHide2(
    isVisible: Boolean,
){
    AnimatedVisibility(
        visible = isVisible,
        enter = expandIn()+fadeIn(),
        exit = slideOutVertically()+fadeOut()
    ) {
        AlarmIconObject()
    }
}

@Composable
fun AnimatedVisibilitySample1(){
    var expanded by remember { mutableStateOf(false) }

    FloatingActionButton(onClick = { expanded = !expanded }) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)){
            Icon(
                Icons.Filled.Add,
                contentDescription = null
            )
            //if(expanded) Text("Add")
            AnimatedVisibility(visible = expanded) {
                Text("Add", modifier = Modifier.padding(start = 8.dp, top = 3.dp))
            }
        }

    }
}
@Composable
fun AnimatedVisibilitySample2() {
    var shown by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .height(186.dp)
        .padding(horizontal = 12.dp)) {
        MYCenterAlignedTopAppBar()
        AnimatedVisibility(
            visible = shown,
            enter = slideInVertically(
                animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically(
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
            ) {
                Text("Warning : Network is not stable.", modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp))
            }
        }
        Button(onClick = { shown = !shown }) {
            Text("Click Here")
        }

    }

}

@Composable
fun SimpleAnimatedVisibility(
    delayMs: Long
){
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(true){
        delay(delayMs)
        visible = true
    }

    AnimatedVisibility(visible = visible) {
        Text("Edit")
    }
}

@Composable
fun SimpleAnimatedVisibility2(

){
    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    LaunchedEffect(true){
        delay(1000)
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx()}
        } + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ){
        Text("Hello",
            Modifier
                .fillMaxWidth()
                .height(200.dp))
    }
}

@Composable
fun TransitionFadeInOut(){

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(true){
        delay(1000)
        visible = true
    }
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Text("Edit")
    }
}

@Composable
fun AnimatableSample(){
    var isAnimated by remember { mutableStateOf(false) }
    val color = remember { Animatable(Color.DarkGray) }

    LaunchedEffect(isAnimated){
        color.animateTo(if(isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(color.value)
    ){
        Button(onClick = { isAnimated = !isAnimated }) {
            Text("Animate Color")
        }
    }

}

