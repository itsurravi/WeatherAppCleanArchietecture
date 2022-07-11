package com.ravisharma.weatherapp.domain.repository

import com.ravisharma.weatherapp.domain.util.Resource
import com.ravisharma.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}