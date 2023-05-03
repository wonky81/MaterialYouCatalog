package wonky.product.materialyoucatalog.ui.screen.showcases.samsungalarm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

enum class AlarmMenu {
    Alarm,
    WorldClock,
    Stopwatch,
    Timer
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SamsungAlarmScreen() {
    var currentMenu by remember { mutableStateOf(AlarmMenu.Alarm) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ){
        when (currentMenu) {
            AlarmMenu.Alarm -> {
                AlarmScreen(
                    modifier = Modifier.height(640.dp)
                )
            }
            AlarmMenu.WorldClock -> {
                WorldClockScreen(
                    modifier = Modifier.height(640.dp)
                )
            }
            AlarmMenu.Stopwatch -> {
                StopwatchScreen(
                    modifier = Modifier.height(640.dp)
                )

            }
            AlarmMenu.Timer -> {
                TimerScreen(
                    modifier = Modifier.height(640.dp)
                )
            }
            else -> {
                AlarmScreen(
                    modifier = Modifier.height(640.dp)
                )
            }
        }
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            containerColor = Color.Transparent,
            actions = {
                var alarmSelected by remember { mutableStateOf(true) }
                var worldClockSelected by remember { mutableStateOf(false) }
                var stopWatchSelected by remember { mutableStateOf(false) }
                var timerSelected by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    TextButton(onClick = {
                        alarmSelected = true
                        worldClockSelected = false
                        stopWatchSelected = false
                        timerSelected = false
                        currentMenu = AlarmMenu.Alarm
                    }) {
                        Text(
                            text = "Alarm",
                            color = if(alarmSelected) Color.Black else Color.Gray,
                            style = MaterialTheme.typography.titleMedium.copy( textDecoration = if(alarmSelected) TextDecoration.Underline else TextDecoration.None )
                        )
                    }
                    TextButton(onClick = {
                        alarmSelected = false
                        worldClockSelected = true
                        stopWatchSelected = false
                        timerSelected = false
                        currentMenu = AlarmMenu.WorldClock
                    }) {
                        Text(
                            text = "World Clock",
                            color = if(worldClockSelected) Color.Black else Color.Gray,
                            style = MaterialTheme.typography.titleMedium.copy( textDecoration = if(worldClockSelected) TextDecoration.Underline else TextDecoration.None )
                        )
                    }
                    TextButton(onClick = {
                        alarmSelected = false
                        worldClockSelected = false
                        stopWatchSelected = true
                        timerSelected = false
                        currentMenu = AlarmMenu.Stopwatch
                    }) {
                        Text(
                            text = "Stopwatch",
                            color = if(stopWatchSelected) Color.Black else Color.Gray,
                            style = MaterialTheme.typography.titleMedium.copy( textDecoration = if(stopWatchSelected) TextDecoration.Underline else TextDecoration.None )
                        )
                    }
                    TextButton(onClick = {
                        alarmSelected = false
                        worldClockSelected = false
                        stopWatchSelected = false
                        timerSelected = true
                        currentMenu = AlarmMenu.Timer
                    }) {
                        Text(
                            text = "Timer",
                            color = if(timerSelected) Color.Black else Color.Gray,
                            style = MaterialTheme.typography.titleMedium.copy( textDecoration = if(timerSelected) TextDecoration.Underline else TextDecoration.None )
                        )
                    }
                }
            },
        )
    }




}

@Composable
fun AlarmScreen(
    modifier: Modifier = Modifier
) {

    var firstItemSwitchStatus by remember { mutableStateOf(true) }
    var secondItemSwitchStatus by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "All alarms are off",
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(64.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
        }
        AlarmItem(time = "06:00", message = "Fri, 7 Oct", isOn = firstItemSwitchStatus, onSwitchChange = { firstItemSwitchStatus = it  })
        Spacer(modifier = Modifier.height(12.dp))
        AlarmItem(time = "07:22", message = "Fri, 7 Oct", isOn = secondItemSwitchStatus, onSwitchChange = { secondItemSwitchStatus = it  })
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun AlarmItem(
    time: String,
    message: String,
    isOn: Boolean,
    onSwitchChange: (Boolean) -> Unit
){
    Card(
        modifier = Modifier
            .height(124.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = time,
                color = if(isOn) Color.Black else Color.LightGray,
                style = MaterialTheme.typography.headlineLarge
            )
            Row(
                modifier = Modifier.padding(end = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = message,
                    color = if(isOn) Color.Black else Color.LightGray,
                )
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Switch(checked = isOn,  onCheckedChange = onSwitchChange)
            }
        }

    }
}

