package wonky.product.materialyoucatalog.ui.components.actions

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.ui.screen.ElevationLevel


@Composable
fun MYButton(
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    defaultElevation: Dp = ElevationLevel.Level1.dp,
    disabledElevation: Dp = ElevationLevel.Level1.dp,
    border: BorderStroke? = null,
){
    Button(
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation),
        border = border,
        onClick = { /*TODO*/ }
    ) {
        Text("Button")
    }
}

@Composable
fun MYElevatedButton(
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.elevatedShape,
    colors: ButtonColors = ButtonDefaults.elevatedButtonColors(),
    defaultElevation: Dp = ElevationLevel.Level1.dp,
    disabledElevation: Dp = ElevationLevel.Level1.dp,
    border: BorderStroke? = null,
){
    ElevatedButton(
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation),
        border = border,
        onClick = { /*TODO*/ }
    ) {
        Text("ElevatedButton")
    }
}

@Composable
fun MYFilledTonalButton(
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.filledTonalShape,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    defaultElevation: Dp = ElevationLevel.Level1.dp,
    disabledElevation: Dp = ElevationLevel.Level1.dp,
    border: BorderStroke? = null,
){
    FilledTonalButton(
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation),
        border = border,
        onClick = { /*TODO*/ }
    ) {
        Text("FilledTonalButton")
    }
}

@Composable
fun MYOutlinedButton(
    shape: Shape = ButtonDefaults.outlinedShape,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    border: BorderStroke? = null,
){
    OutlinedButton(
        shape = shape,
        colors = colors,
        border = border,
        onClick = { /*TODO*/ }
    ) {
        Text("OutlinedButton")
    }
}

@Composable
fun MYTextButton(
    enabled: Boolean,
){
    TextButton(
        enabled = enabled,
        onClick = { /*TODO*/ }
    ) {
        Text("TextButton")
    }
}

@Composable
fun MYIconButton(
    enabled: Boolean,
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            enabled = enabled,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYFilledIconButton(
    enabled: Boolean,
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        FilledIconButton(
            enabled = enabled,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYOutlinedIconButton(
    enabled: Boolean,
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedIconButton(
            enabled = enabled,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYOutlinedIconToggleButton(
    enabled: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedIconToggleButton(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYIconToggleButton(
    enabled: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconToggleButton(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYFilledTonalIconButton(
    enabled: Boolean,
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        FilledTonalIconButton(
            enabled = enabled,
            onClick = { }
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYFilledIconToggleButton(
    enabled: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        FilledIconToggleButton(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYFilledTonalIconToggleButton(
    enabled: Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        FilledTonalIconToggleButton(
            enabled = enabled,
            checked = checked,
            onCheckedChange = onCheckedChange
        ) {
            Icon(
                Icons.Filled.Alarm,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MYFloatingActionButton(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Text("FloatingActionButton")
    }
}

@Composable
fun MYExtendedFloatingActionButton(){
    ExtendedFloatingActionButton(
        text = {
            Text("Extended FAB")
        },
        icon = {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Extended FAB"
            )
        },
        onClick = { /*TODO*/ }
    )

}

@Composable
fun MYRadioButton(){
    var selected by remember { mutableStateOf(1) }
    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = selected==1 , onClick = { selected = 1 })
        RadioButton(selected = selected==2 , onClick = { selected = 2 })
        RadioButton(selected = selected==3 , onClick = { selected = 3 })
    }
}
