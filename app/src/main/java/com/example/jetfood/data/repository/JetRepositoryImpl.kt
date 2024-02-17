package com.example.jetfood.data.repository

import com.example.jetfood.data.remote.ApiService
import com.example.jetfood.domain.mapper.toFood
import com.example.jetfood.domain.model.Food
import com.example.jetfood.domain.repository.JetRepository
import com.example.jetfood.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JetRepositoryImpl(
    private val apiService: ApiService
) : JetRepository {
    override suspend fun getAllFoods(): Flow<Result<List<Food>>> {
        return flow {
            try {
                emit(Result.Loading)
                val response = apiService.getAllFoods()
                if (response.isSuccessful) {
                    emit(Result.Success(response.body()!!.categories.map { it.toFood() }))
                }
            } catch (e: Exception) {
                emit(Result.Failure(Throwable(e.message)))
            }
        }
    }
}