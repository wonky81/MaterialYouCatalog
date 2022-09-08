package wonky.product.materialyoucatalog.ui.screen.selection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.selection.MYAssistChip
import wonky.product.materialyoucatalog.ui.components.selection.MYFilterChip
import wonky.product.materialyoucatalog.ui.components.selection.MYInputChip
import wonky.product.materialyoucatalog.ui.components.selection.MYSuggestionChip
import wonky.product.materialyoucatalog.ui.screen.*

@Composable
fun ChipScreen() {
    var assistChipEnabled by remember { mutableStateOf(true) }
    var assistChipHasLeadingIcon by remember { mutableStateOf(true) }
    var assistChipHasTrailingIcon by remember { mutableStateOf(false) }
    var filterChipEnabled by remember { mutableStateOf(true) }
    var filterChipHasSelected by remember { mutableStateOf(false) }
    var filterChipHasLeadingIcon by remember { mutableStateOf(true) }
    var filterChipHasTrailingIcon by remember { mutableStateOf(false) }
    var inputChipEnabled by remember { mutableStateOf(true) }
    var inputChipHasSelected by remember { mutableStateOf(false) }
    var inputChipHasLeadingIcon by remember { mutableStateOf(true) }
    var inputChipHasTrailingIcon by remember { mutableStateOf(false) }
    var inputChipHasAvatar by remember { mutableStateOf(false) }
    var suggestionChipEnabled by remember { mutableStateOf(true) }
    var suggestionChipHasIcon by remember { mutableStateOf(true) }

    MaterialContents {
        Overview(stringResource(R.string.overview_chips))
        MaterialElementScreen(
            title = "Assist Chip",
            componentContent = {
                MYAssistChip(
                    enabled = assistChipEnabled,
                    hasLeadingIcon =  assistChipHasLeadingIcon,
                    hasTrailingIcon = assistChipHasTrailingIcon
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(
                        checked = assistChipEnabled,
                        onCheckedChange = { assistChipEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = assistChipHasLeadingIcon,
                        onCheckedChange = { assistChipHasLeadingIcon = it },
                        text = "Leading Icon"
                    )
                    CheckBoxWithText(
                        checked = assistChipHasTrailingIcon,
                        onCheckedChange = { assistChipHasTrailingIcon = it },
                        text = "Trailing Icon"
                    )
                }
            }
        )
        MaterialElementScreen(
            title = "Filter Chip",
            componentContent = {
                MYFilterChip(
                    enabled = filterChipEnabled,
                    hasSelected = filterChipHasSelected,
                    hasLeadingIcon =  filterChipHasLeadingIcon,
                    hasTrailingIcon = filterChipHasTrailingIcon
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(
                        checked = filterChipEnabled,
                        onCheckedChange = { filterChipEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = filterChipHasSelected,
                        onCheckedChange = { filterChipHasSelected = it },
                        text = "Selected"
                    )
                }
                Row{
                    CheckBoxWithText(
                        checked = filterChipHasLeadingIcon,
                        onCheckedChange = { filterChipHasLeadingIcon = it },
                        text = "Leading Icon"
                    )
                    CheckBoxWithText(
                        checked = filterChipHasTrailingIcon,
                        onCheckedChange = { filterChipHasTrailingIcon = it },
                        text = "Trailing Icon"
                    )
                }
            }
        )
        MaterialElementScreen(
            title = "Input Chip",
            componentContent = {
                MYInputChip(
                    enabled = inputChipEnabled,
                    hasSelected = inputChipHasSelected,
                    hasLeadingIcon = inputChipHasLeadingIcon,
                    hasTrailingIcon =  inputChipHasTrailingIcon,
                    hasAvatar = inputChipHasAvatar
                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = inputChipEnabled,
                        onCheckedChange = { inputChipEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = inputChipHasSelected,
                        onCheckedChange = { inputChipHasSelected = it },
                        text = "Selected"
                    )
                    CheckBoxWithText(
                        checked = inputChipHasLeadingIcon,
                        onCheckedChange = { inputChipHasLeadingIcon = it },
                        text = "Leading Icon"
                    )
                }
                Row{
                    CheckBoxWithText(
                        checked = inputChipHasTrailingIcon,
                        onCheckedChange = { inputChipHasTrailingIcon = it },
                        text = "Trailing Icon"
                    )
                    CheckBoxWithText(
                        checked = inputChipHasAvatar,
                        onCheckedChange = { inputChipHasAvatar = it },
                        text = "Avatar"
                    )
                }
            }
        )
        MaterialElementScreen(
            title = "Suggestion Chip",
            componentContent = {
                MYSuggestionChip(
                    enabled = suggestionChipEnabled,
                    hasIcon = suggestionChipHasIcon
                )
            },
            controlContent = {
                Row{
                    CheckBoxWithText(
                        checked = suggestionChipEnabled,
                        onCheckedChange = { suggestionChipEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = suggestionChipHasIcon,
                        onCheckedChange = { suggestionChipHasIcon = it },
                        text = "Icon"
                    )
                }
            }
        )
        Spacer16v()
    }
}