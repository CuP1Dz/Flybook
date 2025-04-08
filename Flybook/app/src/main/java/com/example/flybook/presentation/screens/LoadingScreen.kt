package com.example.flybook.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flybook.R

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.intro),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "FlyBook",
            modifier = Modifier.align(Alignment.Center).padding(20.dp)
        )
        Text(
            text = "Поиск дешевых авиабилетов",
            modifier = Modifier
                .align(Alignment.Center),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewLoadingScreen(){
    LoadingScreen()
}