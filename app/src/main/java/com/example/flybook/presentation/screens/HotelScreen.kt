package com.example.flybook.presentation.screens

import Dropdown
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flybook.R
import com.example.flybook.ui.theme.LightBlue
import com.example.flybook.ui.theme.Orangebtn
import com.example.flybook.viewmodel.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelScreen(navController: NavController){
    var Arrival by remember{ mutableStateOf("") }
    var Departure by remember { mutableStateOf("") }
    var Country by remember { mutableStateOf("") }

    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Scaffold(
        modifier = Modifier
            .background(Color.LightGray),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {  innerPadding -> Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.intro),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White)) {
                            append("Fly")
                        }
                        withStyle(style = SpanStyle(color = LightBlue)) {
                            append("Book")
                        }
                    },
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(60.dp))
                TextField(
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                    ),
                    value = Country,
                    onValueChange = { Country = it },
                    singleLine = true,
                    label = { Text("Country") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(15.dp))
                TextField(
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,
                    ),
                    value = Arrival,
                    onValueChange = { Arrival = it },
                    singleLine = true,
                    label = { Text("Arrival") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(0.dp))
                TextField(
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                    ),
                    value = Departure,
                    onValueChange = { Departure = it },
                    singleLine = true,
                    label = { Text("Departure") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Dropdown()
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),

                    onClick = { navController.navigate("main") },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Orangebtn,
                    ),
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Text("Найти отель")
                }
            }
        }
    }
    }
}

@Composable
@Preview
fun PreviewHotelScreen(){
    val navController = rememberNavController()
    HotelScreen(navController)
}