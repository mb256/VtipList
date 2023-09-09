package com.example.vtiplist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vtiplist.ui.theme.VtipListTheme


const val ARG_JOKES_CAT_LIST = "JokesCategoryList"
//const val ARG_JOKE_CAT = "JokesCategory"

var intentKeyList = listOf<String>(
    "muzi_zeny",
    "cerny_humor",
    "prace",
    "IT"
)

var jokesAll = Jokes()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VtipListTheme {
                    Greeting()
            }
        }
    }
}


@Composable
fun RandomJoke(modifier: Modifier, joke: Joke) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            //.wrapContentHeight()
            //.heightIn(0.dp, 300.dp) //mention max height here
            //.height(500.dp)
    ) {
        Text(
            text = "Náhodný vtip: ",
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
        Spacer(modifier = Modifier
            .height(5.dp)
            .background(Color.Gray))
        Text(
            text = joke.jokeText,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .verticalScroll(state = rememberScrollState())
        )
    }
}


data class CategoryDescr(
    @DrawableRes val imageRes: Int,
    val text: String,
    val jokeList: List<Joke>
)

@Composable
fun JokeCategory(modifier: Modifier, jokes: Jokes) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color(0xff111111))
            //.background(Color.DarkGray)
            //.wrapContentHeight()
            .fillMaxSize()
    )
    {
        Text(text = "Kategorie vtipů:",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
        Spacer(modifier = Modifier.height(5.dp))

        val cat1 = CategoryDescr(R.drawable.figure, "Muži a ženy", jokes.getCategoryJokes(intentKeyList[0]))
        val cat2 = CategoryDescr(R.drawable.figure, "Černý humor", jokes.getCategoryJokes(intentKeyList[1]))
        val cat3 = CategoryDescr(R.drawable.figure, "Práce", jokes.getCategoryJokes(intentKeyList[2]))
        val cat4 = CategoryDescr(R.drawable.figure, "IT", jokes.getCategoryJokes(intentKeyList[3]))
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(5.dp))
        RowCategory(cat3, cat4)
        Spacer(modifier = Modifier.height(5.dp))
//        RowCategory(cat1, cat2)
//        Spacer(modifier = Modifier.height(5.dp))
    }
}


val myListItems = listOf<String>(
    "One", "Two", "Three", "Four", "Five", "Six"
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryGrid() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        //verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(myListItems.size) { item ->
                Text(
                    text = "Items: $item ...",
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun Category(
    cat: CategoryDescr,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .background(Color.DarkGray)
    ) {

    // Fetching the Local Context
    val mContext = LocalContext.current

    val intent = Intent(mContext, CategoryActivity::class.java)
    //intent.putExtra(intentKeyList[0], intentKeyList[0])
    intent.putExtra(ARG_JOKES_CAT_LIST, cat.jokeList[0].jokeCategory)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                //.wrapContentSize()
                .background(Color.Black)
                .clickable {
                    mContext.startActivity(
//                        Intent(
//                            mContext,
//                            CategoryActivity::class.java
//                        )
                        intent
                    )
                }
        ) {
            Image(
                painter = painterResource(id = cat.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    //.size(64.dp)
                    .size(96.dp)
                    //.clip(CircleShape)
                    .background(Color.Black)
            )
            Text(
                text = cat.text,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    //.padding(horizontal = 16.dp)
                    .background(Color.Black)
            )
        }
}

@Composable
fun RowCategory(
    cat1: CategoryDescr,
    cat2: CategoryDescr,
) {
            Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xff111111))
                .fillMaxWidth())
            {
                Category(cat1, modifier = Modifier.weight(1F))
                Spacer(modifier = Modifier.width(10.dp))
                Category(cat2, modifier = Modifier.weight(1F))
    }
}

@Composable
fun JustImage() {
    Image(
        painter = painterResource(id = R.drawable.figure),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(128.dp)
    )
}

@Composable
fun Greeting() {

    //val jokesAll = Jokes()
    val randomJoke = jokesAll.getRandomJoke()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff111111)),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        val offset = Offset(5.0f, 10.0f)
        Text(text = "Vtip list",
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Black),
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Gray, offset = offset, blurRadius = 3f
                )
            )
        )
        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))
        RandomJoke(modifier = Modifier.weight(6F), randomJoke)
        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))
        JokeCategory(modifier = Modifier.weight(4F), jokesAll)
        Spacer(modifier = Modifier.height(5.dp))
    }
}


//////////////////////////////////////////////////////
// PREVIEWS
//////////////////////////////////////////////////////

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VtipListTheme {
        Greeting()
    }
}

@Preview(showBackground = true)
@Composable
fun RandomJokePreview() {
    val jokeList = Jokes()
    val randomJoke = jokeList.getRandomJoke()
    RandomJoke(modifier = Modifier.wrapContentHeight(), randomJoke)
}

@Preview
@Composable
fun JokeCategoryPreview() {
    val jokesAll = Jokes()
    JokeCategory(modifier = Modifier.wrapContentSize(), jokesAll)
}

@Preview
@Composable
fun RowCategoryPreview() {
    val jokes = Jokes()
    val cat1 = CategoryDescr(R.drawable.figure, "Muži a ženy", jokes.getCategoryJokes(intentKeyList[0]))
    val cat2 = CategoryDescr(R.drawable.figure, "Černý humor", jokes.getCategoryJokes(intentKeyList[1]))
    RowCategory(cat1, cat2)
}

@Preview
@Composable
fun CategoryPreview() {
    val jokes = Jokes()
    val cat1 = CategoryDescr(R.drawable.figure, "Muži a ženy", jokes.getCategoryJokes(intentKeyList[0]))
    Category(cat1)
}

@Preview(showBackground = true)
@Composable
fun JustImagePreview() {
    JustImage()
}
