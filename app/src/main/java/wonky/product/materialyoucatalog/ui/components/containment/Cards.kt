package wonky.product.materialyoucatalog.ui.components.containment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

private const val TAG = "Cards"

@Composable
fun MYElevatedCard(
    shape: Shape = CardDefaults.elevatedShape,
    colors: CardColors = CardDefaults.elevatedCardColors(),
    elevation: CardElevation = CardDefaults.elevatedCardElevation(),
){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp)
            .padding(16.dp),
        shape = shape,
        colors = colors,
        elevation = elevation,
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = "Elevated Card"
            )
        }
    }
}

@Composable
fun MYFilledCard(
    shape: Shape = CardDefaults.shape,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp)
            .padding(16.dp),
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = "Filled Card"
            )
        }
    }
}

@Composable
fun MYOutlinedCard(
    shape: Shape = CardDefaults.outlinedShape,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    elevation: CardElevation = CardDefaults.outlinedCardElevation(),
    border: BorderStroke = CardDefaults.outlinedCardBorder(),
){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp)
            .padding(16.dp),
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = "Outlined Card"
            )
        }
    }
}

