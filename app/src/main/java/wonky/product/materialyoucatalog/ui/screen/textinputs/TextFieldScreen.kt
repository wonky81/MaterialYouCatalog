package wonky.product.materialyoucatalog.ui.screen.textinputs

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.components.containment.MYFilledCard
import wonky.product.materialyoucatalog.ui.components.textinputs.MYBasicTextField
import wonky.product.materialyoucatalog.ui.components.textinputs.MYFilledTextField
import wonky.product.materialyoucatalog.ui.components.textinputs.MYOutlinedFilledTextField
import wonky.product.materialyoucatalog.ui.screen.*

@Composable
fun TextFieldScreen() {

    var filledTextFieldEnabled by remember { mutableStateOf(true) }
    var filledTextFieldReadOnly by remember { mutableStateOf(false) }
    var filledTextFieldHasLabel by remember { mutableStateOf(true) }
    var filledTextFieldHasLeadingIcon by remember { mutableStateOf(true) }
    var filledTextFieldHasTrailingIcon by remember { mutableStateOf(true) }
    var filledTextFieldHasPlaceHolder by remember { mutableStateOf(true) }
    var filledTextFieldHasSupportingText by remember { mutableStateOf(false) }
    var filledTextFieldIsError by remember { mutableStateOf(false) }

    var outlinedFilledTextFieldEnabled by remember { mutableStateOf(true) }
    var outlinedFilledTextFieldReadOnly by remember { mutableStateOf(false) }
    var outlinedFilledTextFieldHasLabel by remember { mutableStateOf(true) }
    var outlinedFilledTextFieldHasLeadingIcon by remember { mutableStateOf(true) }
    var outlinedFilledTextFieldHasTrailingIcon by remember { mutableStateOf(true) }
    var outlinedFilledTextFieldHasPlaceHolder by remember { mutableStateOf(true) }
    var outlinedFilledTextFieldHasSupportingText by remember { mutableStateOf(false) }
    var outlinedFilledTextFieldIsError by remember { mutableStateOf(false) }

    var message by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    MaterialContents {
        Overview(stringResource(R.string.overview_textfield))
        MaterialElementScreen(
            title = "Filled TextField",
            componentContent = {
                MYFilledTextField(
                    message = message,
                    isEnabled = filledTextFieldEnabled,
                    isReadOnly = filledTextFieldReadOnly,
                    onMessageChange = { message = it },
                    label = { if(filledTextFieldHasLabel) Text("Label Area") },
                    hasLeadingIcon = filledTextFieldHasLeadingIcon,
                    hasTrailingIcon = filledTextFieldHasTrailingIcon,
                    placeholder = { if(filledTextFieldHasPlaceHolder) Text("PlaceHolder Area") },
                    hasSupportingText = filledTextFieldHasSupportingText,
                    supportingText = "Supporting Text",
                    isError = filledTextFieldIsError
                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = filledTextFieldEnabled,
                        onCheckedChange = { filledTextFieldEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = filledTextFieldReadOnly,
                        onCheckedChange = { filledTextFieldReadOnly = it },
                        text = "ReadOnly"
                    )
                    CheckBoxWithText(
                        checked = filledTextFieldHasLabel,
                        onCheckedChange = { filledTextFieldHasLabel = it },
                        text = "Label"
                    )
                }
                Row {
                    CheckBoxWithText(
                        checked = filledTextFieldHasLeadingIcon,
                        onCheckedChange = { filledTextFieldHasLeadingIcon = it },
                        text = "LeadingIcon"
                    )
                    CheckBoxWithText(
                        checked = filledTextFieldHasTrailingIcon,
                        onCheckedChange = { filledTextFieldHasTrailingIcon = it },
                        text = "TrailingIcon"
                    )
                }
                Row{
                    CheckBoxWithText(
                        checked = filledTextFieldHasPlaceHolder,
                        onCheckedChange = { filledTextFieldHasPlaceHolder = it },
                        text = "PlaceHolder"
                    )
                    CheckBoxWithText(
                        checked = filledTextFieldIsError,
                        onCheckedChange = { filledTextFieldIsError = it },
                        text = "Error"
                    )
                    CheckBoxWithText(
                        checked = filledTextFieldHasSupportingText,
                        onCheckedChange = { filledTextFieldHasSupportingText = it },
                        text = "SupportingText"
                    )
                }
            }
        )

        MaterialElementScreen(
            title = "Outlined Filled TextField",
            componentContent = {
                MYOutlinedFilledTextField(
                    message = message,
                    isEnabled = outlinedFilledTextFieldEnabled,
                    isReadOnly = outlinedFilledTextFieldReadOnly,
                    onMessageChange = { message = it },
                    label = { if(outlinedFilledTextFieldHasLabel) Text("Label Area") },
                    hasLeadingIcon = outlinedFilledTextFieldHasLeadingIcon,
                    hasTrailingIcon = outlinedFilledTextFieldHasTrailingIcon,
                    placeholder = { if(outlinedFilledTextFieldHasPlaceHolder) Text("PlaceHolder Area") },
                    hasSupportingText = outlinedFilledTextFieldHasSupportingText,
                    supportingText = "Supporting Text",
                    isError = outlinedFilledTextFieldIsError
                )
            },
            controlContent = {
                Row {
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldEnabled,
                        onCheckedChange = { outlinedFilledTextFieldEnabled = it },
                        text = "Enabled"
                    )
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldReadOnly,
                        onCheckedChange = { outlinedFilledTextFieldReadOnly = it },
                        text = "ReadOnly"
                    )
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldHasLabel,
                        onCheckedChange = { outlinedFilledTextFieldHasLabel = it },
                        text = "Label"
                    )
                }
                Row {
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldHasLeadingIcon,
                        onCheckedChange = { outlinedFilledTextFieldHasLeadingIcon = it },
                        text = "LeadingIcon"
                    )
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldHasTrailingIcon,
                        onCheckedChange = { outlinedFilledTextFieldHasTrailingIcon = it },
                        text = "TrailingIcon"
                    )
                }
                Row{
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldHasPlaceHolder,
                        onCheckedChange = { outlinedFilledTextFieldHasPlaceHolder = it },
                        text = "PlaceHolder"
                    )
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldIsError,
                        onCheckedChange = { outlinedFilledTextFieldIsError = it },
                        text = "Error"
                    )
                    CheckBoxWithText(
                        checked = outlinedFilledTextFieldHasSupportingText,
                        onCheckedChange = { outlinedFilledTextFieldHasSupportingText = it },
                        text = "SupportingText"
                    )
                }
            }
        )
    }
}


@Composable
fun ControlScreen(
    isError: Boolean,
    onChangeError: (value: Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text("isError Enabled")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Switch(checked = isError, onCheckedChange = onChangeError)
    }
}
