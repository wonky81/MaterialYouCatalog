package wonky.product.materialyoucatalog.ui.components.containment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.screen.ElevationLevel

private const val TAG = "Cards"

@Composable
fun MYElevatedCard(
    text: String = "Elevated Card",
    shape: Shape = CardDefaults.elevatedShape,
    colors: CardColors = CardDefaults.elevatedCardColors(),
    defaultElevation: Dp = ElevationLevel.Level1.dp,
    disabledElevation: Dp = ElevationLevel.Level1.dp,
){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(126.dp)
            .padding(16.dp),
        shape = shape,
        colors = colors,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation)
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = text
            )
        }
    }
}

@Composable
fun MYFilledCard(
    text: String = "Filled Card",
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    defaultElevation: Dp = ElevationLevel.Level1.dp,
    disabledElevation: Dp = ElevationLevel.Level1.dp,
    border: BorderStroke? = null,
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(126.dp)
            .padding(16.dp),
        shape = shape,
        colors = colors,
        elevation = CardDefaults.cardElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation),
        border = border,
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = text
            )
        }
    }
}

@Composable
fun MYOutlinedCard(
    text: String = "Outlined Card",
    shape: Shape = CardDefaults.outlinedShape,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    defaultElevation: Dp = ElevationLevel.Level1.dp,
    disabledElevation: Dp = ElevationLevel.Level1.dp,
    border: BorderStroke = CardDefaults.outlinedCardBorder(),
){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(126.dp)
            .padding(16.dp),
        shape = shape,
        colors = colors,
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation),
        border = border,
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = text
            )
        }
    }
}

