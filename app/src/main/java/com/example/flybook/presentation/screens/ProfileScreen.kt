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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.flybook.viewmodel.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, /*idProfile:String?*/) {
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
                .padding(innerPadding)
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Profile picture of Name Surname",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "Name Surname", fontWeight = FontWeight.Bold)
                    Text(text = "Add your contact data", color = Color.Gray)
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, tint = Color.Gray)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Documentation", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Passport placeholder image",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "Name Surname", fontWeight = FontWeight.Bold)
                    Text(text = "+ Add your passport information", color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = btnBlue,
                ),
            ) {
                Text(text = "ALL DOCUMENTS", color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            SettingsSection(title = "Settings", items = listOf(
                "Manage my account" to Icons.Default.AccountCircle,
                "Privacy and safety" to Icons.Default.AccountCircle,
                "Registration" to Icons.Default.AccountCircle,
                "Balance" to Icons.Default.AccountCircle,
                "Links" to Icons.Default.AccountCircle,
                "Codes" to Icons.Default.AccountCircle
            ))

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "2.20.21",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun SettingsSection(title: String, items: List<Pair<String, ImageVector>>) {
    Card(

        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = item.second, contentDescription = null, tint = Color.Gray)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = item.first)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, tint = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.notification ),
                    contentDescription = "Profile Image",
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("User  Name", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("user@example.com", fontSize = 14.sp)
                }
            }
        }
    }
}

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
    ProfileScreen(navController)
}