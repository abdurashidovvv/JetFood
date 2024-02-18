package com.example.jetfood.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetfood.domain.model.Food
import com.example.jetfood.presentation.component.ImageLoader

@Composable
fun DashBoard(data: List<Food>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(data.size) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = 5.dp
            ) {
                ImageLoader(image = data[it].image, modifier = Modifier.fillMaxWidth())
                BannerText(title =data[it].title, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
private fun BannerText(
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.3f))
            .padding(10.dp),
        text = title,
        style = MaterialTheme.typography.subtitle2.copy(
            color = Color.White,
            fontSize = 15.sp
        )
    )
}