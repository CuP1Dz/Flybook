package com.example.flybook.viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(navController: NavController) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 120.dp,
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                    ),
                    spotColor = Color.Black,
                    ambientColor = Color.Black
                ),
            contentColor = contentColorFor(backgroundColor = Color.Black),
            containerColor = Color.White,



        ) {
            NavigationBarItem(
                selected =false,
                onClick = { navController.navigate("main")},
                icon = {
                    Image(
                imageVector = Icons.Filled.Home,
                contentDescription = ""
            ) })
            NavigationBarItem(
                selected =false,
                onClick = { navController.navigate("hotel")},
                icon = {
                    Image(
                        imageVector = Icons.Filled.Search,
                        contentDescription = ""
                    )
                })
            NavigationBarItem(selected = false,
                onClick = { navController.navigate("notification")},
                icon = {
                    Image(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = ""
                    )
                })
            NavigationBarItem(selected = false,
                onClick = { navController.navigate("profile")},
                icon = {
                    Image(
                        imageVector = Icons.Filled.Person,
                        contentDescription = ""
                    )
                })
        }
    }

@Preview
@Composable
fun Previewnavbar(){
    val navController = rememberNavController()
    BottomNavigationBar(navController)
}