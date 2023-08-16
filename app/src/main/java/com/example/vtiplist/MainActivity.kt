package com.example.vtiplist

import android.content.Intent
import android.media.midi.MidiOutputPort
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.vtiplist.ui.theme.VtipListTheme


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
            text = "Tri gracie prijdou do baru ... a bla \n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...\n" +
                    "bla bla bla bla ...",
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
    val text: String
)

@Composable
fun JokeCategory(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            //.background(Color(0xff111111))
            .background(Color.LightGray)
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

        val cat1 = CategoryDescr(R.drawable.figure, "Category 1")
        val cat2 = CategoryDescr(R.drawable.body_shape, "Category 2")
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(5.dp))
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(5.dp))
        RowCategory(cat1, cat2)
        Spacer(modifier = Modifier.height(5.dp))
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
        .background(Color.Green)
    ) {

    // Fetching the Local Context
    val mContext = LocalContext.current

    // Do Icons or Buttons ...
//    Button(onClick = {
//        mContext.startActivity(Intent(mContext, CategoryActivity::class.java))
//    }
//        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                //.wrapContentSize()
                .background(Color.Black)
                .clickable { mContext.startActivity(Intent(mContext, CategoryActivity::class.java)) }
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
    //}
}

@Composable
fun RowCategory(cat1: CategoryDescr,
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
        JokeCategory(modifier = Modifier.weight(4F))
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
fun CategoryRowTemp(text1: String, text2: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color(0xff111111))
            //.fillMaxWidth()
            .padding(0.dp)
    )
    {
        // Fetching the Local Context
        val mContext = LocalContext.current

        val cat1 = CategoryDescr(R.drawable.figure, "Kat. 1")
        val cat2 = CategoryDescr(R.drawable.body_shape, "Kat 2")
        val cat3 = CategoryDescr(R.drawable.ic_launcher_foreground, "Droid")

        // Do Icons or Buttons ...
        Button(onClick = {
            mContext.startActivity(Intent(mContext, CategoryActivity::class.java))
        },
            modifier = Modifier
                .background(Color.Black)
                .border(
                    BorderStroke(5.dp, Color.Yellow)
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentSize()
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = cat3.imageRes),
                    contentDescription = null,
                    //contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(256.dp)
                        //.size(96.dp)
                        //.clip(CircleShape)
                        .weight(1f)
                        .background(Color.Black)
                        .border(
                            BorderStroke(5.dp, Color.Yellow),
                            CircleShape
                        )
                )
                Text(
                    text = cat1.text,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        //.padding(horizontal = 16.dp)
                        .weight(1f)
                        .background(Color.Black)
                )
            }
        }
//        Text(text = text1,
//            fontSize = 24.sp,
//            color = Color.White,
//            modifier = Modifier.weight(1F))
        Text(text = text2,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.weight(1F))
    }
}

@Composable
fun CategoryTemp() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xff111111)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        CategoryRowTemp("One", "Two")
        CategoryRowTemp("Three", "Four")
        CategoryRowTemp("Five", "Six")
    }
}

@Composable
fun CategoryPics() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xff111111)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(R.drawable.figure),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(480.dp)
                //.size(96.dp)
                //.clip(CircleShape)
                .weight(1f)
                .background(Color.Black)
//                .border(
//                    BorderStroke(5.dp, Color.Yellow),
//                    CircleShape
//                )
        )
        Image(
            painter = painterResource(R.drawable.figure),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(480.dp)
                //.size(96.dp)
                //.clip(CircleShape)
                .weight(1f)
                .background(Color.Black)
//                .border(
//                    BorderStroke(5.dp, Color.Yellow),
//                    CircleShape
//                )
        )
        Image(
            painter = painterResource(R.drawable.figure),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(480.dp)
                //.size(96.dp)
                //.clip(CircleShape)
                .weight(1f)
                .background(Color.Black)
//                .border(
//                    BorderStroke(5.dp, Color.Yellow),
//                    CircleShape
//                )
        )
    }
}



//////////////////////////////////////////////////////
// PREVIEWS
//////////////////////////////////////////////////////

@Preview(showBackground = true)
@Composable
fun CategoryPicsPreview() {
    CategoryPics()
}


@Preview(showBackground = true)
@Composable
fun CategoryRowPreview() {
    CategoryRowTemp("One", "Two")
}

@Preview(showBackground = true)
@Composable
fun CategoryTempPreview() {
    CategoryTemp()
}


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
    RandomJoke(modifier = Modifier.wrapContentHeight())
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
    JokeCategory(modifier = Modifier.wrapContentHeight())
}
@Preview(showBackground = true)
@Composable
fun JustImagePreview() {
    JustImage()
}
@Preview(showBackground = true)
@Composable
fun CategoryGridPreview() {
    CategoryGrid()
}