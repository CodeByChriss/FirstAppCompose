package com.example.firstappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login(null)) {
        composable<Login> { backStackEntry ->
            val login: Login = backStackEntry.toRoute()
            LoginScreen(login.errorMsg) { navController.navigate(Contrasenia) }
        }

        composable<Contrasenia> {
            ContraseniaScreen(
                { errorMsg ->
                    navController.navigate(Login(errorMsg)) {
                        popUpTo(0) { // borramos toda la pila
                            inclusive = true
                        }
                    }
                },
                {
                    navController.navigate(
                        Searcher
                    )
                })
        }

        composable<Searcher> {
            SearcherScreen { name ->
                navController.navigate(Profile(name))
            }
        }

        composable<Profile> { backStackEntry ->
            val profile: Profile = backStackEntry.toRoute()
            ProfileScreen(profile.name) { name -> navController.navigate(Detail(name)) }
        }

        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(detail.name) { navController.navigate(Login) }
        }
    }
}