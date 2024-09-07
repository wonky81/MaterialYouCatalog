package wonky.product.materialyoucatalog.ui.components.actions

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.StarBorder
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
        elevation = ButtonDefaults.buttonElevation(defaultElevation = defaultElevation, disabledElevation = disabledElevation),
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
        Text("Elevated Button")
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
        Text("FilledTonal Button")
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
        Text("textButton")
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
fun MYSingleChoiceSegmentedButton(
    enabled: Boolean
){
    var selectedIndex by remember { mutableStateOf(0) }
    val options = listOf("First", "Second", "Third")
    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                enabled = enabled
            ){
                Text(label)
            }
        }
    }
}

@Composable
fun MYMultiChoiceSegmentedButton(
    enabled: Boolean
){
    val checkedList = remember { mutableStateListOf<Int>() }
    val options = listOf("Favorites", "Trending", "Saved")
    val icons = listOf(
        Icons.Filled.StarBorder,
        Icons.AutoMirrored.Filled.TrendingUp,
        Icons.Filled.BookmarkBorder
    )
    MultiChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                icon = {
                    SegmentedButtonDefaults.Icon(active = index in checkedList) {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = null,
                            modifier = Modifier.size(SegmentedButtonDefaults.IconSize)
                        )
                    }
                },
                onCheckedChange = {
                    if (index in checkedList) {
                        checkedList.remove(index)
                    } else {
                        checkedList.add(index)
                    }
                },
                checked = index in checkedList,
                enabled = enabled
            ) {
                Text(label)
            }
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
