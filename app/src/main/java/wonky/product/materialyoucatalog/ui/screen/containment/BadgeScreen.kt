package wonky.product.materialyoucatalog.ui.screen.containment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@Composable
fun BadgeScreen() {

    val smallBadgeCode =
        """
        BadgedBox(badge = {
            Badge(modifier = Modifier.size(6.dp))
        }) {
            Icon(
                imageVector = Icons.Filled.Mail,
                contentDescription = null
            )
        }
    """
    val smallBadgeRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(BadgedBox|Badge|size|Icon(?!s))\\s*", functionColor))
        add(Pair("(badge\\s*=|modifier\\s*=|imageVector\\s*=|contentDescription\\s*=)\\s*", parameterColor))
    }

    val largeBadgeCode =
        """
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
    """
    val largeBadgeRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(BadgedBox|Badge|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(badge\\s*=|text\\s*=|imageVector\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(8\\s*)", valueColor))
    }

    val largeBadgeInNavCode =
        """
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
            onClick = {}
        )
    """
    val largeBadgeInNavRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(Pair("(NavigationDrawerItem|Badge|Text|Icon(?!s))\\s*", functionColor))
        add(Pair("(selected\\s*=|onClick\\s*=|label\\s*=|icon\\s*=|badge\\s*=|text\\s*=|imageVector\\s*=|contentDescription\\s*=)\\s*", parameterColor))
        add(Pair("(999+|true\\s*)", valueColor))
    }

    MaterialContents {
        Overview(content = stringResource(R.string.overview_badge))
        MaterialElementScreen(
            title = "Small badge",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(smallBadgeCode,smallBadgeRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(largeBadgeCode, largeBadgeRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
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
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(largeBadgeInNavCode, largeBadgeInNavRegexColorList),
                    style = MaterialTheme.typography.bodySmall
                )
            },
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
