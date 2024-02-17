package com.example.jetfood.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.jetfood.R
import com.example.jetfood.presentation.component.ShowError
import com.example.jetfood.presentation.component.ShowLoading
import com.example.jetfood.utils.Result

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val result by viewModel.result.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "JetFood",
                        fontFamily = FontFamily(
                            fonts = listOf(
                                Font(R.font.nunito_bold)
                            )
                        )
                    )
                },
                backgroundColor = Color.White,
                elevation = 5.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (val res = result) {
                is Result.Failure -> {
                    ShowError(message = res.error.message ?: "Error") {
                        viewModel.getAllFood()
                    }
                }

                Result.Loading -> {
                    ShowLoading()
                }

                is Result.Success -> {

                }
            }
        }
    }
}