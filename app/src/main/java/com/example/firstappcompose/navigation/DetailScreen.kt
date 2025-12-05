package com.example.firstappcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailScreen(name: String, navigateToLogin: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(56.dp))
        Button(onClick = navigateToLogin) {
            Text("Volver al Login")
        }
        Spacer(modifier = Modifier.height(56.dp))
        Text(text = "DETALLES COMPLETOS", fontSize = 24.sp)
        Text(text = "Usuario: $name", fontSize = 32.sp)
        LazyColumn( modifier = Modifier.padding(top = 20.dp)) {
            item {
                AsyncImage(
                    model = "https://i.pinimg.com/originals/76/c1/cf/76c1cf2ac12add646367c1d9fbcbe6f6.jpg",
                    contentDescription = "Imagen de prueba",
                    modifier = Modifier.width(256.dp).height(256.dp)
                )
                AsyncImage(
                    model = "https://media.gq.com.mx/photos/66774829c12a54a09ddc8b23/1:1/w_2012,h_2012,c_limit/Cristiano%20Ronaldo.jpg",
                    contentDescription = "Imagen de prueba",
                    modifier = Modifier.width(256.dp).height(256.dp)
                )
                AsyncImage(
                    model = "https://m.media-amazon.com/images/I/71srpkWonkL.jpg",
                    contentDescription = "Imagen de prueba",
                    modifier = Modifier.width(256.dp).height(256.dp)
                )
                AsyncImage(
                    model = "https://i.pinimg.com/1200x/71/88/ee/7188ee184808c26abbf876b60e86af6b.jpg",
                    contentDescription = "Imagen de prueba",
                    modifier = Modifier.width(256.dp).height(256.dp)
                )
                AsyncImage(
                    model = "https://www.lavanguardia.com/files/article_main_microformat/uploads/2021/08/25/61262f9363fbf.jpeg",
                    contentDescription = "Imagen de prueba",
                    modifier = Modifier.width(256.dp).height(256.dp)
                )
            }
        }
    }
}