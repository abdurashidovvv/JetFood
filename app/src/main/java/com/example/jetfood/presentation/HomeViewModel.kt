package com.example.jetfood.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetfood.domain.model.Food
import com.example.jetfood.domain.repository.JetRepository
import com.example.jetfood.utils.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: JetRepository
):ViewModel() {
    private val _result : MutableStateFlow<Result<List<Food>>> = MutableStateFlow(Result.Loading)
    val result : StateFlow<Result<List<Food>>> = _result.asStateFlow()

    init {
        getAllFood()
    }

    fun getAllFood() {
        viewModelScope.launch {
            repository.getAllFoods().collectLatest {
                delay(1000)
                _result.value = it
            }
        }
    }
}