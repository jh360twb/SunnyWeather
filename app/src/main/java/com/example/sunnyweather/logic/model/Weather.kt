package com.example.sunnyweather.logic.model

/**
 * @Anthor:Tian
 * @Date:2020/9/12
 * @Description:
 */
data class Weather(val realtime: RealtimeResponse.Realtime,val daily: DailyResponse.Daily)
