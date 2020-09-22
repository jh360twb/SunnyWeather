package com.example.sunnyweather.logic.network

import android.telecom.Call
import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.DailyResponse
import com.example.sunnyweather.logic.model.RealtimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Anthor:Tian
 * @Date:2020/9/12
 * @Description:请求天气数据
 */
interface WeatherService {
    //返回的是一个Call
    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): retrofit2.Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): retrofit2.Call<DailyResponse>
}