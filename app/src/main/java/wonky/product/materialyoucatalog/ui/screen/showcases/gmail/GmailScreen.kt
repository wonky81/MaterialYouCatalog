package wonky.product.materialyoucatalog.ui.screen.showcases.gmail


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random

private const val TAG = "GmailScreen"

@Composable
fun GmailMainScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar()
        MailContents()
    }
}

@Composable
fun MailContents() {

    val lazyListState = rememberLazyListState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = "Primary",
                style = MaterialTheme.typography.labelMedium
            )
            LazyColumn(
                state = lazyListState
            ) {
                items(mailMockData) { item ->
                    MailItem(
                        sender = item.sender,
                        title = item.title,
                        contents = item.contents,
                        date = item.date,
                        isFavorite = item.isFavorite
                    )
                }
            }
        }
        val fabModifier =
            if (lazyListState.isScrollingUp()) Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 100.dp, end = 24.dp)
            else Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 24.dp, end = 24.dp)
        FloatingActionButton(
            modifier = fabModifier,
            onClick = { /*TODO*/ }
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = null
                )
                if (lazyListState.isScrollingUp()) {
                    Spacer(modifier = Modifier.width(18.dp))
                    Text("Compose")
                }
            }
        }
        if (lazyListState.isScrollingUp()) {
            BottomAppBar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Mail,
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.VideoCall,
                            contentDescription = null
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun MailItem(
    sender: String = "Google Play",
    title: String = "Security Notification",
    contents: String = "Google Play announced that the users who purchased product in play store should be careful of phishing.",
    date: String = "14 Apr",
    isFavorite: Boolean = true
) {

    val randomCircleShapeColor = listOf(
        Color.Cyan,
        Color.Green,
        Color(0xFFFF9800),
        Color.Blue,
        Color.Magenta
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CircleShapeText(
            text = sender[0].toString(),
            backgroundColor = randomCircleShapeColor[Random(System.currentTimeMillis()).nextInt(5)],
            textColor = MaterialTheme.colorScheme.onPrimary,
            size = 60.dp
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = sender,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = contents,
                fontWeight = FontWeight.Light,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelMedium
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall
            )
            IconButton(
                modifier = Modifier.size(32.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.StarRate else Icons.Default.StarBorder,
                    tint = if (isFavorite) Color(0xFFFF9800) else LocalContentColor.current,
                    contentDescription = null
                )
            }

        }

    }

}

@Composable
fun SearchBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = "Search in emails",
                style = MaterialTheme.typography.titleMedium,
            )
            CircleShapeText(
                text = "U",
                backgroundColor = Color.Magenta,
                textColor = MaterialTheme.colorScheme.onPrimary,
                size = 48.dp
            )
        }

    }
}

@Composable
fun CircleShapeText(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    size: Dp
) {
    Surface(
        modifier = Modifier
            .size(size)
            .padding(6.dp)
            .clickable { },
        shape = CircleShape,
        color = backgroundColor
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.titleMedium
            )
        }

    }
}

@Composable
private fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}