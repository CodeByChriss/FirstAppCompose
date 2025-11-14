package com.example.firstappcompose

import android.content.Intent
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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun app() {
        var name by remember { mutableStateOf("") }
        var txtName by remember { mutableStateOf("") }

        var context = LocalContext.current

        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Image(painterResource(R.drawable.gatofeo), "gato muy guapo", Modifier.fillMaxWidth())
                OutlinedTextField(
                    value = txtName,
                    onValueChange = { txtName = it },
                    label = { "Nombre" },
                    singleLine = true
                )
                Text("hola mundo", Modifier.padding(12.dp))
                Text("hola clase", fontSize = 18.sp, modifier = Modifier.padding(12.dp))

                Text(text="hola $name")

                Button( onClick = {
                    name = txtName
                }){
                    Text("mostrar")
                }

                Button( onClick = {
                    val intent = Intent(context, CalculadoraActivity::class.java)
                    context.startActivity(intent)
                }){
                    Text("ir a la calculadora")
                }
            }

            item {
                LazyRow() {
                    item {
                        Text("soy roooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooowroooooooooooow")
                    }
                }
            }
        }
    }
}