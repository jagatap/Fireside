package com.a.fireside.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("lat")
    val lat: String,

    @SerializedName("lon")
    val lon: String,

    @SerializedName("timezone")
    val timezone: String,

    @SerializedName("timezone_offset")
    val timezone_offset: String,

    @SerializedName("hourly")
    val hourly: List<HourlyModel>

    )