package wonky.product.materialyoucatalog.ui.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import wonky.product.materialyoucatalog.CatalogTheme
import wonky.product.materialyoucatalog.MainViewModel
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ad.FullScreenAd
import wonky.product.materialyoucatalog.core.AnimatedAsStateLink
import wonky.product.materialyoucatalog.core.AnimatedContentLink
import wonky.product.materialyoucatalog.core.AnimatedVisibilityLink
import wonky.product.materialyoucatalog.core.AppBarLink
import wonky.product.materialyoucatalog.core.BadgeScreenLink
import wonky.product.materialyoucatalog.core.BoxLink
import wonky.product.materialyoucatalog.core.ButtonsLink
import wonky.product.materialyoucatalog.core.CardsLink
import wonky.product.materialyoucatalog.core.CarouselLink
import wonky.product.materialyoucatalog.core.CarouselScreenLink
import wonky.product.materialyoucatalog.core.ChipsLink
import wonky.product.materialyoucatalog.core.ColumnAndRowLink
import wonky.product.materialyoucatalog.core.DatePickerLink
import wonky.product.materialyoucatalog.core.DialogsLink
import wonky.product.materialyoucatalog.core.FacebookLoginScreenLink
import wonky.product.materialyoucatalog.core.GmailScreenLink
import wonky.product.materialyoucatalog.core.NavigationRailLink
import wonky.product.materialyoucatalog.core.ProgressIndicatorLink
import wonky.product.materialyoucatalog.core.SamsungAlarmScreenLink
import wonky.product.materialyoucatalog.core.SearchBarLink
import wonky.product.materialyoucatalog.core.SlidersLink
import wonky.product.materialyoucatalog.core.TabLink
import wonky.product.materialyoucatalog.core.TextFieldsLink
import wonky.product.materialyoucatalog.core.TooltipsLink
import wonky.product.materialyoucatalog.ui.drawer.DrawerMenu
import wonky.product.materialyoucatalog.ui.drawer.DrawerScreen
import wonky.product.materialyoucatalog.ui.screen.actions.ButtonScreen
import wonky.product.materialyoucatalog.ui.screen.animation.AnimateAsStateScreen
import wonky.product.materialyoucatalog.ui.screen.animation.AnimatedContentScreen
import wonky.product.materialyoucatalog.ui.screen.animation.AnimatedVisibilityScreen
import wonky.product.materialyoucatalog.ui.screen.communication.ProgressIndicatorScreen
import wonky.product.materialyoucatalog.ui.screen.containment.BadgeScreen
import wonky.product.materialyoucatalog.ui.screen.containment.CardScreen
import wonky.product.materialyoucatalog.ui.screen.containment.CarouselScreen
import wonky.product.materialyoucatalog.ui.screen.containment.DialogScreen
import wonky.product.materialyoucatalog.ui.screen.containment.TabScreen
import wonky.product.materialyoucatalog.ui.screen.containment.ToolTipScreen
import wonky.product.materialyoucatalog.ui.screen.layouts.BoxScreen
import wonky.product.materialyoucatalog.ui.screen.layouts.ColumnAndRowScreen
import wonky.product.materialyoucatalog.ui.screen.navigation.AppBarScreen
import wonky.product.materialyoucatalog.ui.screen.navigation.NavigationRailScreen
import wonky.product.materialyoucatalog.ui.screen.navigation.SearchBarScreen
import wonky.product.materialyoucatalog.ui.screen.selection.ChipScreen
import wonky.product.materialyoucatalog.ui.screen.selection.DatePickerScreen
import wonky.product.materialyoucatalog.ui.screen.selection.SliderScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.circularcarousel.CircularCarouselScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.facebooklogin.FacebookLoginScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.gmail.GmailMainScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.samsungalarm.SamsungAlarmScreen
import wonky.product.materialyoucatalog.ui.screen.style.FontScreen
import wonky.product.materialyoucatalog.ui.screen.textinputs.TextFieldScreen

