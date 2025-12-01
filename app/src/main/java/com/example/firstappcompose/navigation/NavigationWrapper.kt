package com.example.firstappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    var nombreDelUsuario by remember { mutableStateOf("") }

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen { navController.navigate(Searcher) }
        }

        composable<Searcher> {
            SearcherScreen { userInputName ->
                nombreDelUsuario = userInputName
                navController.navigate(Profile)
            }
        }

        composable<Profile> {
            ProfileScreen(nombreDelUsuario) { navController.navigate(Detail) }
        }

        composable<Detail> {
            DetailScreen(name = nombreDelUsuario)
        }
    }
}