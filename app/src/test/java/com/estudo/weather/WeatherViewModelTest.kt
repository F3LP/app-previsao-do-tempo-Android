package com.estudo.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.estudo.weather.network.WeatherRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class WeatherViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val repository = mock<WeatherRepository>()
    private lateinit var viewModel: WeatherViewModel

    @Before
    fun before() {
        viewModel = WeatherViewModel(repository)
    }

    @Test
    fun withoutForecastThenFetchForecast() = runBlocking {
        viewModel.fetchForecast()
        verify(repository, times(1)).nextForecast()
    }
}
