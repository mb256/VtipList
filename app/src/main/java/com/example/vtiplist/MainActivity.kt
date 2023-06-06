package com.example.vtiplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vtiplist.ui.theme.VtipListTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VtipListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun RandomJoke(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Náhodný vtip: ",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Tri gracie prijdou do baru ... a bla \n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


data class CategoryDescr(
    @DrawableRes val imageRes: Int,
    val text: String
)

@Composable
fun JokeCategory(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentHeight())
    {

        Text(text = "Kategorie vtipů:",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))

        val cat1 = CategoryDescr(R.drawable.figure, "Kategorie 1")
        val cat2 = CategoryDescr(R.drawable.body_shape, "Kategorie 2")
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(15.dp))
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(15.dp))
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun Category(
    cat: CategoryDescr,
    modifier: Modifier = Modifier) {
    // Do Icons or Buttons ...
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentSize()
        ) {
            Image(
                painter = painterResource(id = cat.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Text(
                text = cat.text,
                //style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun RowCategory(cat1: CategoryDescr, cat2: CategoryDescr) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Category(cat1)
        Spacer(modifier = Modifier.width(30.dp))
        Category(cat2)
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
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        val offset = Offset(5.0f, 10.0f)
        Text(text = "Vtip list",
            color = Color.DarkGray,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Gray, offset = offset, blurRadius = 3f
                )
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        RandomJoke()
        Spacer(modifier = Modifier.height(32.dp))
        JokeCategory()
        Spacer(modifier = Modifier.height(10.dp))
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
    RandomJoke()
}

@Preview
@Composable
fun CategoryPreview() {
    val cat1 = CategoryDescr(R.drawable.figure, "Kategorie 1")
    Category(cat1)
}

@Preview
@Composable
fun RowCategoryPreview() {
    val cat1 = CategoryDescr(R.drawable.figure, "Kategorie 1")
    val cat2 = CategoryDescr(R.drawable.body_shape, "Kategorie 2")
    RowCategory(cat1, cat2)
}

@Preview(showBackground = true)
@Composable
fun JokeCategoryPreview() {
    JokeCategory()
}
@Preview(showBackground = true)
@Composable
fun JustImagePreview() {
    JustImage()
}