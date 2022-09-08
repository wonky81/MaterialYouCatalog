package wonky.product.materialyoucatalog.ui.screen.containment

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.components.containment.MYElevatedCard
import wonky.product.materialyoucatalog.ui.components.containment.MYFilledCard
import wonky.product.materialyoucatalog.ui.components.containment.MYOutlinedCard
import wonky.product.materialyoucatalog.ui.screen.ComponentArrangement


private const val TAG = "CardScreen"


@Composable
fun CardScreen(
    onChangeBottomSheetContent: (@Composable () -> Unit) -> Unit,
    onChangeBottomSheetHeight: (Dp) -> Unit
) {

    var cardDefaultElevation by remember{ mutableStateOf(1f) }
    var pressedElevation by remember{ mutableStateOf(1f) }
    var focusedElevation by remember{ mutableStateOf(1f) }
    var hoveredElevation by remember{ mutableStateOf(1f) }
    var disabledElevation by remember{ mutableStateOf(1f) }

    Log.d(TAG, "CardScreen: defaultElevation = $cardDefaultElevation")
    
    Column {
        ComponentArrangement(
            { MYFilledCard(
                elevation = CardDefaults.cardElevation(cardDefaultElevation.dp,pressedElevation.dp,focusedElevation.dp,hoveredElevation.dp,disabledElevation.dp)
            ) },
            { MYElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(cardDefaultElevation.dp,pressedElevation.dp,focusedElevation.dp,hoveredElevation.dp,disabledElevation.dp)
            ) },
            { MYOutlinedCard(
                elevation = CardDefaults.outlinedCardElevation(cardDefaultElevation.dp,pressedElevation.dp,focusedElevation.dp,hoveredElevation.dp,disabledElevation.dp)
            ) },
        )
        LaunchedEffect(true) {
            onChangeBottomSheetHeight(320.dp)
        }
        onChangeBottomSheetContent{
            ControlScreen(
                cardDefaultElevation = cardDefaultElevation,
                pressedElevation = pressedElevation,
                disabledElevation = disabledElevation,
                onChangeDefaultElevation = { cardDefaultElevation = it},
                onChangePressedElevation = { pressedElevation = it},
                onChangeDisabledElevation = { disabledElevation = it},
            )
        }
    }
}

@Composable
fun ControlScreen(
    cardDefaultElevation: Float,
    pressedElevation: Float,
    disabledElevation: Float,
    onChangeDefaultElevation: (value:Float) -> Unit,
    onChangePressedElevation: (value:Float) -> Unit,
    onChangeDisabledElevation: (value:Float) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Default Elevation : (${cardDefaultElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = cardDefaultElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangeDefaultElevation)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Pressed Elevation : (${pressedElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = pressedElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangePressedElevation)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("Disabled Elevation : (${disabledElevation.toInt()} dp) ")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Slider(value = disabledElevation, steps = 13, valueRange = 0f..12f, onValueChange = onChangeDisabledElevation)
    }
}

