package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @Anthor:Tian
 * @Date:2020/9/12
 * @Description:地点数据
 */
data class PlaceResponse(val status: String, val places: List<Place>)
data class
Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

//经纬度
data class Location(val lng: String, val lat: String)