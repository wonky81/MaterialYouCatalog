package wonky.product.materialyoucatalog.ui.screen

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import wonky.product.materialyoucatalog.CatalogTheme
import wonky.product.materialyoucatalog.MainViewModel
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.drawer.DrawerMenu
import wonky.product.materialyoucatalog.ui.drawer.DrawerScreen
import wonky.product.materialyoucatalog.ui.screen.actions.ButtonScreen
import wonky.product.materialyoucatalog.ui.screen.communication.ProgressIndicatorScreen
import wonky.product.materialyoucatalog.ui.screen.components.BottomAppBarScreen
import wonky.product.materialyoucatalog.ui.screen.components.TextFieldScreen
import wonky.product.materialyoucatalog.ui.screen.containment.CardScreen
import wonky.product.materialyoucatalog.ui.screen.selection.ChipScreen
import wonky.product.materialyoucatalog.ui.screen.style.FontScreen

private const val TAG = "MainScreen"


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
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var addPaletteDialog by remember { mutableStateOf(false) }
    var selectedMenuRouteInDrawer by remember { mutableStateOf(DrawerMenu.Palette.route) }
    var fabShow by remember { mutableStateOf(false) }
    var bottomSheetHeight by remember { mutableStateOf(320.dp) }
    var bottomSheetContent by remember { mutableStateOf<(@Composable () -> Unit)>({ Text("This should not be shown")}) }

    Surface(color = MaterialTheme.colorScheme.background) {
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
                sheetContent ={ BottomSheetContent( bottomSheetHeight, bottomSheetContent ) },
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
        ){
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

){
    val composableScope = rememberCoroutineScope()
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
                    IconButton(onClick = { onChangePaletteDialog(true) }) {
                        Icon(Icons.Filled.ColorLens, null)
                    }

                }
            )
        },
        floatingActionButton = {
            if(fabShow){
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
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding())) {
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
                    ButtonScreen(onChangeBottomSheetContent, onChangeBottomSheetHeight)
                    onChangeFabShow(false)
                }
                composable(DrawerMenu.Cards.route) {
                    CardScreen(onChangeBottomSheetContent, onChangeBottomSheetHeight)
                    onChangeFabShow(true)
                }
                composable(DrawerMenu.BottomAppBar.route){ BottomAppBarScreen() }
                composable(DrawerMenu.TextFields.route){ TextFieldScreen() }
                composable(DrawerMenu.Fonts.route){ FontScreen() }
                composable(DrawerMenu.ProgressIndicators.route){ ProgressIndicatorScreen() }
                composable(DrawerMenu.Chips.route){ ChipScreen() }

            }
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