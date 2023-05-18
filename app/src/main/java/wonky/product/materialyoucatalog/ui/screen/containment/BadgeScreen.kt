package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeScreen() {

    MaterialContents {
        Overview(content = stringResource(R.string.overview_badge))
        MaterialElementScreen(
            title = "Small badge",
            componentContent = {
                Column {
                    BadgedBox(badge = {
                        Badge(modifier = Modifier.size(6.dp))
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = null
                        )
                    }
                }
            },
            controlContent = {

            }
        )
        MaterialElementScreen(
            title = "Large badge Label",
            componentContent = {
                Column {
                    BadgedBox(badge = {
                        Badge {
                            val badgeNumber = "8"
                            Text(
                                text = badgeNumber
                            )
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = null
                        )
                    }
                }
            },
            controlContent = {

            }
        )

        MaterialElementScreen(
            title = "Large badge In Navigation Item",
            componentContent = {
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    NavigationDrawerItem(
                        label = { Text("Photos") },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Photo,
                                contentDescription = null
                            )
                        },
                        badge = {
                            Badge {
                                val badgeNumber = "999+"
                                Text(
                                    text = badgeNumber
                                )
                            }
                        },
                        selected = true,
                        onClick = { /*TODO*/ }
                    )
                }

            },
            controlContent = {

            }
        )
    }

}
