package com.example.musicapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(

    @Json(name = "artistName")
    val artistName: String? = null,

    @Json(name = "artworkUrl60")
    val artworkUrl60: String? = null,

    @Json(name = "collectionName")
    val collectionName: String? = null,

    @Json(name = "previewUrl")
    val previewUrl: String? = null,

    @Json(name = "trackName")
    val trackName: String? = null,

    @Json(name = "trackPrice")
    val trackPrice: Double? = null
)