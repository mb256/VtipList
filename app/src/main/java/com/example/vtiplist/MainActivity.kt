package com.example.vtiplist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.core.content.ContextCompat.startActivity
import com.example.vtiplist.ui.theme.VtipListTheme
import kotlin.random.Random


const val ARG_JOKES_CAT_LIST = "JokesCategoryList"

val categoryList = listOf<String>(
    "muzi_zeny",
    "cerny_humor",
    "prace",
    "IT"
)

val categoryMapText = mapOf(
    categoryList[0] to "Muži a ženy",
    categoryList[1] to "Černý humor",
    categoryList[2] to "Práce",
    categoryList[3] to "IT",
)

val jokesAll = Jokes()

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
fun RandomJoke(modifier: Modifier) {

    var randomJokeIndex by remember { mutableStateOf(
        (0..jokesAll.getJokesSize()).random())
    }
    var jokeText = jokesAll.jokeLists.get(randomJokeIndex).jokeText

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.DarkGray,
        contentColor = Color.White)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {

        Box (contentAlignment = Alignment.CenterEnd) {
            Text(
                text = "Náhodný vtip: ",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(all = 10.dp)
            )

            Button(
                colors = mainButtonColor,
                onClick = {
                    randomJokeIndex = Random.nextInt(0, jokesAll.getJokesSize()) }

            ) {
                Text("Další vtip")
            }

        }

        Spacer(modifier = Modifier
            .height(10.dp)
            .background(Color.Gray))

        Box (contentAlignment = Alignment.BottomEnd)
        {
            Text(
                text = jokeText + "\n",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .verticalScroll(state = rememberScrollState())
                    .padding(all = 20.dp)
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
            // ////////////////////////////////
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


data class CategoryDescr(
    @DrawableRes val imageRes: Int,
    val category: String,
    val jokeList: List<Joke>
)

@Composable
fun JokeCategory(modifier: Modifier, jokes: Jokes) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(Color(0xff111111))
            .fillMaxWidth()
    )
    {
        Text(text = "Kategorie vtipů:",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        )
        Spacer(modifier = Modifier.height(10.dp))

        val cat1 = CategoryDescr(R.drawable.figure, categoryList[0], jokes.getCategoryJokes(categoryList[0]))
        val cat2 = CategoryDescr(R.drawable.figure, categoryList[1], jokes.getCategoryJokes(categoryList[1]))
        val cat3 = CategoryDescr(R.drawable.figure, categoryList[2], jokes.getCategoryJokes(categoryList[2]))
        val cat4 = CategoryDescr(R.drawable.figure, categoryList[3], jokes.getCategoryJokes(categoryList[3]))
        RowCategory(Modifier.fillMaxWidth(), cat1, cat2)
        Spacer(modifier = Modifier.height(10.dp))
        RowCategory(Modifier.fillMaxWidth(), cat3, cat4)
        Spacer(modifier = Modifier.height(5.dp))
//        RowCategory(cat1, cat2)
//        Spacer(modifier = Modifier.height(5.dp))
    }
}


@Composable
fun Category(cat: CategoryDescr, modifier : Modifier) {

    // Fetching the Local Context
    val mContext = LocalContext.current

    val intent = Intent(mContext, CategoryActivity::class.java)
    intent.putExtra(ARG_JOKES_CAT_LIST, cat.category)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(Color.Black)
                .clickable {
                    mContext.startActivity(
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
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Text(
                text = categoryMapText[cat.category]!!,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .background(Color.Black)
            )
        }
}

@Composable
fun RowCategory(
    modifier: Modifier = Modifier.fillMaxWidth(),
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
        RandomJoke(modifier = Modifier.weight(6F))
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
    //val index = Random.nextInt(0, jokesAll.getJokesSize())
    val index = (0..jokesAll.getJokesSize()).random()
    RandomJoke(modifier = Modifier.wrapContentHeight())
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
    val cat1 = CategoryDescr(R.drawable.figure, categoryList[0], jokes.getCategoryJokes(categoryList[0]))
    val cat2 = CategoryDescr(R.drawable.figure, categoryList[1], jokes.getCategoryJokes(categoryList[1]))
    RowCategory(Modifier.fillMaxWidth(), cat1, cat2)
}

@Preview
@Composable
fun CategoryPreview() {
    val jokes = Jokes()
    val cat1 = CategoryDescr(R.drawable.figure, categoryList[0], jokes.getCategoryJokes(categoryList[0]))
    Category(cat1, Modifier.fillMaxWidth())
}

@Preview(showBackground = true)
@Composable
fun JustImagePreview() {
    JustImage()
}
