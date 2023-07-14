package com.crexative.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?&hourly=temperature_2m,relativehumidity_2m,windspeed_10m,pressure_msl,weathercode")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ) : WeatherDto
}