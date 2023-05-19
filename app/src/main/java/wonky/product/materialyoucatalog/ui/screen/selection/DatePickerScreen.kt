package wonky.product.materialyoucatalog.ui.screen.selection

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import wonky.product.materialyoucatalog.R
import wonky.product.materialyoucatalog.ui.screen.MaterialContents
import wonky.product.materialyoucatalog.ui.screen.MaterialElementScreen
import wonky.product.materialyoucatalog.ui.screen.Overview
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerScreen() {
    val datePickerState = rememberDatePickerState(
        initialDisplayMode = DisplayMode.Picker,
        initialSelectedDateMillis = System.currentTimeMillis()
    )
    val dateRangePickerState = rememberDateRangePickerState(
        initialDisplayMode = DisplayMode.Picker,
        initialSelectedStartDateMillis = System.currentTimeMillis(),
        initialSelectedEndDateMillis = addDays(System.currentTimeMillis(), 3)
    )

    var showDatePickerDialog by remember { mutableStateOf(false) }
    var showDateRangePickerDialog by remember { mutableStateOf(false) }


    MaterialContents {
        Overview(content = stringResource(R.string.overview_date_picker))
        MaterialElementScreen(
            title = "Date Picker",
            componentContent = {
                Column {
                    Text("Selected Date : ${datePickerState.selectedDateMillis?.let { formatDate(it) }}")
                }
            },
            controlContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { showDatePickerDialog = true }) {
                        Text("Show Date Picker Dialog")
                    }
                }
            }
        )

        MaterialElementScreen(
            title = "Date Range Picker",
            componentContent = {
                Column {
                    Text("Selected Start Date : ${dateRangePickerState.selectedStartDateMillis?.let { formatDate(it) }}")
                    Text("Selected End Date : ${dateRangePickerState.selectedEndDateMillis?.let { formatDate(it) }}")
                }
            },
            controlContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { showDateRangePickerDialog = true }) {
                        Text("Show Date Range Picker Dialog")
                    }
                }
            }
        )
    }
    if (showDatePickerDialog) {
        DatePickerDialog(
            datePickerState = datePickerState,
            onCloseDialog = { showDatePickerDialog = false }
        )
    }
    if(showDateRangePickerDialog){
        DateRangePickerDialog(
            dateRangePickerState = dateRangePickerState,
            onCloseDialog = { showDateRangePickerDialog = false }
        )
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DatePickerDialog(
    datePickerState: DatePickerState,
    onCloseDialog: () -> Unit,
) {

    DatePickerDialog(
        onDismissRequest = onCloseDialog,
        confirmButton = {
            TextButton(onClick = onCloseDialog) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onCloseDialog) {
                Text("Cancel")
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            DatePicker(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Select Date",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                },
                headline = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = formatDate(System.currentTimeMillis()),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                },
                state = datePickerState,
            )
        }

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DateRangePickerDialog(
    dateRangePickerState: DateRangePickerState,
    onCloseDialog: () -> Unit,
) {

    DatePickerDialog(
        modifier = Modifier.fillMaxHeight(),
        onDismissRequest = onCloseDialog,
        confirmButton = {
            TextButton(onClick = onCloseDialog) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onCloseDialog) {
                Text("Cancel")
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {

            DateRangePicker(
                modifier = Modifier.height(500.dp),
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Select Date Range",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                },
                headline = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = formatDate(System.currentTimeMillis()),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                },
                state = dateRangePickerState,
            )
        }

    }
}

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, MMM d y", Locale.getDefault())
    return format.format(date)
}

fun addDays(currentTime: Long, days: Int) =
    Calendar.getInstance().apply {
        timeInMillis = currentTime
        add(Calendar.DATE, days)
    }.timeInMillis

