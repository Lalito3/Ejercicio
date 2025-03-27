package com.example.ejercicio.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

//45:20
private const val BASE_URL = "https://randomfox.ca/"

private val retrofit= Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface EjercicioApiService{
    @GET("floof/")
    suspend fun getPhotos():String
}

object EjercicioApi{
    val retrofitService: EjercicioApiService by lazy {
        retrofit.create(EjercicioApiService::class.java)
    }
}