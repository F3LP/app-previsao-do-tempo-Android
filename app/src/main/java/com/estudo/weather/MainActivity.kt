package com.estudo.weather

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudo.weather.databinding.ActivityMainBinding
import com.estudo.weather.network.WeatherAdapter
import com.estudo.weather.network.WeatherRepository


class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModels {
        ViewModelFactory(
            WeatherRepository(),
            this
        )
    }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchForecast()

        binding.recyclerListWeather.layoutManager = LinearLayoutManager(this)
        binding.recyclerListWeather.adapter = WeatherAdapter()

        viewModel.result.observe(this, { results ->
            binding.textTemperaturaAtual.text = "${results?.temp}°C"
            binding.textCidade.text = results?.city
            binding.textData.text = results?.date
            binding.imgWeather.setImageResource(results?.conditionSlug.toString())

            results?.forecast?.let {
                (binding.recyclerListWeather.adapter as WeatherAdapter).updateForecast(
                    it
                )
            }
        })
    }

}