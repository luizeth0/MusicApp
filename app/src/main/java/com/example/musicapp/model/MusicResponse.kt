package com.example.musicapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MusicResponse(
    @Json(name = "resultCount")
    val resultCount: Int? = null,
    @Json(name = "results")
    val results: List<Result?>? = null
)