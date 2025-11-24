package com.example.firstappcompose.navigation

import android.app.FragmentManager
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen { navController.navigate(Searcher) }
        }

        composable<Searcher> {
            SearcherScreen { name -> navController.navigate() }
        }

        composable<Profile> { backStackEntry ->
            val searcher:Searcher = backStackEntry.toRoute()
            ProfileScreen { navController.navigate(Detail(name = name)) }
        }

        composable<Detail> {
            DetailScreen()
        }
    }
}