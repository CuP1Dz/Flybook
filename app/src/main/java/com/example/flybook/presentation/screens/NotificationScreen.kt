package com.example.flybook.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flybook.R
import com.example.flybook.ui.theme.SuperLightGray
import com.example.flybook.viewmodel.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .background(Color.LightGray),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(modifier = Modifier
                        .padding(6.dp),
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        ,
                        text = "Уведомления")
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = SuperLightGray)
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "No Notifications",
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = "There’s nothing here",
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}



//    LazyColumn(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.1f)
//                .background(Color.White),
//        ){
//            Text(
//                text = "Уведомление",
//                modifier = Modifier
//                    .padding(18.dp)
//                    .align(Alignment.CenterStart),
//                color = Color.Black,
//                fontWeight = FontWeight.ExtraBold,
//                style = TextStyle(
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.9f)
//                .background(Color.LightGray)
//        ){
//            Image(
//                painter = painterResource(id = R.drawable.notification),
//                contentDescription = null,
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            Text(text = "Здесь ничего нет")
//        }
//    }
//}

//
@Preview
@Composable
fun PreviewNotificationScreen(){

}