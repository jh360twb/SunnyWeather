package com.example.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @Anthor:Tian
 * @Date:2020/9/11
 * @Description:网络的单例类,网络数据源的访问入口
 */
object SunnyWeatherNetwork {
    private val weatherService = ServiceCreator.create(WeatherService::class.java)
    suspend fun getDailyWeather(lng: String, lat: String) =
        weatherService.getDailyWeather(lng, lat).await()

    suspend fun getRealtimeWeather(lng: String, lat: String) =
        weatherService.getRealtimeWeather(lng, lat).await()


    private val placeService = ServiceCreator.create(PlaceService::class.java)
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    //Call的扩展函数,使用了泛型,即返回值是Call类型的Retrofit网络请求接口都可以直接调用await()函数
    //调用一下await()就可以发起网络请求并直接获得服务器响应的数据
    private suspend fun <T> Call<T>.await(): T {
        //suspendCoroutine用来挂起当前协程
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }
            })
        }
    }
}