package com.example.flybook.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.navigation.compose.rememberNavController
import com.example.flybook.Flyghts
import com.example.flybook.R
import com.example.flybook.flyght
import com.example.flybook.ui.theme.LightBlue
import com.example.flybook.ui.theme.SuperLightGray
import com.example.flybook.viewmodel.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navController: NavController) {
    val BackgroundColor = Color(0xffededed)
    Scaffold(
        containerColor = BackgroundColor,
        modifier = Modifier
            .background(color = Color.LightGray),
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
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            NotificationItem(
                fromTo = "LED • TLL",
                route = "St. Petersburg – Tallinn",
                price = "452 USD",
                datePassenger = "20 Aug - 4 Sep • 1 passenger"
            )

            Spacer(modifier = Modifier.height(24.dp))

            NotificationItem(
                fromTo = "NY • LON",
                route = "New York – London",
                price = "1832 USD",
                datePassenger = "29 Aug - 9 Sep • 1 passenger"
            )
        }
    }
}

@Composable
fun NotificationItem(
    fromTo: String,
    route: String,
    price: String,
    datePassenger: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = fromTo,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.Gray,
            letterSpacing = 1.5.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = route,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.LightGray,
                disabledContentColor = Color.LightGray,
                disabledContainerColor = Color.LightGray
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(LightBlue, RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = "Best price",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = price,
                    color = LightBlue,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = datePassenger,
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                HorizontalDivider(thickness = 1.dp, color = Color.Gray)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconTextButton(
                        icon = Icons.Default.Delete,
                        text = "Отмена",
                        tint = Color.Gray,
                        onClick = { /* TODO */ }
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(20.dp)
                            .width(1.dp)
                    )
                    IconTextButton(
                        icon = Icons.Default.Delete,
                        text = "Delete",
                        tint = Color.Gray,
                        onClick = { /* TODO */ }
                    )
                }
            }
        }
    }
}

@Composable
fun IconTextButton(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, tint: Color, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .clickable { onClick() }
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = text, tint = tint, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = text, color = tint, fontSize = 14.sp)
    }
}

// delete
// Flyghts.flyght_name.removeAt(0)

// var bool: Bool =true
// Объект.массив.удалить
//  bool != bool

// if (Flyghts.flyght_name[0] == true)

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
    val navController = rememberNavController()
    NotificationScreen(navController)
}