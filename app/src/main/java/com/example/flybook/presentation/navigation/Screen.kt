package com.example.flybook.presentation.navigation

sealed class Screen(
    val route: String
) {
    object Main : Screen("main")
    object Loading: Screen("loading")
    object Profile: Screen("profile")
    object Hotel:Screen("hotel")
    object Notification:Screen("notification")
}