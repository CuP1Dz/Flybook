package com.example.flybook.presentation.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.flybook.R
import com.example.flybook.ui.theme.LightBlue
import com.example.flybook.ui.theme.Orangebtn
import com.example.flybook.ui.theme.SuperLightGray
import com.example.flybook.ui.theme.btnBlue
import com.example.flybook.viewmodel.AuthViewModel
import com.example.flybook.viewmodel.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }


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
                        text = "Профиль")
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
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Страница входа", fontSize = 32.sp)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text(text = "Эл.почта")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(text = "Пароль")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {

            }) {

            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = {
                navController.navigate("signup")
            }) {
                Text(text = "Нет аккаунта, зарегистрировать")
            }
        }
    }
}

//@Composable
//fun SettingsSection(title: String, items: List<Pair<String, ImageVector>>) {
//    Card(
//
//        modifier = Modifier
//            .fillMaxWidth(),
//        shape = RoundedCornerShape(8.dp),
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//            Spacer(modifier = Modifier.height(16.dp))
//            items.forEach { item ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 8.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(imageVector = item.second, contentDescription = null, tint = Color.Gray)
//                    Spacer(modifier = Modifier.width(16.dp))
//                    Text(text = item.first)
//                    Spacer(modifier = Modifier.weight(1f))
//                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, tint = Color.Gray)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ProfileHeader() {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        shape = RoundedCornerShape(16.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.notification ),
//                    contentDescription = "Profile Image",
//                    modifier = Modifier.size(64.dp)
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//                Column {
//                    Text("User  Name", fontWeight = FontWeight.Bold, fontSize = 20.sp)
//                    Text("user@example.com", fontSize = 14.sp)
//                }
//            }
//        }
//    }
//}

//@Composable
//fun ProfileContent() {
//    LazyColumn {
//        items(listOf("My Posts", "Settings", "Logout")) { item ->
//            ListItem(
//                modifier = Modifier.clickable { /* Handle click */ },
//                text = { Text(item) },
//                trailing = { Icon(Icons.Filled.ArrowForward, contentDescription = null) }
//            )
//        }
//    }
//}
@Preview
@Composable
fun PreviewProfileScreen(){
    val navController = rememberNavController()
    val idProfile = null
//    ProfileScreen(navController, authViewModel = "")
}