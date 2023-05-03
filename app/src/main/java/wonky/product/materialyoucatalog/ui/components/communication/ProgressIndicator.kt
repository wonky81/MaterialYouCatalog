package wonky.product.materialyoucatalog.ui.components.communication

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable

@Composable
fun MYLinearProgressIndicator(){
    LinearProgressIndicator()
}

@Composable
fun MYCircularProgressIndicator(){
    CircularProgressIndicator()
}

@Composable
fun MyDeterminateLinearProgressIndicator(progress: Float) {
    LinearProgressIndicator(progress = progress)
}

@Composable
fun MyDeterminateCircularProgressIndicator(progress: Float) {
    CircularProgressIndicator(progress = progress)
}