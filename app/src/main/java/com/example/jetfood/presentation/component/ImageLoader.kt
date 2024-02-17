package com.example.jetfood.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ImageLoader(
    modifier: Modifier = Modifier,
    image: String
) {
    val painter = rememberCoilPainter(request = image)
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}