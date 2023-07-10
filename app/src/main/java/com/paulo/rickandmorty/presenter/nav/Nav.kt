package com.paulo.rickandmorty.presenter.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.paulo.rickandmorty.presenter.detail.DetailView
import com.paulo.rickandmorty.presenter.favorite.FavoriteView
import com.paulo.rickandmorty.presenter.main.HomeScreen
import com.paulo.rickandmorty.presenter.search.SearchView

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
    object Search : Screen("search")
    object Favorite : Screen("favorite")

}

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navController,
            )
        }
        composable(route = "${Screen.Detail.route}/{id}") {
            DetailView(
                navController = navController,
            )

        }
        composable(route = Screen.Favorite.route) {
            FavoriteView(
                navController = navController,
            )
        }
        composable(route = Screen.Search.route) {
            SearchView(
                navController = navController,
            )
        }
    }
}