private const val TAG = "MainScreen"


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
    dynamicColorEnabled: Boolean,
    onChangeDynamicColorEnabled: (Boolean) -> Unit
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val composableScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var addPaletteDialog by remember { mutableStateOf(false) }
    val selectedMenuInDrawer by mainViewModel.selectedMenuInDrawer.collectAsState()
    var fabShow by remember { mutableStateOf(false) }
    var bottomSheetHeight by remember { mutableStateOf(320.dp) }
    var bottomSheetContent by remember { mutableStateOf<(@Composable () -> Unit)>({ Text("This should not be shown") }) }

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            DrawerScreen(
                selectedMenu = selectedMenuInDrawer,
                onDestinationClicked = {
                    mainViewModel.setSelectedMenuInDrawer(it)
                    navController.navigate(it.route)
                    composableScope.launch { drawerState.close() }

                }
            )
        }
    ) {

        ModalBottomSheetLayout(
            sheetContent = { BottomSheetContent(bottomSheetHeight, bottomSheetContent) },
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetState = bottomSheetState,
            scrimColor = Color.Transparent
        ) {
            MainContent(
                mainViewModel = mainViewModel,
                drawerState = drawerState,
                navController = navController,
                fabShow = fabShow,
                currentMenu =  selectedMenuInDrawer,
                onChangePaletteDialog = { addPaletteDialog = it },
                onShowBottomSheet = { composableScope.launch { bottomSheetState.show() } },
                onChangeFabShow = { fabShow = it },
                bottomSheetContent = bottomSheetContent,
                onChangeBottomSheetContent = { bottomSheetContent = it },
                onChangeBottomSheetHeight = { bottomSheetHeight = it }
            )
        }

        if (addPaletteDialog) {
            PaletteDialogScreen(
                mainViewModel = mainViewModel,
                dynamicColorEnabled = dynamicColorEnabled,
                onChangeDynamicColorEnabled = onChangeDynamicColorEnabled,
                onDismissed = { addPaletteDialog = false }
            )
        }


    }

}

