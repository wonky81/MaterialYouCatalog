package wonky.product.materialyoucatalog.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.screen.*


enum class Category {
    Style,
    Actions,
    Communication,
    Containment,
    Navigation,
    Selection,
    TextInputs,
    Animation,
    Layouts,
    Showcases
}

private val showcasesScreens = listOf(
    //DrawerMenu.GoogleMail,
    DrawerMenu.SamsungAlarm,
    DrawerMenu.CircularCarousel,
    DrawerMenu.FacebookLogin,
    DrawerMenu.GoogleMail
    //DrawerMenu.SamsungSettings,
    //DrawerMenu.YoutubeMusic
)

private val styleScreens = listOf(
    DrawerMenu.Palette,
    DrawerMenu.Fonts
)


private val actionsScreens = listOf(
    DrawerMenu.Buttons,
)

private val communicationScreens = listOf(
    DrawerMenu.ProgressIndicators
)

private val containmentScreens = listOf(
    DrawerMenu.Cards,
    DrawerMenu.Dialogs,
    DrawerMenu.Tooltips,
    DrawerMenu.Badges,
    DrawerMenu.Tab
)

private val navigationScreens = listOf(
    DrawerMenu.AppBar,
    DrawerMenu.NavigationRail,
    DrawerMenu.SearchBar,
)

private val selectionScreens = listOf(
    DrawerMenu.Chips,
    DrawerMenu.Sliders,
    DrawerMenu.DatePickers
)

private val textInputsScreens = listOf(
    DrawerMenu.TextFields,
)

private val animationScreens = listOf(
    DrawerMenu.AnimatedVisibility,
    DrawerMenu.AnimatedAsState,
    DrawerMenu.AnimatedContent,
    //DrawerMenu.UpdateTransition
)

private val layoutScreens = listOf(
    DrawerMenu.ColumnAndRow
)
@Composable
fun DrawerScreen(
    selectedMenuRoute: String,
    onDestinationClicked: (route: String) -> Unit
) {

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .widthIn(max = 280.dp)
                .padding(16.dp)
        ) {
            Spacer12()
            MainTitle(title = "Material3 Catalog" )
            Spacer16v()
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Category.values().forEachIndexed { index, category ->
                    SubMenuScreen(category.name, index, selectedMenuRoute, onDestinationClicked)
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SubMenuScreen(
    categoryName: String,
    position: Int,
    selectedMenuRoute: String,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        SubTitleSmall(title = categoryName)
        Spacer6v()
        var screens = when(categoryName){
            Category.Style.name -> { styleScreens }
            Category.Actions.name ->{ actionsScreens }
            Category.Communication.name ->{ communicationScreens }
            Category.Containment.name ->{ containmentScreens }
            Category.Navigation.name ->{ navigationScreens }
            Category.Selection.name ->{ selectionScreens }
            Category.TextInputs.name ->{ textInputsScreens }
            Category.Animation.name -> { animationScreens }
            Category.Layouts.name -> { layoutScreens }
            Category.Showcases.name -> { showcasesScreens }
            else -> { styleScreens }
        }

        screens.forEach {
            NavigationDrawerItem(
                label = { Text(it.title) },
                icon = { Icon(it.icon, contentDescription = null) },
                selected = selectedMenuRoute == it.route,
                onClick = { onDestinationClicked(it.route) }
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
        }
        Spacer6v()
        if(position!=Category.values().lastIndex){
            Divider(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .height(1.dp)
            )
            Spacer6v()
        }
    }

}
