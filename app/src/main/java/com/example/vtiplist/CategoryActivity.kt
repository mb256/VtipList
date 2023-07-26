package com.example.vtiplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VtipListTheme {
                CategoryJokeList("Empty ...")
            }
        }
    }
}

@Composable
fun CategoryJokeList(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            //.fillMaxSize()
            .background(Color(0xff111111)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Headline(modifier.weight(1F))
        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))

        Text(
            text = "Some joke 1",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Black)
        )
        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))
        Text(
            text = "Some joke 2",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Black)
        )
        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))
        Text(
            text = "Some joke 3",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Black)
        )
        Spacer(modifier = Modifier
            .height(15.dp)
            .background(Color.DarkGray))
        Text(
            text = "Some joke 4",
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .background(Color.Black)
        )
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


@Preview(showBackground = true)
@Composable
fun CategoryJokeListPreview() {
    VtipListTheme {
        CategoryJokeList("Android")
    }
}