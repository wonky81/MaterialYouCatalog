package wonky.product.materialyoucatalog.core.sourcecode_viewer

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun CodeViewer(modifier: Modifier = Modifier) {


}

@Composable
fun WebViewScreen(url: String) {

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}