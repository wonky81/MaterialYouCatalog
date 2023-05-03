package wonky.product.materialyoucatalog.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/*
shape
elevation
border



 */

enum class ElevationLevel(val dp: Dp){
    Level0(0.0.dp),
    Level1(1.0.dp),
    Level2(3.0.dp),
    Level3(6.0.dp),
    Level4(8.0.dp),
    Level5(12.0.dp),
}


@Composable
fun <T> RadioButtonGroup(elements: Array<T>){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        elements.forEach {



        }
    }

}

@Composable
fun ComponentArrangement(vararg content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (item in content) {
            item()
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
        }
    }

}

@Composable
fun MaterialContents(content: @Composable () -> Unit){
    Column(
        modifier = Padding12h().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
    ) {
        content()
    }
}

@Composable
fun Spacer6() = Spacer(modifier = Modifier.padding(6.dp))

@Composable
fun Spacer6v() = Spacer(modifier = Modifier.padding(vertical = 6.dp))

@Composable
fun Spacer4() = Spacer(modifier = Modifier.padding(4.dp))

@Composable
fun Spacer4h() = Spacer(modifier = Modifier.padding(horizontal = 4.dp))

@Composable
fun Spacer8h() = Spacer(modifier = Modifier.padding(horizontal = 8.dp))

@Composable
fun Spacer12() = Spacer(modifier = Modifier.padding(12.dp))

@Composable
fun Spacer8v() = Spacer(modifier = Modifier.padding(vertical = 8.dp))

@Composable
fun Spacer16v() = Spacer(modifier = Modifier.padding(vertical = 16.dp))

@Composable
fun Spacer32v() = Spacer(modifier = Modifier.padding(vertical = 32.dp))

@Composable
fun Padding6h() = Modifier.padding(horizontal = 6.dp)

@Composable
fun Padding8h() = Modifier.padding(horizontal = 8.dp)

@Composable
fun Padding12h() = Modifier.padding(horizontal = 12.dp)

@Composable
fun Padding16h() = Modifier.padding(horizontal = 16.dp)

@Composable
fun Div6v() = Divider(modifier = Modifier.padding(vertical = 6.dp))

@Composable
fun MainTitle(title: String){
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SubTitleSmall(
    title: String,
    modifier: Modifier = Modifier
){
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = 4.dp)
    )
}

@Composable
fun SubTitleLarge(
    title: String,
    modifier: Modifier = Modifier
){
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = 4.dp)
    )
}

@Composable
fun MainMessage(message: String){
    Text(
        text = message,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(start = 4.dp)
    )
}

@Composable
fun MainWarningMessage(message: String){
    Text(
        text = message,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(start = 4.dp)
    )
}

@Composable
fun SmallText(message: String) {
    Text(
        text = message,
        style = MaterialTheme.typography.labelLarge,
        modifier = Modifier.padding(start = 2.dp)
    )
}

@Composable
fun CheckBoxWithText(
    enabled: Boolean = true,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String
){
    Row(verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
        )
    }
}


@Composable
fun MaterialElementScreen(
    modifier: Modifier = Modifier,
    title: String,
    componentContent: @Composable () -> Unit,
    controlContent: @Composable () -> Unit = {}
){
    //Div6v()
    Spacer32v()
    SubTitleLarge(title = title)
    Spacer8v()
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.surfaceVariant )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        ){
            componentContent()
        }
    }
    Spacer8v()
    controlContent()
}

@Composable
fun ElevationSelector(
    modifier: Modifier,
    text: String,
    elevation: ElevationLevel,
    onChangeElevation: (ElevationLevel) -> Unit,
){
    var dropDownMenuExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("$text : ")
        Spacer4h()
        Box{
            OutlinedButton(
                shape = RectangleShape,
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                onClick = { dropDownMenuExpanded = !dropDownMenuExpanded }
            ) {
                Text("${elevation.name} (${elevation.dp})")
                Spacer4h()
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
            DropdownMenu(expanded = dropDownMenuExpanded, onDismissRequest = { dropDownMenuExpanded = false }) {
                ElevationLevel.values().forEach {
                    DropdownMenuItem(
                        text = { Text("${it.name} (${it.dp})")},
                        onClick = {
                            dropDownMenuExpanded = false
                            onChangeElevation(it)
                        }
                    )
                }
            }
        }
    }

}


@Composable
fun ElevationSelector(
    modifier: Modifier,
    text: String,
    elevation: Dp,
    onChangeElevation: (Dp) -> Unit,
){
    var dropDownMenuExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("$text : ")
        Spacer4h()
        Box{
            OutlinedButton(
                shape = RectangleShape,
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
                onClick = { dropDownMenuExpanded = !dropDownMenuExpanded }
            ) {
                Text("${elevation}")
                Spacer4h()
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }
            DropdownMenu(expanded = dropDownMenuExpanded, onDismissRequest = { dropDownMenuExpanded = false }) {
                ElevationLevel.values().forEach {
                    DropdownMenuItem(
                        text = { Text("(${it.dp})")},
                        onClick = {
                            dropDownMenuExpanded = false
                            onChangeElevation(it.dp)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun DialogCloseButton(
    modifier: Modifier = Modifier,
    position: Alignment = Alignment.TopEnd,
    onClick: () -> Unit,
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = position
    ) {
        IconButton(onClick = onClick) {
            Icon(
                Icons.Filled.Close,
                contentDescription = null
            )
        }
    }

}