package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @Anthor:Tian
 * @Date:2020/9/12
 * @Description:
 */
data class PlaceResponse(val status: String, val places: List<Place>)
data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)