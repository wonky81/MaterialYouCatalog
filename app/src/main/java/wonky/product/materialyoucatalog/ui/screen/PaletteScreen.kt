package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.unit.dp


@Composable
fun PaletteScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PaletteItem("Primary", MaterialTheme.colorScheme.primary)
        PaletteItem( "onPrimary", MaterialTheme.colorScheme.onPrimary)
        PaletteItem( "PrimaryContainer", MaterialTheme.colorScheme.primaryContainer)
        PaletteItem( "OnPrimaryContainer", MaterialTheme.colorScheme.onPrimaryContainer)
        PaletteItem( "Secondary", MaterialTheme.colorScheme.secondary)
        PaletteItem( "onSecondary", MaterialTheme.colorScheme.onSecondary)
        PaletteItem( "SecondaryContainer", MaterialTheme.colorScheme.secondaryContainer)
        PaletteItem( "OnSecondaryContainer", MaterialTheme.colorScheme.onSecondaryContainer)
        PaletteItem( "Tertiary", MaterialTheme.colorScheme.tertiary)
        PaletteItem( "OnTertiary", MaterialTheme.colorScheme.onTertiary)
        PaletteItem( "TertiaryContainer", MaterialTheme.colorScheme.tertiaryContainer)
        PaletteItem( "OnTertiaryContainer", MaterialTheme.colorScheme.onTertiaryContainer)
        PaletteItem( "Error", MaterialTheme.colorScheme.error)
        PaletteItem( "OnError", MaterialTheme.colorScheme.onError)
        PaletteItem( "ErrorContainer", MaterialTheme.colorScheme.errorContainer)
        PaletteItem( "OnErrorContainer", MaterialTheme.colorScheme.onErrorContainer)
        PaletteItem( "Background", MaterialTheme.colorScheme.onBackground)
        PaletteItem( "Surface", MaterialTheme.colorScheme.surface)
        PaletteItem( "OnSurface", MaterialTheme.colorScheme.onSurface)
        PaletteItem( "Outline", MaterialTheme.colorScheme.outline)
        PaletteItem( "Outline-Variant", MaterialTheme.colorScheme.outlineVariant)
        PaletteItem( "Surface-Variant", MaterialTheme.colorScheme.surfaceVariant)
        PaletteItem( "OnSurface-Variant", MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
fun PaletteItem(
    text: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            colors = CardDefaults.cardColors(containerColor = color, contentColor = contentColorFor(
                backgroundColor = color))
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                text = text,
                color = if(color.luminance()>0.5f) Color.Black else Color.White
            )
        }
    }
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
}
