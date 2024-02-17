package com.example.jetfood.koin

import com.example.jetfood.data.remote.ApiService
import com.example.jetfood.data.repository.JetRepositoryImpl
import com.example.jetfood.domain.repository.JetRepository
import com.example.jetfood.presentation.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val myModule = module {

    single {
        OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    single<ApiService> {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

    factory<JetRepository> { JetRepositoryImpl(get()) }

    viewModel { HomeViewModel(get()) }

}