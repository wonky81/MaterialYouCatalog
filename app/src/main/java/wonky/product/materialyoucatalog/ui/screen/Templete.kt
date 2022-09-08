package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun Overview(content: String){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Padding16h()
    ) {
        Spacer6()
        Text(
            text = content,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer6()
    }
}