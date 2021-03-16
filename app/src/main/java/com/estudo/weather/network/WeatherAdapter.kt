package com.estudo.weather.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estudo.weather.R
import com.estudo.weather.network.model.Forecast
import com.estudo.weather.setImageResource

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var forecast = mutableListOf<Forecast>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val forecast = forecast[position]
        holder.weekDay.text = forecast.weekday
        holder.data.text = forecast.date
        holder.min.text = holder.min.context.getString(R.string.min, forecast.min)
        holder.max.text = holder.max.context.getString(R.string.max, forecast.max)

        holder.imgWeather.setImageResource(forecast.condition)
    }

    override fun getItemCount() = forecast.size

    fun updateForecast(forecast: List<Forecast>){
        this.forecast.clear()
        this.forecast.addAll(forecast)
        notifyDataSetChanged()
    }

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val min: TextView
        val max: TextView
        val data: TextView
        val weekDay: TextView
        val imgWeather: ImageView

        init {
            min = itemView.findViewById(R.id.text_min)
            max = itemView.findViewById(R.id.text_max)
            data = itemView.findViewById(R.id.text_data)
            weekDay = itemView.findViewById(R.id.text_week_day)
            imgWeather = itemView.findViewById(R.id.img_weather_item)
        }
    }
}