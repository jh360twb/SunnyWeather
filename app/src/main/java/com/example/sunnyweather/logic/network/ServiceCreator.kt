package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Anthor:Tian
 * @Date:2020/9/11
 * @Description:
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //返回的是一个service的对象
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    //泛型实化
    inline fun <reified T> create(): T = create(T::class.java)

}