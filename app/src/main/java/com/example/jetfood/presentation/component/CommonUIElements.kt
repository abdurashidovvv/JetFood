package com.example.jetfood.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ShowVerticalDivider() {
    TabRowDefaults.Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = Color.LightGray.copy(alpha = .2f)
    )
}

@Composable
fun ShowError(message: String, onRetry: () -> Unit) {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = message,
            textAlign = TextAlign.Center,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onRetry,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Text(text = "Retry")
        }
    }
}