package com.ravisharma.weatherapp.data.repository

import com.ravisharma.weatherapp.data.mappers.toWeatherInfo
import com.ravisharma.weatherapp.data.remote.WeatherApi
import com.ravisharma.weatherapp.domain.repository.WeatherRepository
import com.ravisharma.weatherapp.domain.util.Resource
import com.ravisharma.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat, long).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An Unknown error occurred.")
        }
    }
}