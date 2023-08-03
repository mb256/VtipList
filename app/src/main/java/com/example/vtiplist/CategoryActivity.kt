package com.example.vtiplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vtiplist.ui.theme.VtipListTheme
import androidx.compose.foundation.lazy.items

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VtipListTheme {
                JokeList(jokes)
            }
        }
    }
}

var jokes = listOf<String>(
    "Joke 1",
    "Joke 2",
    "Joke 3",
    "Joke 4",
    "Joke 5",
    "Joke 6",
    "Joke 7",
    "Joke 8",
    "Joke 9"
)


@Composable
fun JokeList2(jokes: List<String>) {
    MyUI()
}

@Composable
fun JokeList(jokes: List<String>) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .background(Color(0xff111111))
    ) {

        Headline()

        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))

//        jokes.forEach { joke ->
//            JokeRow(joke)
//        }

//        /**
//         * import androidx.compose.foundation.lazy.items
//         */
//        LazyColumn {
//            items(jokes) { joke ->
//                JokeRow(joke)
//            }
//        }

        MyUI()


    }
}


@Composable
fun Headline(modifier: Modifier = Modifier) {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Vtip list",
        color = Color.White,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.weight(1F)
            .background(Color.Black),
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Gray, offset = offset, blurRadius = 3f
            )
        )
    )
}


@Composable
fun JokeRow(joke: String) {
    Card(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth()) {
            Text(
                text = joke,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            )
        }
}


@Composable
fun MyUI() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        item {
            Text(text = "First Item")
        }

        items(count = 14) { countValue ->
            Text(text = "Items: $countValue")
        }

        item {
            Text(text = "Last Item")
        }
    }
}

/////////////////////////////////////////
// PREVIEWS
/////////////////////////////////////////

@Preview(showBackground = true)
@Composable
fun JokeListPreview() {
    VtipListTheme {
        JokeList(jokes)
    }
}

@Preview(showBackground = true)
@Composable
fun JokeList2Preview() {
    VtipListTheme {
        JokeList2(jokes)
    }
}