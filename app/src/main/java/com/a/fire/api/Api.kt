package com.a.fireside.api

import com.a.fireside.model.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface
Api {
    @GET("data/2.5/onecall")
    fun searchVolumes(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("exclude") exclude: String?,
        @Query("appid") appid: String?
    ): Call<WeatherResponse?>?

}