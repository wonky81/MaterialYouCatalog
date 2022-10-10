package wonky.product.materialyoucatalog.ui.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenu(val title: String, val route: String, val icon: ImageVector){
    // Style
    object Palette : DrawerMenu("Palette", "Style/Palette", Icons.Default.ColorLens)
    object Fonts : DrawerMenu("Fonts", "Style/Fonts", Icons.Default.FontDownload)

    //Actions
    object Buttons : DrawerMenu("Buttons", "Actions/Buttons", Icons.Default.SmartButton)

    //Communication
    object ProgressIndicators : DrawerMenu("ProgressIndicators", "Communication/ProgressIndicators", Icons.Default.DragIndicator)

    //Containment
    object Cards : DrawerMenu("Cards", "Containment/Cards", Icons.Default.CardMembership)
    object Dialogs : DrawerMenu("Dialogs", "Containment/Dialogs", Icons.Default.Dialpad)

    //Navigation
    object AppBar : DrawerMenu("AppBar", "Navigation/AppBar", Icons.Default.ViewSidebar)
    object NavigationRail : DrawerMenu("NavigationRail", "Navigation/NavigationRail", Icons.Default.Navigation)

    //Selection
    object Chips : DrawerMenu("Chips", "Selection/Chips", Icons.Default.Notifications)
    object Sliders : DrawerMenu("Sliders", "Selection/Sliders", Icons.Default.DoorSliding)

    //TextInputs
    object TextFields : DrawerMenu("TextFields", "TextInputs/TextFields", Icons.Default.TextFields)

    //Animation
    object AnimatedVisibility : DrawerMenu("AnimatedVisibility", "Animation/AnimatedVisibility", Icons.Default.Animation)
    object AnimatedAsState : DrawerMenu("AnimatedAsState", "Animation/AnimatedAsState", Icons.Default.Animation)
    object AnimatedContent : DrawerMenu("AnimatedContent", "Animation/AnimatedContent", Icons.Default.Animation)
    object UpdateTransition : DrawerMenu("UpdateTransition", "Animation/UpdateTransition", Icons.Default.Animation)

    // Showcases
    object SamsungAlarm : DrawerMenu("SamsungAlarm", "Showcases/SamsungAlarm", Icons.Default.Alarm)
    object SamsungSettings: DrawerMenu("SamsungSettings","Showcases/SamsungSettings", Icons.Default.Settings)
    object GoogleMail: DrawerMenu("GoogleMail", "Showcases/GoogleMail", Icons.Default.Mail)
    object YoutubeMusic: DrawerMenu("YoutubeMusic", "Showcases/YoutubeMusic", Icons.Default.LibraryMusic)


}
