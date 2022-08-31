package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.components.buttons.*

@Composable
fun ButtonScreen() {
    ComponentArrangement(
        { MYButton() },
        { MYElevatedButton() },
        { MYFilledTonalButton() },
        { MYOutlinedButton() },
        { MYTextButton() },
        { MYIconButton() },
        { MYFloatingActionButton() },
        { MYExtendedFloatingActionButton() }
    )
}

@Composable
fun ComponentArrangement(vararg content: @Composable () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (item in content) {
            item()
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
        }
    }

}