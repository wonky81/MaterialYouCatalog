package wonky.product.materialyoucatalog.ui.screen.animation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.animation.*
import wonky.product.materialyoucatalog.ui.screen.*

@OptIn(ExperimentalAnimationApi::class)
enum class EnterAnimType(val value: EnterTransition) {
    FadeIn(fadeIn()),
    SlideIn(slideIn(initialOffset = { androidx.compose.ui.unit.IntOffset(0, 0) })),
    ScaleIn(scaleIn()),
    ExpandIn(expandIn()),
    ExpandHorizontally(expandHorizontally()),
    ExpandVertically(expandVertically()),
    SlideInHorizontally(slideInHorizontally()),
    SlideInVertically(slideInVertically()),
}

@OptIn(ExperimentalAnimationApi::class)
enum class ExitAnimType(val value: ExitTransition) {
    FadeOut(fadeOut()),
    SlideOut(slideOut(targetOffset = { androidx.compose.ui.unit.IntOffset(0, 0) })),
    ScaleOut(scaleOut()),
    ShrinkOut(shrinkOut()),
    ShrinkHorizontally(shrinkHorizontally()),
    ShrinkVertically(shrinkVertically()),
    SlideOutHorizontally(slideOutHorizontally()),
    SlideOutVertically(slideOutVertically()),
}

fun combineEnterAnimation(animList: List<EnterAnimType>): EnterTransition {
    assert(!animList.isNullOrEmpty())
    var result: EnterTransition = animList[0].value
    animList.forEachIndexed { index, enterAnimType ->
        if (index > 0) {
            result += enterAnimType.value
        }
    }
    return result
}

fun combineExitAnimation(animList: List<ExitAnimType>): ExitTransition {
    assert(!animList.isNullOrEmpty())
    var result: ExitTransition = animList[0].value
    animList.forEachIndexed { index, exitAnimType ->
        if (index > 0) {
            result += exitAnimType.value
        }
    }
    return result
}

@Composable
fun AnimatedVisibilityScreen() {
    var showHide by remember { mutableStateOf(true) }

    var selectedEnterAnimList = remember { mutableStateListOf<EnterAnimType>() }.apply {
        add(EnterAnimType.FadeIn)
        add(EnterAnimType.ExpandIn)
    }
    var selectedExitAnimList = remember { mutableStateListOf<ExitAnimType>() }.apply {
        add(ExitAnimType.ShrinkOut)
        add(ExitAnimType.FadeOut)
    }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_animated_visibility))

        MaterialElementScreen(
            modifier = Modifier.height(96.dp),
            title = "AnimatedVisibility Sample",
            componentContent = {
                AnimatedVisibility_ShowHide(
                    isVisible = showHide,
                    enterTransition = combineEnterAnimation(selectedEnterAnimList),
                    exitTransition = combineExitAnimation(selectedExitAnimList)
                )
            },
            controlContent = {
                Column {
                    FilledTonalButton(onClick = { showHide = !showHide }) {
                        Text(
                            text = if (showHide) "Hide" else "Show"
                        )
                    }
                    Spacer6v()
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Enter Transition : ",
                            fontWeight = FontWeight.Bold
                        )
                        EnterAnimType.values().forEach {
                            CheckBoxWithText(
                                enabled = selectedEnterAnimList.size>1 || !selectedEnterAnimList.contains(it),
                                checked = selectedEnterAnimList.contains(it),
                                onCheckedChange = { checked ->
                                    if(checked){
                                        selectedEnterAnimList.add(it)
                                    }else{
                                        if(selectedEnterAnimList.size>1){
                                            selectedEnterAnimList.remove(it)
                                        }
                                    }
                                },
                                text = "${it.name}"
                            )
                        }
                    }
                    Spacer6v()
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Exit Transition : ",
                            fontWeight = FontWeight.Bold
                        )
                        ExitAnimType.values().forEach {
                            CheckBoxWithText(
                                enabled = selectedExitAnimList.size>1 || !selectedExitAnimList.contains(it),
                                checked = selectedExitAnimList.contains(it),
                                onCheckedChange = { checked ->
                                    if(checked){
                                        selectedExitAnimList.add(it)
                                    }else{
                                        if(selectedExitAnimList.size>1){
                                            selectedExitAnimList.remove(it)
                                        }
                                    }
                                },
                                text = "${it.name}"
                            )
                        }
                    }
                }

            }
        )

/*

        MaterialElementScreen(
            title = "AnimatedVisibilitySample1",
            componentContent = {
                AnimatedVisibilitySample1()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "AnimatedVisibilitySample2",
            componentContent = {
                AnimatedVisibilitySample2()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "Simple AnimatedVisibility",
            componentContent = {
                SimpleAnimatedVisibility(delayMs = simpleAnimatedVisibilityDuration)
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "Simple AnimatedVisibility2",
            componentContent = {
                SimpleAnimatedVisibility2()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "Simple AnimatedVisibility3",
            componentContent = {
                TransitionFadeInOut()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "Animatable Sample",
            componentContent = {
                AnimatableSample()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "AnimateDpAsState Sample",
            componentContent = {
                AnimateDpAsStateSample()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "AnimateColorAsState Sample",
            componentContent = {
                AnimateColorAsStateSample()
            },
            controlContent = { }
        )

        MaterialElementScreen(
            title = "AnimateFloatAsState Sample",
            componentContent = {
                AnimateFloatAsStateSample()
            },
            controlContent = { }
        )*/
    }

}