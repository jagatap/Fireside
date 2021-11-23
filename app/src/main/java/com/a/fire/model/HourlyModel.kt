package com.a.fireside.model

import com.google.gson.annotations.SerializedName

data class HourlyModel (
    @SerializedName("dt")
    val dt: String,

@SerializedName("temp")
val temp: String,

@SerializedName("feels_like")
val feels_like: String,

@SerializedName("pressure")
val pressure: String,

@SerializedName("humidity")
val humidity: String,


@SerializedName("dew_point")
val dew_point: String,

@SerializedName("uvi")
val uvi: String,

    @SerializedName("clouds")
    val clouds: String,

    @SerializedName("visibility")
    val visibility: String,

    @SerializedName("wind_speed")
    val wind_speed: String,

    @SerializedName("wind_deg")
    val wind_deg: String,

    @SerializedName("wind_gust")
    val wind_gust: String,


    @SerializedName("weather")
    val weather: List<Weather>,

@SerializedName("pop")
val pop: String,

@SerializedName("rain")
val rain:Rain

)