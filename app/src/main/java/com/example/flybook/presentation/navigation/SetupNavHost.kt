package com.example.flybook.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flybook.presentation.screens.HotelScreen
import com.example.flybook.presentation.screens.LoadingScreen
import com.example.flybook.presentation.screens.MainScreen
import com.example.flybook.presentation.screens.NotificationScreen
import com.example.flybook.presentation.screens.PaymentScreen
import com.example.flybook.presentation.screens.ProfileScreen
import com.example.flybook.presentation.screens.SearchResultsScreen
import com.example.flybook.presentation.screens.SignupPage
import com.example.flybook.viewmodel.AuthViewModel

@Composable
fun NavigationFlybook(authViewModel: AuthViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "loading") {

        composable(route = "loading"){
            LoadingScreen(navController)
        }

        composable(route = "main"){
            MainScreen(navController)
        }

        composable(route = "notification"){
            NotificationScreen(navController)
        }

        composable(route = "hotel"){
            HotelScreen(navController)
        }

        composable(route = "payment"){
            PaymentScreen(navController)
        }

        composable(route = "profile"){
            ProfileScreen(navController, authViewModel)
//            navBackProfileEntry ->
//            ProfileScreen(navController/*,navBackProfileEntry.arguments?.getString("id")*/)
        }
        composable(route = "search_screen/{${"from"}}/{${"to"}}"){
            aaa -> SearchResultsScreen(navController, from = aaa.arguments?.getString("from"),
            to = aaa.arguments?.getString("to"))
        }
        composable(route = "signup"){
            SignupPage(navController, authViewModel)
        }
    }
}

//profile/{${"id"}}