package com.craigbaumer.septa.data

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


object SeptaClient {

    private const val BASE_URL = "https://www3.septa.org/api/"

    private val okHttpClient = OkHttpClient.Builder().build()

    private val json = Json {
        ignoreUnknownKeys = true // Good practice for API evolution
        prettyPrint = false // Set to true for easier debugging of JSON output
    }

    val instance: TrainService by lazy {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
                .build()
        retrofit.create(TrainService::class.java)
    }
}
