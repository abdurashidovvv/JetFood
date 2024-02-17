package com.example.jetfood.domain.repository

import com.example.jetfood.domain.model.Food
import com.example.jetfood.utils.Result
import kotlinx.coroutines.flow.Flow

interface JetRepository {
    suspend fun getAllFoods(): Flow<Result<List<Food>>>
}