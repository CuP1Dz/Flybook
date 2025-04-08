import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flybook.R

@Composable
fun CityCard(city: String, image: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
//        elevation = 2.dp,
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Устанавливаем белый цвет
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            }
            Box(){
                Text(
                    text = city,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(){
                Icon(Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "right_arrow")
            }
        }
    }
}

@Composable
@Preview
fun PreviewCityCard(){
    CityCard(city = "San Francisco", image = R.drawable.san_francisco)
}