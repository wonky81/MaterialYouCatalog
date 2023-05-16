package wonky.product.materialyoucatalog.ui.screen

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import kotlinx.coroutines.launch
import wonky.product.materialyoucatalog.CatalogTheme
import wonky.product.materialyoucatalog.MainViewModel
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.*
import wonky.product.materialyoucatalog.ui.drawer.DrawerMenu
import wonky.product.materialyoucatalog.ui.drawer.DrawerScreen
import wonky.product.materialyoucatalog.ui.screen.actions.ButtonScreen
import wonky.product.materialyoucatalog.ui.screen.animation.AnimateAsStateScreen
import wonky.product.materialyoucatalog.ui.screen.animation.AnimatedContentScreen
import wonky.product.materialyoucatalog.ui.screen.animation.AnimatedVisibilityScreen
import wonky.product.materialyoucatalog.ui.screen.communication.ProgressIndicatorScreen
import wonky.product.materialyoucatalog.ui.screen.containment.CardScreen
import wonky.product.materialyoucatalog.ui.screen.containment.DialogScreen
import wonky.product.materialyoucatalog.ui.screen.containment.ToolTipScreen
import wonky.product.materialyoucatalog.ui.screen.navigation.AppBarScreen
import wonky.product.materialyoucatalog.ui.screen.navigation.NavigationRailScreen
import wonky.product.materialyoucatalog.ui.screen.selection.ChipScreen
import wonky.product.materialyoucatalog.ui.screen.selection.SliderScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.circularcarousel.CircularCarousel
import wonky.product.materialyoucatalog.ui.screen.showcases.circularcarousel.CircularCarouselScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.circularcarousel.HorizontalSliderScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.facebooklogin.FacebookLoginScreen
import wonky.product.materialyoucatalog.ui.screen.showcases.samsungalarm.SamsungAlarmScreen
import wonky.product.materialyoucatalog.ui.screen.style.FontScreen
import wonky.product.materialyoucatalog.ui.screen.textinputs.TextFieldScreen

private const val TAG = "MainScreen"


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
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
    var selectedMenuRouteInDrawer by remember { mutableStateOf(DrawerMenu.Palette.route) }
    var fabShow by remember { mutableStateOf(false) }
    var bottomSheetHeight by remember { mutableStateOf(320.dp) }
    var bottomSheetContent by remember { mutableStateOf<(@Composable () -> Unit)>({ Text("This should not be shown") }) }

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            DrawerScreen(
                selectedMenuRoute = selectedMenuRouteInDrawer,
                onDestinationClicked = {
                    selectedMenuRouteInDrawer = it
                    navController.navigate(it)
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
                drawerState = drawerState,
                navController = navController,
                fabShow = fabShow,
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
    drawerState: DrawerState,
    navController: NavHostController,
    fabShow: Boolean,
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

    DisposableEffect(navController){
        val callback = NavController.OnDestinationChangedListener{controller,_,_->
            sourceCodeProvided = controller.currentDestination?.route?.startsWith("Style") != true
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
                title = { Text(stringResource(R.string.app_title)) },
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
                    if(sourceCodeProvided){
                        IconButton(onClick = { showCodeScreen = true }) {
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
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            NavHost(
                navController = navController,
                startDestination = DrawerMenu.Palette.route,
                modifier = Modifier
            ) {
                composable(DrawerMenu.Palette.route) {
                    PaletteScreen()
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.Buttons.route) {
                    ButtonScreen(
                        onChangeBottomSheetContent = onChangeBottomSheetContent,
                        onChangeBottomSheetHeight = onChangeBottomSheetHeight,

                    )
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.Cards.route) {
                    CardScreen(onChangeBottomSheetContent, onChangeBottomSheetHeight)
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.TextFields.route) { TextFieldScreen() }
                composable(DrawerMenu.Fonts.route) { FontScreen() }
                composable(DrawerMenu.ProgressIndicators.route) { ProgressIndicatorScreen() }
                composable(DrawerMenu.Chips.route) { ChipScreen() }
                composable(DrawerMenu.Sliders.route) { SliderScreen() }
                composable(DrawerMenu.NavigationRail.route) { NavigationRailScreen() }
                composable(DrawerMenu.AppBar.route) { AppBarScreen() }
                composable(DrawerMenu.Dialogs.route) { DialogScreen() }
                composable(DrawerMenu.AnimatedVisibility.route) { AnimatedVisibilityScreen() }
                composable(DrawerMenu.AnimatedAsState.route) { AnimateAsStateScreen() }
                composable(DrawerMenu.AnimatedContent.route) { AnimatedContentScreen() }
                composable(DrawerMenu.SamsungAlarm.route) { SamsungAlarmScreen() }
                composable(DrawerMenu.CircularCarousel.route) { CircularCarouselScreen() }
                composable(DrawerMenu.FacebookLogin.route){
                    FacebookLoginScreen()
                }
                //composable(DrawerMenu.UpdateTransition.route) { UpdateTransitionScreen() }
                composable(DrawerMenu.Tooltips.route){ ToolTipScreen() }

            }
        }
        if(showCodeScreen) SourceCodeScreen(
            currentRoute = currentRoute,
            onDismissed = { showCodeScreen = false }
        )
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
                        columns = GridCells.Fixed(5),
                    ) {
                        items(CatalogTheme.values()) {
                            Column(
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
                                    text = it.paletteName
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
    onDismissed: () -> Unit,
){
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
                ){
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
                when(currentRoute){
                    "Actions/Buttons"-> WebView(state = rememberWebViewState(url = ButtonsLink))
                    "Communication/ProgressIndicators" -> WebView(state = rememberWebViewState(url = ProgressIndicatorLink))
                    "Containment/Cards" -> WebView(state = rememberWebViewState(url = CardsLink))
                    "Containment/Dialogs" -> WebView(state = rememberWebViewState(url = DialogsLink))
                    "Containment/Tooltips" -> WebView(state = rememberWebViewState(url = TooltipsLink))
                    "Navigation/AppBar" -> WebView(state = rememberWebViewState(url = AppBarLink))
                    "Navigation/NavigationRail" -> WebView(state = rememberWebViewState(url = NavigationRailLink))
                    "Selection/Chips" -> WebView(state = rememberWebViewState(url = ChipsLink))
                    "Selection/Sliders" -> WebView(state = rememberWebViewState(url = SlidersLink))
                    "TextInputs/TextFields" -> WebView(state = rememberWebViewState(url = TextFieldsLink))
                    "Animation/AnimatedVisibility" -> WebView(state = rememberWebViewState(url = AnimatedVisibilityLink))
                    "Animation/AnimatedAsState" -> WebView(state = rememberWebViewState(url = AnimatedAsStateLink))
                    "Animation/AnimatedContent" -> WebView(state = rememberWebViewState(url = AnimatedContentLink))
                    "Showcases/SamsungAlarm" -> WebView(state = rememberWebViewState(url = SamsungAlarmScreenLink))
                }
            }
        }

    }

}