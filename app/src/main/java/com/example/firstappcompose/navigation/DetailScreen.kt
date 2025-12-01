package com.example.firstappcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(name: String, navigateToLogin: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "DETALLES COMPLETOS", fontSize = 24.sp)
        Text(text = "Usuario: $name", fontSize = 32.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = navigateToLogin) {
            Text("Volver al Login")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}