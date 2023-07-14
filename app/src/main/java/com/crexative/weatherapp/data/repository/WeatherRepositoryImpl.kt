package com.crexative.weatherapp.data.repository

import com.crexative.weatherapp.data.mappers.toWeatherInfo
import com.crexative.weatherapp.data.remote.WeatherApi
import com.crexative.weatherapp.domain.repository.WeatherRepository
import com.crexative.weatherapp.domain.util.Resource
import com.crexative.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            val weatherDto = api.getWeather(lat, long)
            val weatherInfo = weatherDto.toWeatherInfo()
            Resource.Success(weatherInfo)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An error occurred")
        }
    }

}