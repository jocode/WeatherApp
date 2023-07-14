package com.crexative.weatherapp.domain.repository

import com.crexative.weatherapp.domain.util.Resource
import com.crexative.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}