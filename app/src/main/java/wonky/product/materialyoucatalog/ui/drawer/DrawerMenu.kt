package wonky.product.materialyoucatalog.ui.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenu(val title: String, val route: String, val icon: ImageVector){
    // Style
    object Palette : DrawerMenu("Palette", "Style/Palette", Icons.Default.ColorLens)
    object Fonts : DrawerMenu("Fonts", "Typography/Fonts", Icons.Default.FontDownload)

    //Actions
    object Buttons : DrawerMenu("Buttons", "Actions/Buttons", Icons.Default.SmartButton)

    //Communication
    object ProgressIndicators : DrawerMenu("ProgressIndicators", "Communication/ProgressIndicators", Icons.Default.DragIndicator)

    //Containment
    object Cards : DrawerMenu("Cards", "Containment/Cards", Icons.Default.CardMembership)

    //Navigation
    object BottomAppBar : DrawerMenu("BottomAppBar", "Navigation/BottomAppBar", Icons.Default.ViewSidebar)
    object NavigationRail : DrawerMenu("NavigationRail", "Navigation/NavigationRail", Icons.Default.Navigation)
    object TopAppBar : DrawerMenu("TopAppBar", "Navigation/TopAppBar", Icons.Default.VerticalAlignTop)

    //Selection
    object Chips : DrawerMenu("Chips", "Selection/Chips", Icons.Default.Notifications)
    object Sliders : DrawerMenu("Sliders", "Selection/Sliders", Icons.Default.DoorSliding)

    //TextInputs
    object TextFields : DrawerMenu("TextFields", "TextInputs/TextFields", Icons.Default.TextFields)


}
