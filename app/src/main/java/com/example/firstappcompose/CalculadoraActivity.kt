package com.example.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstappcompose.ui.theme.FirstAppComposeTheme

class CalculadoraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun app() {
    var inputText by remember { mutableStateOf("") }
    var longitud by remember { mutableStateOf("0.0") }

    LazyColumn {
        item {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { "Nombre" },
                singleLine = true,
                placeholder = { "Introduce el radio" },
                modifier = Modifier.fillMaxWidth()
            )
            Text("La longitud de tu circulo es: $longitud")
            Button(onClick = {
                var lon = 2 * 3.14 * inputText.toDouble()
                longitud = lon.toString()
            }){
                Text("calcular longitud")
                Modifier.fillMaxWidth()
            }
        }
    }
}