package com.example.flybook.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.flybook.R
import com.example.flybook.ui.theme.LightBlue


@Composable
fun LoadingScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        Thread.sleep(3_000)
        navController.navigate("main")
    }
    Box(
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
        Text(
            style = TextStyle(
                fontSize = 50.sp,
                fontWeight = FontWeight.SemiBold
            ),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("Fly")
                }
                withStyle(style = SpanStyle(color = LightBlue)) {
                    append("Book")
                }
            },
            modifier = Modifier
                .align(Alignment.Center),
        )
    }
}

@Preview
@Composable
fun PreviewLoadingScreen(){
}