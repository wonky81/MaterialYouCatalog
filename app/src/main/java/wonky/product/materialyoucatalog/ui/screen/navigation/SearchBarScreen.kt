package wonky.product.materialyoucatalog.ui.screen.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.core.sourcecode_viewer.colorize
import wonky.product.materialyoucatalog.core.sourcecode_viewer.functionColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.parameterColor
import wonky.product.materialyoucatalog.core.sourcecode_viewer.valueColor
import wonky.product.materialyoucatalog.ui.screen.CheckBoxWithText
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarScreen() {

    var queryStringForSearchScreen by remember { mutableStateOf("") }
    var placeholderEnabledForSearchScreen by remember { mutableStateOf(true) }
    var dockedSearchBarEnabledForSearchScreen by remember { mutableStateOf(true) }
    var isActiveForSearchScreen by remember { mutableStateOf(false) }

    var queryString by remember { mutableStateOf("") }
    var searchedString by remember { mutableStateOf(".") }
    var leadingIconEnabled by remember { mutableStateOf(true) }
    var trailingIconEnabled by remember { mutableStateOf(true) }
    var placeholderEnabled by remember { mutableStateOf(true) }
    var dockedSearchBarEnabled by remember { mutableStateOf(true) }
    var isActive by remember { mutableStateOf(false) }


    val searchBarInSearchScreenCode =
        """    
        var queryStringForSearchScreen by remember { mutableStateOf($queryStringForSearchScreen) }
        
        DockedSearchBar(
            enabled = $dockedSearchBarEnabledForSearchScreen,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { queryStringForSearchScreen = $queryStringForSearchScreen }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            },
            placeholder = {
                if ($placeholderEnabledForSearchScreen) {
                    Text(
                        text = "Search the city",
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
                    )
                }
            },
            modifier = Modifier.padding(16.dp),
            query = $queryStringForSearchScreen,
            onQueryChange = { queryStringForSearchScreen = it },
            onSearch = {},
            active = queryStringForSearchScreen.isNotBlank(),
            onActiveChange = {
                isActiveForSearchScreen = it
            }
        ) {
            if (queryStringForSearchScreen.isNotBlank()) {
                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text("The result of $queryStringForSearchScreen has been searched.")
                }
            }
        }
    """
    val searchBarInSearchScreenRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(
            Pair(
                "(Column|DockedSearchBar|IconButton|mutableStateOf|Text|copy|padding|isNotBlank|Icon(?!s))\\s*",
                functionColor
            )
        )
        add(
            Pair(
                "(vertical\\s*=|alpha\\s*=|fontWeight\\s*=|color\\s*=|text\\s*=|imageVector\\s*=|contentDescription\\s*=|onQueryChange\\s*=|onSearch\\s*=|active\\s*=|onActiveChange\\s*=|enabled\\s*=|leadingIcon\\s*=|trailingIcon\\s*=|placeholder\\s*=|modifier\\s*=|query\\s*=|onClick\\s*=)\\s*",
                parameterColor
            )
        )
        add(Pair("(8.dp|0.6f|true|false|null\\s*)", valueColor))
    }


    val dockedSearchBarCode =
        """    
        DockedSearchBar(
            enabled = $dockedSearchBarEnabled,
            leadingIcon = {
                if ($leadingIconEnabled) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    }
                }
            },
            trailingIcon = {
                if ($trailingIconEnabled) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    }
                }
            },
            placeholder = {
                if ($placeholderEnabled) {
                    Text(
                        text = "Search the city",
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
                    )
                }
            },
            modifier = Modifier.padding(16.dp),
            query = $queryString,
            onQueryChange = { queryString = it },
            onSearch = {
                searchedString = $queryString
            },
            active = $isActive,
            onActiveChange = {}
        ) {
            if (searchedString == queryString) {
                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text("The result of $queryString has been searched.")
                }

            }
        }
    """
    val dockedSearchBarRegexColorList = mutableListOf<Pair<String, Color>>().apply {
        add(
            Pair(
                "(Column|DockedSearchBar|IconButton|Text|copy|padding|Icon(?!s))\\s*",
                functionColor
            )
        )
        add(
            Pair(
                "(vertical\\s*=|alpha\\s*=|fontWeight\\s*=|color\\s*=|text\\s*=|imageVector\\s*=|contentDescription\\s*=|onQueryChange\\s*=|onSearch\\s*=|active\\s*=|onActiveChange\\s*=|enabled\\s*=|leadingIcon\\s*=|trailingIcon\\s*=|placeholder\\s*=|modifier\\s*=|query\\s*=|onClick\\s*=)\\s*",
                parameterColor
            )
        )
        add(Pair("(8.dp|0.6f|true|false|null\\s*)", valueColor))
    }


    MaterialContents {
        Overview(content = stringResource(R.string.overview_search_bar))

        MaterialElementScreen(
            title = "Search Bar in Search Screen ",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        searchBarInSearchScreenCode,
                        searchBarInSearchScreenRegexColorList
                    ),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {
                Column {
                    DockedSearchBar(
                        enabled = dockedSearchBarEnabledForSearchScreen,
                        leadingIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            }

                        },
                        trailingIcon = {
                            IconButton(onClick = { queryStringForSearchScreen = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = null
                                )
                            }
                        },
                        placeholder = {
                            if (placeholderEnabledForSearchScreen) {
                                Text(
                                    text = "Search the city",
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
                                )
                            }
                        },
                        modifier = Modifier.padding(16.dp),
                        query = queryStringForSearchScreen,
                        onQueryChange = { queryStringForSearchScreen = it },
                        onSearch = {},
                        active = queryStringForSearchScreen.isNotBlank(),
                        onActiveChange = {
                            isActiveForSearchScreen = it
                        }
                    ) {
                        if (queryStringForSearchScreen.isNotBlank()) {
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Text("The result of $queryStringForSearchScreen has been searched.")
                            }

                        }
                    }
                }
            },
            controlContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row {
                        CheckBoxWithText(
                            checked = dockedSearchBarEnabledForSearchScreen,
                            onCheckedChange = { dockedSearchBarEnabledForSearchScreen = it },
                            text = "Enabled"
                        )
                        CheckBoxWithText(
                            checked = placeholderEnabledForSearchScreen,
                            onCheckedChange = { placeholderEnabledForSearchScreen = it },
                            text = "Placeholder"
                        )

                    }
                }
            }
        )

        MaterialElementScreen(
            title = "Docked Search Bar",
            hasSourceCode = true,
            sourceCodeContent = {
                Text(
                    text = colorize(
                        dockedSearchBarCode,
                        dockedSearchBarRegexColorList
                    ),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            componentContent = {
                Column {
                    DockedSearchBar(
                        enabled = dockedSearchBarEnabled,
                        leadingIcon = {
                            if (leadingIconEnabled) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null
                                    )
                                }
                            }
                        },
                        trailingIcon = {
                            if (trailingIconEnabled) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.AccountCircle,
                                        contentDescription = null
                                    )
                                }
                            }
                        },
                        placeholder = {
                            if (placeholderEnabled) {
                                Text(
                                    text = "Search the city",
                                    fontWeight = FontWeight.Light,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
                                )
                            }
                        },
                        modifier = Modifier.padding(16.dp),
                        query = queryString,
                        onQueryChange = { queryString = it },
                        onSearch = {
                            searchedString = queryString
                        },
                        active = isActive,
                        onActiveChange = {}
                    ) {
                        if (searchedString == queryString) {
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Text("The result of $queryString has been searched.")
                            }

                        }
                    }
                }
            },
            controlContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row {
                        CheckBoxWithText(
                            checked = dockedSearchBarEnabled,
                            onCheckedChange = { dockedSearchBarEnabled = it },
                            text = "Enabled"
                        )
                        CheckBoxWithText(
                            checked = leadingIconEnabled,
                            onCheckedChange = { leadingIconEnabled = it },
                            text = "Leading Icon"
                        )
                        CheckBoxWithText(
                            checked = trailingIconEnabled,
                            onCheckedChange = { trailingIconEnabled = it },
                            text = "Trailing Icon"
                        )
                    }
                    Row {
                        CheckBoxWithText(
                            checked = placeholderEnabled,
                            onCheckedChange = { placeholderEnabled = it },
                            text = "Placeholder"
                        )
                        CheckBoxWithText(
                            checked = isActive,
                            onCheckedChange = { isActive = it },
                            text = "IsActive"
                        )
                    }
                }
            }
        )

    }

}