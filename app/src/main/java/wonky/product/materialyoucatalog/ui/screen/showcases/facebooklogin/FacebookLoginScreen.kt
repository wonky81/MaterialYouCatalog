package wonky.product.materialyoucatalog.ui.screen.showcases.facebooklogin

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import wonky.product.materialyoucatalog.R


val blueColor = Color(0xFF2765C2)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacebookLoginScreen() {

    var isInputFocused by remember { mutableStateOf(false) }
    val composableScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    var showBottomSheet by remember { mutableStateOf(false) }
    var sheetState = rememberModalBottomSheetState()
    BackHandler(enabled = true) {
        composableScope.launch {
            if (isInputFocused) focusManager.clearFocus(true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderLogo(
            modifier = if (isInputFocused) Modifier.weight(0.4f) else Modifier.weight(1f),
            isInputFocused = isInputFocused,
            onLanguageTextClicked = {
                showBottomSheet = true
            }
        )
        LoginInputFields(
            modifier = Modifier.weight(1f),
            onInputFocused = { isInputFocused = it }
        )
        CreateNewAccount(modifier = Modifier.weight(1f))
    }
    if (showBottomSheet) {
        BottomSheet(
            sheetState = sheetState,
            onClose = { showBottomSheet = false }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun BottomSheet(
    sheetState: SheetState,
    onClose: () -> Unit
) {
    val languageList = listOf(
        "English (UK)",
        "한국어",
        "Polski",
        "Bahasa Indonesia",
        "Deutsch",
        "Suomi",
        "Eesti"
    )
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onClose() }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(onClick = { onClose() }) {
                Icon(Icons.Filled.Close, null)
            }
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Please select a language",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(6.dp)
                            .background(color = Color.White),
                    ) {
                        languageList.forEach { item ->
                            LanguageItem(language = item, selected = item == "English (UK)")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LanguageItem(
    language: String,
    selected: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = language,
            style = MaterialTheme.typography.titleMedium
        )
        RadioButton(selected = selected, onClick = { /*TODO*/ })
    }
}

@Composable
fun HeaderLogo(
    modifier: Modifier = Modifier,
    isInputFocused: Boolean,
    onLanguageTextClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (!isInputFocused) {
            TextButton(onClick = { onLanguageTextClicked() }) {
                Text(
                    text = "English (UK)",
                    color = Color.Black.copy(alpha = 0.6f),
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Spacer(modifier = Modifier.height(78.dp))
        }
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.facebook_icon),
            contentDescription = null
        )
    }
}

@Composable
fun CreateNewAccount(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 20.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(width = 1.dp, color = blueColor)
        ) {
            Text(
                text = "Create new account",
                color = blueColor,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "\u221E Meta",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
    }

}

@Composable
fun LoginInputFields(
    modifier: Modifier = Modifier,
    onInputFocused: (Boolean) -> Unit
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .onFocusEvent { if (it.hasFocus) onInputFocused(true) else onInputFocused(false) },
            label = {
                Text(
                    text = "Mobile number or email address",
                    color = Color.DarkGray.copy(alpha = 0.8f)
                )
            },
            value = id,
            onValueChange = { id = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = blueColor,
                cursorColor = blueColor
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .onFocusEvent { if (it.hasFocus) onInputFocused(true) else onInputFocused(false) },
            label = {
                Text(
                    text = "Password",
                    color = Color.DarkGray.copy(alpha = 0.8f)
                )
            },
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = blueColor,
                cursorColor = blueColor
            ),
            keyboardOptions = KeyboardOptions(keyboardType = if (isPasswordVisible) KeyboardType.Text else KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }

            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = blueColor)
        ) {
            Text(
                text = "Log In",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
        }
        TextButton(
            modifier = Modifier.padding(top = 6.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = "Find your account or password"
            )
        }
    }

}