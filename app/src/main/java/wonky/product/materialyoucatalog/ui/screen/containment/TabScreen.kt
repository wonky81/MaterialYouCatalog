package wonky.product.materialyoucatalog.ui.screen.containment

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.screen.CheckBoxWithText
import wonky.product.materialyoucatalog.ui.screen.ElevationSelector
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview


sealed class TabMenu(
    val title: String,
    val icon: ImageVector

){
    object VideoTab: TabMenu("Video", Icons.Default.VideoCall)
    object PlayListTab: TabMenu("PlayList", Icons.Default.PlayCircle)
    object SettingsTab: TabMenu("Settings", Icons.Default.Settings)
}


private val TabMenus = listOf(
    TabMenu.VideoTab,
    TabMenu.PlayListTab,
    TabMenu.SettingsTab
)



@Composable
fun TabScreen(){
    val selectedColor = MaterialTheme.colors.primary
    val defaultColor = MaterialTheme.colors.onSurface

    var primaryTabSelectedIndex by remember { mutableStateOf(0) }
    var showIcons by remember { mutableStateOf(true) }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_tab))
        MaterialElementScreen(
            title = "Tabs",
            componentContent = {
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    TabRow(
                        selectedTabIndex = primaryTabSelectedIndex,
                        indicator = { tabPositions ->
                            if (primaryTabSelectedIndex < tabPositions.size) {
                                TabRowDefaults.Indicator(
                                    modifier = Modifier.tabIndicatorOffset(tabPositions[primaryTabSelectedIndex]),
                                    color = selectedColor
                                )
                            }
                        }
                    ) {
                        TabMenus.forEachIndexed{ index, menu ->
                            val selected = primaryTabSelectedIndex == index
                            if(showIcons){
                                Tab(
                                    selected = selected,
                                    onClick = { primaryTabSelectedIndex = index },
                                    text = { Text(text = menu.title, maxLines = 1, overflow = TextOverflow.Ellipsis, color = if(selected) selectedColor else defaultColor) },
                                    icon = { Icon(imageVector = menu.icon, tint = if(selected) selectedColor else defaultColor, contentDescription = null)}
                                )
                            }else{
                                Tab(
                                    selected = selected,
                                    onClick = { primaryTabSelectedIndex = index },
                                    text = { Text(text = menu.title, maxLines = 1, overflow = TextOverflow.Ellipsis, color = if(selected) selectedColor else defaultColor) },
                                )
                            }

                        }
                    }
                }
            },
            controlContent = {
                Column {
                    CheckBoxWithText(
                        checked = showIcons,
                        onCheckedChange = { showIcons = it },
                        text = "Show Icons"
                    )
                }
            }
        )
    }
}