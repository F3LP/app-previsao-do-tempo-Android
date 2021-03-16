package com.estudo.weather

import android.widget.ImageView

fun ImageView.setImageResource(condition: String) {
    val drawableResource = when (condition) {
        "storm" -> R.drawable.ic_weather_storm
        "snow" -> R.drawable.ic_snow
        "hail" -> R.drawable.ic_hail
        "rain" -> R.drawable.ic_rain
        "fog" -> R.drawable.ic_fog
        "clear_day" -> R.drawable.ic_clear_day
        "clear_night" -> R.drawable.ic_clear_night
        "cloud" -> R.drawable.ic_cloud
        "cloudly_day" -> R.drawable.ic_cloudly_day
        "cloudly_night" -> R.drawable.ic_cloudly_night
        else -> R.drawable.ic_not_found
    }

    setImageResource(drawableResource)
}