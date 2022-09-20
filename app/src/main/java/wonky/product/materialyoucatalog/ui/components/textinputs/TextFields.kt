package wonky.product.materialyoucatalog.ui.components.textinputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/*

    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,

 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYFilledTextField(
    message: String,
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    onMessageChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    hasLeadingIcon: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    hasSupportingText: Boolean = false,
    supportingText: String = "",
){
    Column() {
        TextField(
            value = message,
            onValueChange = onMessageChange,
            enabled = isEnabled,
            readOnly = isReadOnly,
            label = label,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeholder = placeholder,
            isError = isError,
        )
        if (hasSupportingText) {
            Text(
                text = supportingText,
                color = if(isError) MaterialTheme.colorScheme.error else Color.Unspecified,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYOutlinedFilledTextField(
    message: String,
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    onMessageChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    hasLeadingIcon: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    hasSupportingText: Boolean = false,
    supportingText: String = "",
){
    Column() {
        OutlinedTextField(
            value = message,
            onValueChange = onMessageChange,
            enabled = isEnabled,
            readOnly = isReadOnly,
            label = label,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeholder = placeholder,
            isError = isError,
        )
        if (hasSupportingText) {
            Text(
                text = supportingText,
                color = if(isError) MaterialTheme.colorScheme.error else Color.Unspecified,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }

}

@Composable
fun MYBasicTextField(
    message: String,
    onMessageChange: (String) -> Unit
){
    BasicTextField(value = message, onValueChange = onMessageChange)
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialYouCatalogTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MYFilledTextField()
            MYOutlinedFilledTextField()
            MYBasicTextField()
        }
    }
}*/
