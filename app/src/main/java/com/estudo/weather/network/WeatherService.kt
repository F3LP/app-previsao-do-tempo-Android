package com.estudo.weather.network

import com.estudo.weather.network.model.WeatherResponse
import retrofit2.http.GET

interface WeatherService {

    @GET("weather?key=0a520401")
    suspend fun forecast(): WeatherResponse
}