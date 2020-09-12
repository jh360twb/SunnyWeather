package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @Anthor:Tian
 * @Date:2020/9/12
 * @Description:
 */
data class RealtimeResponse(val status: String, val result: Result) {
    data class Result(val realtime: Realtime)
    data class Realtime(
        val temperature: Float, val skycon: String,
        @SerializedName("air_quality") val airQuality: AirQuality
    )

    data class AirQuality(val aqi: AQI)
    data class AQI(val chn: Float)
}