package wonky.product.materialyoucatalog.ui.components.selection

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYAssistChip(
    enabled: Boolean = true,
    hasLeadingIcon: Boolean = false,
    hasTrailingIcon: Boolean = false
) {
    AssistChip(
        enabled = enabled,
        label = {
                Text("Assist Chip")
        },
        leadingIcon = {
            if(hasLeadingIcon) Icon(Icons.Filled.Notifications, null)
        },
        trailingIcon = {
            if(hasTrailingIcon) Icon(Icons.Filled.Check, null)
        },
        onClick = { /*TODO*/ }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYFilterChip(
    enabled: Boolean = true,
    hasSelected: Boolean = true,
    hasLeadingIcon: Boolean = false,
    hasTrailingIcon: Boolean = false
) {
    FilterChip(
        enabled = enabled,
        selected = hasSelected,
        label = {
            Text("Filter Chip")
        },
        leadingIcon = {
            if(hasLeadingIcon) Icon(Icons.Filled.Notifications, null)
        },
        trailingIcon = {
            if(hasTrailingIcon) Icon(Icons.Filled.Check, null)
        },
        onClick = { /*TODO*/ }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYInputChip(
    enabled: Boolean = true,
    hasSelected: Boolean = true,
    hasLeadingIcon: Boolean = false,
    hasTrailingIcon: Boolean = false,
    hasAvatar: Boolean = false
) {
    InputChip(
        enabled = enabled,
        selected = hasSelected,
        label = {
            Text("Input Chip")
        },
        leadingIcon = {
            if(hasLeadingIcon) Icon(Icons.Filled.Notifications, null)
        },
        trailingIcon = {
            if(hasTrailingIcon) Icon(Icons.Filled.Check, null)
        },
        avatar = {
            if(hasAvatar) Icon(Icons.Filled.Person,null)
        },
        onClick = { /*TODO*/ }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYSuggestionChip(
    enabled: Boolean = true,
    hasIcon: Boolean
) {
    SuggestionChip(
        enabled = enabled,
        label = {
            Text("Suggestion Chip")
        },
        icon = {
            if(hasIcon) Icon(Icons.Filled.Notifications, null)
        },
        onClick = { /*TODO*/ }
    )
}

