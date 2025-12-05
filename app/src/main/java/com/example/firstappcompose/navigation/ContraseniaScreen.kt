package com.example.firstappcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

@Composable
fun ContraseniaScreen(navigateToLogin: (String?) -> Unit, navigateToSearcher: (String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var psswd by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    val db = DBHelper(LocalContext.current, null)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "INICIAR SESION", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = msg, fontSize = 20.sp)
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
            if (name.isEmpty()) {
                if (psswd.isEmpty()) {
                    msg = "Escribe un nombre de usuario y una contraseña."
                } else {
                    msg = "Escribe un nombre de usuario."
                }
            } else {
                if (psswd.isEmpty()) {
                    msg = "Escribe una contraseña."
                } else {
                    val existe = db.isThereAnyone(name, psswd)
                    if(existe){
                        navigateToSearcher(name)
                    }else{
                        navigateToLogin("Nombre o contraseña incorrecta")
                    }
                }
            }
        }) {
            Text("Buscar perfil")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}