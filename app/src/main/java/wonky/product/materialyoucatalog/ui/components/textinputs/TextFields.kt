package wonky.product.materialyoucatalog.ui.components.textinputs

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

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
    onMessageChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false
){
    TextField(
        value = message,
        onValueChange = onMessageChange,
        label = label,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        placeholder = placeholder,
        isError = isError,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MYOutlinedFilledTextField(
    message: String,
    onMessageChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false
){
    OutlinedTextField(
        value = message,
        onValueChange = onMessageChange,
        label = label,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        placeholder = placeholder,
        isError = isError
    )
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
