package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @Anthor:Tian
 * @Date:2020/9/10
 * @Description:
 */
class SunnyWeatherApplication : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "GGpSMR3KGPHlQ2C6"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}