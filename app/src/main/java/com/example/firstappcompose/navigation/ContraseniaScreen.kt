package com.example.firstappcompose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstappcompose.navigation.ui.theme.FirstAppComposeTheme

@Composable
fun ContraseniaScreen(navigateToLogin: (String?) -> Unit, navigateToSearcher: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var psswd by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "INICIAR SESION", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre de usuario...") })
        TextField(
            value = psswd,
            onValueChange = { psswd = it },
            label = { Text("Contraseña...") })
        Button(onClick = {
            if(name.equals("ronaldo",true)){
                if(psswd.equals("1234",false)){
                    navigateToSearcher()
                }else{
                    navigateToLogin("Contraseña incorrecta.")
                }
            }else{
                navigateToLogin("Usuario incorrecto")
            }
        }) {
            Text("Buscar perfil")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}