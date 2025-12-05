package com.example.firstappcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowDataBaseScreen() {
    val db = DBHelper(LocalContext.current, null)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text("ID -- NAME -- PASSWORD")
        for(user in db.getAllUsers()){
            Text("${user.id} -- ${user.name} -- ${user.password}")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}