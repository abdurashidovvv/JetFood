package com.example.jetfood.domain.mapper

import com.example.jetfood.data.remote.dto.Category
import com.example.jetfood.domain.model.Food

fun Category.toFood(): Food = Food(
    title = this.strCategory,
    image = this.strCategoryThumb,
    desc = this.strCategoryDescription
)