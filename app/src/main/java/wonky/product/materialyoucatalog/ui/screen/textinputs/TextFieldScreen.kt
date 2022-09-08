package wonky.product.materialyoucatalog.ui.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.components.textinputs.MYBasicTextField
import wonky.product.materialyoucatalog.ui.components.textinputs.MYFilledTextField
import wonky.product.materialyoucatalog.ui.components.textinputs.MYOutlinedFilledTextField
import wonky.product.materialyoucatalog.ui.screen.ComponentArrangement

@Composable
fun TextFieldScreen() {

    var message by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column {
        ComponentArrangement(
            { MYBasicTextField(
                message,
                onMessageChange = {message = it}
            ) },
            { MYFilledTextField(
                message,
                onMessageChange = {message = it},
                label = { Text("Label Area") },
                leadingIcon = { Icon(Icons.Default.Home, contentDescription = null)},
                trailingIcon = { Icon(Icons.Default.Check, contentDescription = null)},
                placeholder = { Text("PlaceHolder Area")},
                isError = isError
            ) },
            { MYOutlinedFilledTextField(
                message,
                onMessageChange = {message = it},
                label = { Text("Label Area") },
                leadingIcon = { Icon(Icons.Default.Home, contentDescription = null)},
                trailingIcon = { Icon(Icons.Default.Check, contentDescription = null)},
                placeholder = { Text("PlaceHolder Area")},
                isError = isError
            ) },
        )
        Divider()
        ControlScreen(
            isError = isError,
            onChangeError = { isError = it}
        )
    }

}


@Composable
fun ControlScreen(
    isError: Boolean,
    onChangeError: (value:Boolean) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Text("isError Enabled")
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Switch(checked = isError, onCheckedChange = onChangeError)
    }
}
