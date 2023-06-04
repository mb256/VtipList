package com.example.vtiplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalConsumer
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

        Column(modifier = Modifier.fillMaxHeight(0.45f)) {
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
                        "bla bla bla bla ...",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(0.45f)) {
            Text(text = "Kategorie vtipů:",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))


            // Do Icons or Buttons ...
            Row() {
                Text(text = "1 Kategorie")
                Spacer(modifier = Modifier.width(25.dp))
                Text(text = "2 Kategorie")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(text = "3 Kategorie")
                Spacer(modifier = Modifier.width(25.dp))
                Text(text = "4 Kategorie")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(text = "5 Kategorie")
                Spacer(modifier = Modifier.width(25.dp))
                Text(text = "6 Kategorie")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VtipListTheme {
        Greeting()
    }
}