package com.example.firstappcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(errorMsg: String?, navigateToSearcher: () -> Unit, navigateToSignUp: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Login screen", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = (if (errorMsg?.isNotBlank() == true) errorMsg else ""),
            fontSize = 18.sp,
            color = Color(red = 255, green = 0, blue = 0)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = navigateToSearcher) {
            Text("iniciar sesion")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = navigateToSignUp) {
            Text("registrarse")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}