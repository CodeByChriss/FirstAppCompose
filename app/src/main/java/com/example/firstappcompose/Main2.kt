package com.example.firstappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme
import kotlin.coroutines.coroutineContext

class Main2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App() // con mayúscula porque 'app()' ya existe en otro fichero
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    var counterLikes by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(horizontal = 8.dp)
    ) {
        item {
            Image(
                painter = painterResource(R.drawable.gatofeo),
                contentDescription = "Imagen de un gato feo",
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Christian's Profile",
                color = colorResource(R.color.white),
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp)
                    .wrapContentSize(Alignment.Center)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                item {
                    Image(
                        painter = painterResource(R.drawable.icon_like),
                        contentDescription = "like",
                        modifier = Modifier.clickable(true, onClick = { counterLikes++ }).padding(horizontal = 8.dp)
                    )
                    Text(
                        text = counterLikes.toString(),
                        color = colorResource(R.color.white),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}