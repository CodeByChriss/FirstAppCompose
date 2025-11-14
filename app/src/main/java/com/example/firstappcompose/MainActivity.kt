package com.example.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}

@Preview (showBackground = true)
@Composable
fun app(){
    LazyColumn(Modifier.fillMaxSize()){
        item{
            Image(painterResource(R.drawable.gatofeo),"gato muy guapo", Modifier.fillMaxWidth())
//            OutlinedTextField()
            Text("hola mundo", Modifier.padding(12.dp))
            Text("hola clase", fontSize = 18.sp, modifier = Modifier.padding(12.dp))
        }

        item {
            LazyRow(){
                item{
                    Text("soy roooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooow")
                }
            }
        }
    }
}