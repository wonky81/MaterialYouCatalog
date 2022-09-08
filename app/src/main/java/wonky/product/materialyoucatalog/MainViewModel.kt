package wonky.product.materialyoucatalog

import android.app.Application
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.compose.BlueDarkColors
import com.example.compose.BlueLightColors
import dagger.hilt.android.lifecycle.HiltViewModel
import wonky.product.materialyoucatalog.core.PrefHelper
import wonky.product.materialyoucatalog.core.PrefHelper.get
import wonky.product.materialyoucatalog.core.PrefHelper.operation
import wonky.product.materialyoucatalog.core.PrefHelper.put
import wonky.product.materialyoucatalog.ui.theme.red.RedDarkColors
import wonky.product.materialyoucatalog.ui.theme.red.RedLightColors
import wonky.product.materialyoucatalog.ui.theme.teal.TealDarkColors
import wonky.product.materialyoucatalog.ui.theme.teal.TealLightColors
import javax.inject.Inject


val DEFAULT_THEME = CatalogTheme.RED_THEME.name

enum class CatalogTheme(val paletteName: String, val lightColorScheme: ColorScheme, val darkColorScheme: ColorScheme) {
    RED_THEME("RED", RedLightColors, RedDarkColors),
    TEAL_THEME("TEAL", TealLightColors, TealDarkColors),
    BLUE_THEME("BLUE", BlueLightColors, BlueDarkColors)
}


@HiltViewModel
class MainViewModel  @Inject constructor(private val app: Application) : ViewModel() {

    val currentTheme = mutableStateOf(
        PrefHelper.prefs(app.applicationContext)
            .get(PrefHelper.KEY_CURRENT_THEME, DEFAULT_THEME) as String
    )

    fun setCurrentTheme(theme: String) {
        currentTheme.value = theme
        PrefHelper.prefs(app.applicationContext).operation {
            it.put(Pair(PrefHelper.KEY_CURRENT_THEME, theme))
        }
    }
}