@Composable
fun WorldClockScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "17:53:40",
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Korean Standard Time",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(64.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
        }
        ClockItem(
            time = "09:58",
            city = "London",
            message = "8 hours behind"
        )
        Spacer(modifier = Modifier.height(12.dp))
        ClockItem(
            time = "17:58",
            city = "Seoul",
            message = "Local time zone"
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun ClockItem(
    time: String,
    city: String,
    message: String,
){
    Card(
        modifier = Modifier
            .height(124.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column() {
                Text(
                    text = city,
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = message,
                    color = Color.LightGray,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = time,
                color = Color.Black,
                style = MaterialTheme.typography.headlineLarge
            )
        }

    }
}


@Composable
fun StopwatchScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.End),
            onClick = { /*TODO*/ }
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        }
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "00:00.00",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(342.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ){
            Button(
                onClick = { },
                enabled = false
            ){
                Text(
                    text = "Lap",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Button(
                onClick = { },
                enabled = true
            ){
                Text(
                    text = "Start",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimerScreen(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TimeSlider(
                headerText = "Hours",
                timeSlot = Array(100){ it }.map { if(it<10) "0$it" else it }
            )
            Spacer(modifier = Modifier.width(32.dp))
            TimeSlider(
                headerText = "Minutes",
                timeSlot = Array(60){ it }.map { if(it<10) "0$it" else it }
            )
            Spacer(modifier = Modifier.width(32.dp))
            TimeSlider(
                headerText = "Seconds",
                timeSlot = Array(60){ it }.map { if(it<10) "0$it" else it }
            )
        }
        ShortcutTime()
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { },
                enabled = true
            ){
                Text(
                    text = "Start",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

    }
}

@Composable
fun TimeSlider(
    headerText: String,
    timeSlot: List<Any>
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = headerText,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier
                .height(180.dp)
                .requiredWidth(62.dp)
                .padding(start = 6.dp),
            flingBehavior = ScrollableDefaults.flingBehavior(),

            ){
            items(timeSlot){

                Text(
                    text = it.toString(),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }


    //NumberPicker

}

@Composable
fun TimeSlider2(
    headerText: String,
    timeSlot: List<Any>
){
    TimeSliderCustom(
        modifier = Modifier
            .height(180.dp)
            .requiredWidth(62.dp)
            .padding(start = 6.dp),
    ){
        for(i in 0 until 20){
            Text(
                text = "$i",
                style = MaterialTheme.typography.displayMedium
            )
        }

    }
}

@Composable
fun TimeSliderCustom(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    val state = rememberTimeSliderState()

    Layout(
        modifier = modifier.clipToBounds().drag(state),
        content = content
    ){ measurables, constraints ->
        val itemHeight = constraints.maxHeight/3
        val itemConstraints = Constraints.fixed(width = constraints.maxWidth, height = itemHeight)
        val placeables = measurables.map { measurable ->  measurable.measure(itemConstraints)}


        state.setup(
            TimeSliderConfig(
                contentHeight = constraints.maxHeight.toFloat(),
                numItems = placeables.size,
                visibleItems = 3,
                circularFraction = 0f
            )
        )

        layout(
            width = constraints.maxWidth,
            height = constraints.maxHeight
        ){
            for(i in state.firstVisibleItem..state.lastVisibleItem){
                placeables[i].placeRelative(state.offsetFor(i))
            }
        }
    }
}

@Composable
fun ShortcutTime(){
    val shortcutItems = arrayListOf("00:10:00","00:15:00","00:30:00","00:45:00","01:00:00","01:15:00")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(186.dp)
            .padding(32.dp)
    ){
        items(shortcutItems){
            Surface(
                shape = CircleShape,
                color = Color.LightGray,
                modifier = Modifier
                    .size(108.dp)
                    .padding(12.dp),

            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

            }
        }
    }
}