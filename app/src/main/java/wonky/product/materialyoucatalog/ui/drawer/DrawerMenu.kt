package wonky.product.materialyoucatalog.ui.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.CardMembership
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Dialpad
import androidx.compose.material.icons.filled.DoorSliding
import androidx.compose.material.icons.filled.DragIndicator
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SmartButton
import androidx.compose.material.icons.filled.Tab
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material.icons.filled.ViewSidebar
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenu(val title: String, val route: String, val icon: ImageVector){

    // Home
    object Home: DrawerMenu("Material3 Catalog", "Home", Icons.Filled.Home)

    // Style
    object Palette : DrawerMenu("Palette", "Style/Palette", Icons.Filled.ColorLens)
    object Fonts : DrawerMenu("Fonts", "Style/Fonts", Icons.Filled.FontDownload)

    //Actions
    object Buttons : DrawerMenu("Buttons", "Actions/Buttons", Icons.Filled.SmartButton)

    //Communication
    object ProgressIndicators : DrawerMenu("ProgressIndicators", "Communication/ProgressIndicators", Icons.Filled.DragIndicator)

    //Containment
    object Cards : DrawerMenu("Cards", "Containment/Cards", Icons.Filled.CardMembership)
    object Dialogs : DrawerMenu("Dialogs", "Containment/Dialogs", Icons.Filled.Dialpad)
    object Tooltips : DrawerMenu("Tooltips", "Containment/Tooltips", Icons.Filled.Campaign)
    object Tab : DrawerMenu("Tab", "Containment/Tab", Icons.Filled.Tab)

    object Badges : DrawerMenu("Badges", "Containment/Badges", Icons.Filled.Badge)

    object Carousel : DrawerMenu("Carousel", "Containment/Carousel", Icons.Filled.ViewCarousel)

    //Navigation
    object AppBar : DrawerMenu("AppBar", "Navigation/AppBar", Icons.Filled.ViewSidebar)
    object NavigationRail : DrawerMenu("NavigationRail", "Navigation/NavigationRail", Icons.Filled.Navigation)

    object SearchBar : DrawerMenu( "SearchBar", "Navigation/SearchBar", Icons.Filled.Search)

    //Selection
    object Chips : DrawerMenu("Chips", "Selection/Chips", Icons.Filled.Notifications)
    object Sliders : DrawerMenu("Sliders", "Selection/Sliders", Icons.Filled.DoorSliding)

    object DatePickers: DrawerMenu("DatePickers", "Selection/DatePickers", Icons.Filled.DateRange)

    //TextInputs
    object TextFields : DrawerMenu("TextFields", "TextInputs/TextFields", Icons.Filled.TextFields)

    //Animation
    object AnimatedVisibility : DrawerMenu("AnimatedVisibility", "Animation/AnimatedVisibility", Icons.Filled.Animation)
    object AnimatedAsState : DrawerMenu("AnimatedAsState", "Animation/AnimatedAsState", Icons.Filled.Animation)
    object AnimatedContent : DrawerMenu("AnimatedContent", "Animation/AnimatedContent", Icons.Filled.Animation)
    object UpdateTransition : DrawerMenu("UpdateTransition", "Animation/UpdateTransition", Icons.Filled.Animation)

    object ColumnAndRow: DrawerMenu("Column and Row", "Layouts/ColumnAndRow", Icons.Filled.Layers)

    object Box: DrawerMenu("Box", "Layouts/Box", Icons.Filled.AllInbox)

    // Showcases
    object SamsungAlarm : DrawerMenu("SamsungAlarm", "Showcases/SamsungAlarm", Icons.Filled.Alarm)
    object CircularCarousel : DrawerMenu("CircularCarousel", "Showcases/CircularCarousel", Icons.Filled.ViewCarousel)

    object FacebookLogin : DrawerMenu("FacebookLogin", "Showcases/FacebookLogin", Icons.Filled.Login)

    object SamsungSettings: DrawerMenu("SamsungSettings","Showcases/SamsungSettings", Icons.Filled.Settings)
    object GoogleMail: DrawerMenu("GoogleMail", "Showcases/GoogleMail", Icons.Filled.Mail)
    object YoutubeMusic: DrawerMenu("YoutubeMusic", "Showcases/YoutubeMusic", Icons.Filled.LibraryMusic)


}
