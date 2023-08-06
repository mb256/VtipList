package com.example.vtiplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun JokeList(jokes: List<String>) {
    Column(modifier = Modifier
        //.verticalScroll(rememberScrollState())
        .background(Color.DarkGray)
    ) {

        Headline()

//        Spacer(
//            modifier = Modifier
//                .height(15.dp)
//                .background(Color.DarkGray)
//        )

        ListOfJokes()
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
fun ListOfJokes() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 8.dp),
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
    ) {
        item() {
            Text(text = "Category XY",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(all = 5.dp)
            )
        }

        items(count = 25) { countValue ->
            Text(text = "Items: $countValue \nbla bla bla ...",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black))
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