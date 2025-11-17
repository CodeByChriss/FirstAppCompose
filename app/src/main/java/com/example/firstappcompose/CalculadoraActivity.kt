package com.example.firstappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text("Calculardora longitud circulo",fontSize = 24.sp, modifier = Modifier.padding(top = 64.dp))
                OutlinedTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { "Nombre" },
                    singleLine = true,
                    placeholder = { "Introduce el radio" },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // para que introduzca solo números
                    modifier = Modifier.fillMaxWidth().padding(12.dp)
                )
                Text("La longitud de tu circulo es: $longitud",modifier = Modifier.padding(12.dp))
                Button(onClick = {
                    var lon = 2 * 3.14 * inputText.toDouble()
                    longitud = lon.toString()
                }) {
                    Text("calcular longitud".uppercase())
                    Modifier.fillMaxWidth().padding(12.dp)
                }
            }
        }
    }
}