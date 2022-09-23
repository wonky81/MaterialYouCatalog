package wonky.product.materialyoucatalog.ui.components.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.drawer.DrawerMenu
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.Spacer4h

@Composable
fun AlarmIconObject(
    size: Dp = 50.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(25.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(Icons.Default.Alarm, contentDescription = null, tint = Color.White)
    }
}

enum class MusicCardState{
    Collapsed,
    Expanded
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MusicCardObject(
    currentState: MusicCardState
){
    val transition = updateTransition(targetState = currentState, label = "MusicCard")
    val rowDp by transition.animateDp(label = "rowdp") { state ->
        when(state){
            MusicCardState.Collapsed -> {
                32.dp
            }
            MusicCardState.Expanded ->{
                96.dp
            }
        }
    }
    val cardColor by transition.animateColor(label = "cardcolor") { state ->
        when(state){
            MusicCardState.Collapsed -> {
                MaterialTheme.colorScheme.primary
            }
            MusicCardState.Expanded ->{
                MaterialTheme.colorScheme.secondary
            }
        }
    }


    ElevatedCard(
        modifier = Modifier.fillMaxWidth().height(rowDp),
        colors = CardDefaults.elevatedCardColors(containerColor = cardColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            AnimatedContent(
                targetState = currentState,
                transitionSpec = { scaleIn() with scaleOut() }
            ) {
                Text(
                    text = when(currentState){
                        MusicCardState.Collapsed -> {
                            "Hello My..."
                        }
                        MusicCardState.Expanded -> {
                            "Hello My Dear Heaven"
                        }
                    }
                )
            }
            Spacer4h()
            Icon(Icons.Filled.FastRewind, contentDescription = null)
            Spacer4h()
            Icon(Icons.Filled.PlayCircle, contentDescription = null)
            Spacer4h()
            Icon(Icons.Filled.FastForward, contentDescription = null)
        }
    }

}