package com.example.graphviewer.net

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL =
    "https://raw.githubusercontent.com/Apocalixs-Nick/data-chart.json/main/"

var gsonPie: Gson = GsonBuilder()
    .setLenient()
    .create()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gsonPie))
        .build()

interface PieApiService {
    /**
     * Returns a [List] of [PieInfo] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "year" endpoint will be requested with the GET
     * HTTP method
     */
    @Headers("Content-Type: application/json")
    @GET("data-chart.json")
    suspend fun getPieInfo(): List<PieInfo>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object PieApi {
    val retrofitService: PieApiService by lazy { retrofit.create(PieApiService::class.java) }
}