package com.example.musicapp.model


import com.google.gson.annotations.SerializedName

data class MusicResponse(
    @SerializedName("resultCount")
    val resultCount: Int? = null,
    @SerializedName("results")
    val results: List<Result?>? = null
)