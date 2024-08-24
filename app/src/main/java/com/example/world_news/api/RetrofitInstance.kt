package com.example.world_news.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private const val BASE_URL = "https://newsapi.org/"

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val api: NewsAPI by lazy{
            retrofit.create(NewsAPI::class.java)
        }

        fun <T> createService(serviceClass: Class<T>): T {
            return retrofit.create(serviceClass)
        }
    }
}
