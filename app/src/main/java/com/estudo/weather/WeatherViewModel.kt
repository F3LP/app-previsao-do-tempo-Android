package com.estudo.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estudo.weather.network.WeatherRepository
import com.estudo.weather.network.model.Results
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    private val _result = MutableLiveData<Results>()
    val result: LiveData<Results>
        get() = _result


    fun fetchForecast() {
        if (_result.value == null) {
            viewModelScope.launch {
                repository.nextForecast().collect {
                    _result.postValue(it.results)
                }
            }

        }
    }

}