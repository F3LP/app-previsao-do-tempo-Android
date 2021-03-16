package com.estudo.weather.network

import android.util.Log
import com.estudo.weather.network.model.WeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    suspend fun nextForecast(): Flow<WeatherResponse> {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.hgbrasil.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: WeatherService = retrofit.create(WeatherService::class.java)
        var response: WeatherResponse? = null
        try {
            response = service.forecast()

        } catch (e: Exception) {
            Log.e("Error", "${e.message}")
        }
        return flow {
            if (response != null) {
                emit(response)
            }
        }
    }
}