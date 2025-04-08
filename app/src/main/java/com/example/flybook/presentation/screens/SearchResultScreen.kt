package com.example.flybook.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SearchResultsScreen(navController: NavController, from: String, to: String) {
    // Здесь вы можете добавить логику для получения и отображения результатов поиска
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Результаты поиска из $from в $to", style = MaterialTheme.typography.headlineLarge)
        // Здесь вы можете добавить список рейсов и другую информацию
    }
}