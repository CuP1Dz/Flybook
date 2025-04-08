package com.example.flybook.presentation.screens

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import com.example.flybook.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flybook.ui.theme.LightBlue
import com.example.flybook.ui.theme.Orangebtn
import com.example.flybook.ui.theme.btnBlue
import com.example.flybook.viewmodel.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    var cardNumber by remember { mutableStateOf("4255 1233 4144 9321") }
    var expirationMonth by remember { mutableStateOf("09") }
    var expirationYear by remember { mutableStateOf("20") }
    var cvv by remember { mutableStateOf("922") }
    var cardHolderName by remember { mutableStateOf("GAROLD PAIN") }

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
                        text = "Оплата")
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
                    .background(Color(0xFFF5F5F5))
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                PaymentOption(
                    icon = R.drawable.credit_card,
                    title = "Credit card",
                    description = "Pay with a credit card",
                    isSelected = true
                )


                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = cardNumber,
                    onValueChange = { cardNumber = it },
                    label = { Text("Card number") },
                    modifier = Modifier.fillMaxWidth(),
//                    trailingIcon = {
//                        Image(
//                            painter = painterResource(id = R.drawable.credit_card),
//                            contentDescription = "MasterCard logo",
//                            modifier = Modifier.size(40.dp)
//                        )
//                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = expirationMonth,
                        onValueChange = { expirationMonth = it },
                        label = { Text("Expiration date") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = expirationYear,
                        onValueChange = { expirationYear = it },
                        label = { Text("") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = cvv,
                        onValueChange = { cvv = it },
                        label = { Text("CVV/CVC") },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = cardHolderName,
                    onValueChange = { cardHolderName = it },
                    label = { Text("Card holder name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {navController.navigate("notification")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = btnBlue,
                    ),
                ) {
                    Text("Confirm payment", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
}

@Composable
fun PaymentOption(icon: Int, title: String, description: String, isSelected: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .size(35.dp),
                painter = painterResource(id = icon),
                contentDescription = title, tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold)
                Text(description, color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}

@Composable
@Preview
fun PreviewPayment(){
    val navController = rememberNavController()
    PaymentScreen(navController)
}