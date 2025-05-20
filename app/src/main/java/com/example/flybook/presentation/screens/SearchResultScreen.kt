package com.example.flybook.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flybook.R
import com.example.flybook.viewmodel.BottomNavigationBar

data class BookingData(
    val imageUrl: String,
    val title: String,
    val subtitle: String,
    val pricePerNight: String,
    val rating: Float,
    val reviewsCount: Int,
    val totalPrice: String,
    val totalDays: Int
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultsScreen(navController: NavController, from: String?, to: String?) {
    val bookings = listOf(
        BookingData(
            imageUrl = "https://storage.googleapis.com/a1aa/image/318e13fc-4089-4829-0c7c-a72575b76a1e.jpg",
            title = "Canada",
            subtitle = "Super Best Ghost",
            pricePerNight = "\$59 / night",
            rating = 5f,
            reviewsCount = 84,
            totalPrice = "356 \$",
            totalDays = 6
        ),
        BookingData(
            imageUrl = "https://storage.googleapis.com/a1aa/image/774a976b-437f-4cfc-1f40-de651dcd8e44.jpg",
            title = "Moscow",
            subtitle = "Lacola de San",
            pricePerNight = "\$103 / night",
            rating = 4.5f,
            reviewsCount = 110,
            totalPrice = "1236 \$",
            totalDays = 12
        ),
        BookingData(
            imageUrl = "https://storage.googleapis.com/a1aa/image/98ac44da-573f-4207-29ac-163bafc2c096.jpg",
            title = "",
            subtitle = "Mexico",
            pricePerNight = "\$123 / night",
            rating = 5f,
            reviewsCount = 120,
            totalPrice = "123 \$",
            totalDays = 10
        )
    )
    Scaffold(
        modifier = Modifier
            .background(color = Color.LightGray),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 12.dp)
                    ) {
//                        IconButton(
//                            onClick = {},
//                            modifier = Modifier.size(32.dp)
//                        ) {
//                            Icon(
//                                imageVector = Icons.Filled.ArrowBack,
//                                contentDescription = "Back",
//                                tint = Color.Black
//                            )
//                        }

                    }
                    Text(modifier = Modifier,
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold
                        ),
                        text = "Результаты")
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center, // Центрируем по вертикали
            horizontalAlignment = Alignment.CenterHorizontally // Центрируем по горизонтали
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF0F0F0)),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                    textAlign = TextAlign.Center,
                    text = "Результаты поиска $from в $to",
                    style = MaterialTheme.typography.headlineSmall

                )
                // Здесь вы можете добавить список рейсов и другую информацию
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .padding(bottom = 0.dp, top = 50.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(bookings) { booking -> // Используем bookings для итерации
                        if (booking.title.contains(to.toString(),true))
                            BookingCard(
                            imageUrl = booking.imageUrl,
                            title = booking.title,
                            subtitle = booking.subtitle,
                            pricePerNight = booking.pricePerNight,
                            rating = booking.rating,
                            reviewsCount = booking.reviewsCount,
                            totalPrice = booking.totalPrice,
                            totalDays = booking.totalDays
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                ) {
                }
            }
        }
    }
}


@Composable
fun BookingCard(
    imageUrl: String,
    title: String,
    subtitle: String,
    pricePerNight: String,
    rating: Float,
    reviewsCount: Int,
    totalPrice: String,
    totalDays: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Using local drawable as placeholder, replace with image loading if needed
        Image(
            painter = painterResource(R.drawable.bitmap),
            contentDescription = "$title image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(192.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )
        // Heart icon top right
        IconButton(
            onClick = { /* TODO: favorite action */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite",
                tint = Color.White
            )
        }
        // Bottom left text
        if (title.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = pricePerNight,
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    repeat(4) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.star_on),
                            contentDescription = "Star",
                            tint = Color(0xFFFFB400),
                            modifier = Modifier.size(12.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = android.R.drawable.star_off),
                        contentDescription = "Half Star",
                        tint = Color(0xFFFFB400),
                        modifier = Modifier.size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "($reviewsCount) reviews",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
        // Bottom right price box
        if (totalPrice.isNotEmpty()) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
                    .widthIn(min = 72.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = totalPrice,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "for $totalDays days",
                        fontWeight = FontWeight.Normal,
                        fontSize = 9.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 2.dp)
                    )
//                    Icon(
//                        imageVector = Icons.Filled.ChevronRight,
//                        contentDescription = "Next",
//                        tint = Color.Black,
//                        modifier = Modifier.size(14.dp).padding(top = 4.dp)
//                    )
                }
            }
        }
    }
}


//@Composable
//fun BookingScreen(
//    onBackClick: () -> Unit = {}
//) {
//    val bookings = listOf(
//        BookingData(
//            imageUrl = "https://storage.googleapis.com/a1aa/image/318e13fc-4089-4829-0c7c-a72575b76a1e.jpg",
//            title = "Ghost Game",
//            subtitle = "Super Best Ghost",
//            pricePerNight = "$59 / night",
//            rating = 4.5f,
//            reviewsCount = 84,
//            totalPrice = "356 $",
//            totalDays = 6
//        ),
//        BookingData(
//            imageUrl = "https://storage.googleapis.com/a1aa/image/774a976b-437f-4cfc-1f40-de651dcd8e44.jpg",
//            title = "Paroma tiara",
//            subtitle = "Lacola de San",
//            pricePerNight = "$103 / night",
//            rating = 4f,
//            reviewsCount = 110,
//            totalPrice = "1236 $",
//            totalDays = 12
//        ),
//        BookingData(
//            imageUrl = "https://storage.googleapis.com/a1aa/image/98ac44da-573f-4207-29ac-163bafc2c096.jpg",
//            title = "",
//            subtitle = "",
//            pricePerNight = "",
//            rating = 0f,
//            reviewsCount = 0,
//            totalPrice = "",
//            totalDays = 0
//        )
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF0F0F0))
//    ) {
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(bottom = 72.dp, top = 56.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            contentPadding = PaddingValues(horizontal = 16.dp)
//        ) {
////            items(bookings) { booking ->
////                BookingCard(
////                    imageUrl = booking.imageUrl,
////                    title = booking.title,
////                    subtitle = booking.subtitle,
////                    pricePerNight = booking.pricePerNight,
////                    rating = booking.rating,
////                    reviewsCount = booking.reviewsCount,
////                    totalPrice = booking.totalPrice,
////                    totalDays = booking.totalDays
////                )
////            }
//        }
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .padding(start = 16.dp, top = 12.dp)
//        ) {
//            IconButton(
//                onClick = onBackClick,
//                modifier = Modifier.size(32.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.ArrowBack,
//                    contentDescription = "Back",
//                    tint = Color.Black
//                )
//            }
//        }
//        Box(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//        ) {
//        }
//    }
//}

@Preview
@Composable
fun PreviewSearchResultScreen(){
    val navController = rememberNavController()
    val from = "Dasd"
    val to = "dasd"
    SearchResultsScreen(navController, from = "Dasd", to = "asdd")
}

// Здесь вы можете добавить логику для получения и отображения результатов поиска
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(text = "Результаты поиска из $from в $to", style = MaterialTheme.typography.headlineLarge)
//        // Здесь вы можете добавить список рейсов и другую информацию
//    }