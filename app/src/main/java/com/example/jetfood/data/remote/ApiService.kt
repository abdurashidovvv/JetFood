package com.example.jetfood.data.remote

import com.example.jetfood.data.remote.dto.FoodDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/json/v1/1/categories.php")
    suspend fun getAllFoods(): Response<FoodDTO>
}