@Composable
private fun BottomSheetContent(
    bottomSheetHeight: Dp,
    content: @Composable () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                modifier = Modifier
                    .width(58.dp)
                    .padding(12.dp)
                    .align(Alignment.TopCenter),
                thickness = 4.dp,
                color = Color.Gray
            )
        }
        Column(
            modifier = Modifier
                .height(bottomSheetHeight)
                .fillMaxWidth(),
        ) {
            Spacer16v()
            content()
            Spacer16v()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    mainViewModel: MainViewModel,
    drawerState: DrawerState,
    navController: NavHostController,
    fabShow: Boolean,
    currentMenu: DrawerMenu,
    onChangePaletteDialog: (Boolean) -> Unit,
    onShowBottomSheet: () -> Unit,
    onChangeFabShow: (Boolean) -> Unit,
    bottomSheetContent: @Composable () -> Unit,
    onChangeBottomSheetContent: (@Composable () -> Unit) -> Unit,
    onChangeBottomSheetHeight: (Dp) -> Unit

) {
    val composableScope = rememberCoroutineScope()

    var sourceCodeProvided by remember { mutableStateOf(false) }
    var currentRoute by remember { mutableStateOf("Style/Palette") }
    var showCodeScreen by remember { mutableStateOf(false) }
    val context = LocalContext.current

    DisposableEffect(navController) {
        val callback = NavController.OnDestinationChangedListener { controller, _, _ ->
            sourceCodeProvided = (controller.currentDestination?.route?.startsWith("Style") == true ||
                    controller.currentDestination?.route?.startsWith("Home") == true||
                    controller.currentDestination?.route?.startsWith("Communication/ProgressIndicators") == true||
                    controller.currentDestination?.route?.startsWith("Containment/Dialogs") == true||
                    controller.currentDestination?.route?.startsWith("Containment/Tooltips") == true||
                    controller.currentDestination?.route?.startsWith("Containment/Badges") == true||
                    controller.currentDestination?.route?.startsWith("Containment/Tab") == true||
                    controller.currentDestination?.route?.startsWith("Containment/Carousel") == true||
                    controller.currentDestination?.route?.startsWith("Navigation/AppBar") == true||
                    controller.currentDestination?.route?.startsWith("Actions/Buttons") == true)!= true
            controller.currentDestination?.route?.let { currentRoute = it }
        }
        navController.addOnDestinationChangedListener(callback)
        onDispose {
            navController.removeOnDestinationChangedListener(callback)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(currentMenu.title) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            composableScope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                }
                            }
                        },
                        content = {
                            Icon(Icons.Filled.Menu, null)
                        }
                    )
                },
                actions = {
                    if (sourceCodeProvided) {
                        IconButton(onClick = {
                            FullScreenAd.showInterstitial(context = context) {
                                showCodeScreen = true
                            }
                        }) {
                            Icon(Icons.Filled.Code, null)
                        }
                    }

                    IconButton(onClick = { onChangePaletteDialog(true) }) {
                        Icon(Icons.Filled.ColorLens, null)
                    }
                }
            )
        },
        floatingActionButton = {
            if (fabShow) {
                FloatingActionButton(
                    onClick = onShowBottomSheet
                ) {
                    Icon(
                        Icons.Filled.ArrowUpward,
                        contentDescription = null
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            NavHost(
                navController = navController,
                startDestination = DrawerMenu.Home.route,
                modifier = Modifier
            ) {

                composable(DrawerMenu.Home.route) {
                    HomeScreen(
                        mainViewModel = mainViewModel,
                        onSelected = { drawerMenu ->
                            mainViewModel.setSelectedMenuInDrawer(drawerMenu)
                            navController.navigate(drawerMenu.route)
                        }
                    )
                }

                composable(DrawerMenu.Palette.route) {
                    PaletteScreen()
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.Buttons.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    ButtonScreen(
                        onChangeBottomSheetContent = onChangeBottomSheetContent,
                        onChangeBottomSheetHeight = onChangeBottomSheetHeight,

                        )
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.Cards.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    CardScreen(onChangeBottomSheetContent, onChangeBottomSheetHeight)
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.TextFields.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    TextFieldScreen()
                }
                composable(DrawerMenu.Fonts.route) {
                    FontScreen()
                }
                composable(DrawerMenu.ProgressIndicators.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    ProgressIndicatorScreen()
                }
                composable(DrawerMenu.Chips.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    ChipScreen()
                }
                composable(DrawerMenu.Sliders.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    SliderScreen()
                }
                composable(DrawerMenu.NavigationRail.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    NavigationRailScreen()
                }
                composable(DrawerMenu.AppBar.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    AppBarScreen()
                }
                composable(DrawerMenu.Dialogs.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    DialogScreen()
                }
                composable(DrawerMenu.AnimatedVisibility.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    AnimatedVisibilityScreen()
                }
                composable(DrawerMenu.AnimatedAsState.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    AnimateAsStateScreen()
                }
                composable(DrawerMenu.AnimatedContent.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    AnimatedContentScreen()
                }
                composable(DrawerMenu.SamsungAlarm.route) {
                    FullScreenAd.showInterstitial(context = context) {}
                    SamsungAlarmScreen()
                }
                composable(DrawerMenu.CircularCarousel.route) {
                    FullScreenAd.showInterstitial(context = context) {}
                    CircularCarouselScreen()
                }
                composable(DrawerMenu.FacebookLogin.route) {
                    FullScreenAd.showInterstitial(context = context) {}
                    FacebookLoginScreen()
                }
                composable(DrawerMenu.GoogleMail.route) {
                    FullScreenAd.showInterstitial(context = context) {}
                    GmailMainScreen()
                }
                //composable(DrawerMenu.UpdateTransition.route) { UpdateTransitionScreen() }
                composable(DrawerMenu.Tooltips.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    ToolTipScreen()
                }
                composable(DrawerMenu.Badges.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    BadgeScreen()
                }
                composable(DrawerMenu.DatePickers.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    DatePickerScreen()
                }
                composable(DrawerMenu.SearchBar.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    SearchBarScreen()
                }
                composable(DrawerMenu.Tab.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    TabScreen()
                }
                composable(DrawerMenu.ColumnAndRow.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    ColumnAndRowScreen()
                }
                composable(DrawerMenu.Box.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    BoxScreen()
                }
                composable(DrawerMenu.Carousel.route) {
                    if(mainViewModel.checkShowAd()){
                        FullScreenAd.showInterstitial(context = context) {}
                    }
                    CarouselScreen()
                }
            }
        }
        if (showCodeScreen) {
            SourceCodeScreen(
                currentRoute = currentRoute,
                onClose = {
                    showCodeScreen = false
                }
            )
        }
    }


}


@Composable
fun PaletteDialogScreen(
    mainViewModel: MainViewModel,
    dynamicColorEnabled: Boolean,
    onChangeDynamicColorEnabled: (Boolean) -> Unit,
    onDismissed: () -> Unit
) {

    var selectedName by remember { mutableStateOf(mainViewModel.currentTheme) }

    AlertDialog(
        onDismissRequest = onDismissed,
        title = {
            Text("Choose Palette")
        },
        text = {
            Column(
                modifier = Modifier.height(240.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Dynamic Color Enabled")
                    Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                    Switch(
                        checked = dynamicColorEnabled,
                        onCheckedChange = onChangeDynamicColorEnabled
                    )
                }
                if (!dynamicColorEnabled) {

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(4),
                    ) {
                        items(CatalogTheme.values()) {
                            Column(
                                modifier = Modifier.padding(4.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Surface(
                                    shape = RectangleShape,
                                    border = if (selectedName.value != it.paletteName) null else BorderStroke(
                                        4.dp,
                                        Color.White
                                    ),
                                    modifier = Modifier
                                        .size(48.dp)
                                        .padding(horizontal = 4.dp)
                                        .selectable(
                                            selected = selectedName.value == it.paletteName,
                                            onClick = {
                                                if (selectedName.value != it.paletteName) {
                                                    selectedName.value = it.paletteName
                                                    mainViewModel.setCurrentTheme(it.name)
                                                }
                                            }
                                        ),
                                    color = if (isSystemInDarkTheme()) it.darkColorScheme.primary else it.lightColorScheme.primary
                                ) {}
                                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                                Text(
                                    text = it.paletteName,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }

                        }
                    }
                }

            }


        },
        confirmButton = {
            TextButton(
                onClick = onDismissed,
            ) {
                Text("Close")
            }
        }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SourceCodeScreen(
    currentRoute: String,
    onClose: () -> Unit
) {
    val link = when (currentRoute) {
//        "Actions/Buttons" -> ButtonsLink
        "Communication/ProgressIndicators" -> ProgressIndicatorLink
        "Containment/Cards" -> CardsLink
        "Containment/Dialogs" -> DialogsLink
        "Containment/Tooltips" -> TooltipsLink
        "Containment/Badges" -> BadgeScreenLink
        "Navigation/AppBar" -> AppBarLink
        "Navigation/NavigationRail" -> NavigationRailLink
        "Selection/Chips" -> ChipsLink
        "Selection/Sliders" -> SlidersLink
        "TextInputs/TextFields" -> TextFieldsLink
        "Animation/AnimatedVisibility" -> AnimatedVisibilityLink
        "Animation/AnimatedAsState" -> AnimatedAsStateLink
        "Animation/AnimatedContent" -> AnimatedContentLink
        "Showcases/SamsungAlarm" -> SamsungAlarmScreenLink
        "Showcases/FacebookLogin" -> FacebookLoginScreenLink
        "Showcases/GoogleMail" -> GmailScreenLink
        "Showcases/CircularCarousel" -> CarouselScreenLink
        "Selection/DatePickers" -> DatePickerLink
        "Navigation/SearchBar" -> SearchBarLink
        "Containment/Tab" -> TabLink
        "Layouts/ColumnAndRow" -> ColumnAndRowLink
        "Layouts/Box" -> BoxLink
        "Containment/Carousel" -> CarouselLink
        else -> ""
    }
    val uriHandler = LocalUriHandler.current
    uriHandler.openUri(link)
    onClose()
    /*
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = onDismissed
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier.fillMaxSize()

        ) {
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = onDismissed) {
                        Icon(Icons.Filled.Close, contentDescription = null)
                    }
                    Spacer8h()
                    Text(
                        text = "Source Code",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
//                val link = when (currentRoute) {
//                    "Actions/Buttons" -> WebView(state = rememberWebViewState(url = ButtonsLink))
//                    "Communication/ProgressIndicators" -> WebView(state = rememberWebViewState(url = ProgressIndicatorLink))
//                    "Containment/Cards" -> WebView(state = rememberWebViewState(url = CardsLink))
//                    "Containment/Dialogs" -> WebView(state = rememberWebViewState(url = DialogsLink))
//                    "Containment/Tooltips" -> WebView(state = rememberWebViewState(url = TooltipsLink))
//                    "Containment/Badges" -> WebView(state = rememberWebViewState(url = BadgeScreenLink))
//                    "Navigation/AppBar" -> WebView(state = rememberWebViewState(url = AppBarLink))
//                    "Navigation/NavigationRail" -> WebView(state = rememberWebViewState(url = NavigationRailLink))
//                    "Selection/Chips" -> WebView(state = rememberWebViewState(url = ChipsLink))
//                    "Selection/Sliders" -> WebView(state = rememberWebViewState(url = SlidersLink))
//                    "TextInputs/TextFields" -> WebView(state = rememberWebViewState(url = TextFieldsLink))
//                    "Animation/AnimatedVisibility" -> WebView(state = rememberWebViewState(url = AnimatedVisibilityLink))
//                    "Animation/AnimatedAsState" -> WebView(state = rememberWebViewState(url = AnimatedAsStateLink))
//                    "Animation/AnimatedContent" -> WebView(state = rememberWebViewState(url = AnimatedContentLink))
//                    "Showcases/SamsungAlarm" -> WebView(state = rememberWebViewState(url = SamsungAlarmScreenLink))
//                    "Showcases/FacebookLogin" -> WebView(state = rememberWebViewState(url = FacebookLoginScreenLink))
//                    "Showcases/GoogleMail" -> WebView(state = rememberWebViewState(url = GmailScreenLink))
//                    "Showcases/CircularCarousel" -> WebView(state = rememberWebViewState(url = CarouselScreenLink))
//                    "Selection/DatePickers" -> WebView(state = rememberWebViewState(url = DatePickerLink))
//                    "Navigation/SearchBar" -> WebView(state = rememberWebViewState(url = SearchBarLink ))
//                    "Containment/Tab" -> WebView(state = rememberWebViewState(url = TabLink))
//                }

            }

        }
    }*/
}