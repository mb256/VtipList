package com.example.vtiplist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
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
                val localIntent = intent
                val categoryString = localIntent.getStringExtra(ARG_JOKES_CAT_LIST)

                val jokeList : List<Joke> = if (categoryString != null) {
                    jokesAll.getCategoryJokes(categoryString)
                } else {
                    listOf()
                }

                JokeList(categoryString!!, jokeList)
            }
        }
    }
}


@Composable
fun JokeList(categoryString : String, jokeList: List<Joke>) {

    Column(modifier = Modifier
        .background(Color.DarkGray)
    ) {
        Headline()
        ListOfJokes(categoryString, jokeList)
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
fun ListOfJokes(categoryString : String, jokeList : List<Joke>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 8.dp),
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
    ) {
        item() {
            Text(text = categoryMapText[categoryString]!!,
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(all = 10.dp)
            )
        }

        items(jokeList) { joke ->

            Box(contentAlignment = Alignment.BottomEnd) {
                Text(
                    text = joke.jokeText + "\n",
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(all = 10.dp)
                )

                ///////////////////////////////////
                // For share functionality:
                val mContext = LocalContext.current
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)

                IconButton(onClick = { mContext.startActivity(sendIntent) }) {
                    Icon(
                        Icons.Filled.Share,
                        contentDescription = "Localized description",
                        tint = Color(0xFFFFFFFF)
                    )
                }
            }
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
        val jokeList = jokesAll.getCategoryJokes(categoryList[0])
        JokeList(categoryList[0], jokeList)
    }
}