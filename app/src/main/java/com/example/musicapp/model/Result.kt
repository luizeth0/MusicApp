package com.example.musicapp.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("artistId")
    val artistId: Int? = null,
    @SerializedName("artistName")
    val artistName: String? = null,
    @SerializedName("artistViewUrl")
    val artistViewUrl: String? = null,
    @SerializedName("artworkUrl100")
    val artworkUrl100: String? = null,
    @SerializedName("artworkUrl30")
    val artworkUrl30: String? = null,
    @SerializedName("artworkUrl60")
    val artworkUrl60: String? = null,
    @SerializedName("collectionArtistId")
    val collectionArtistId: Int? = null,
    @SerializedName("collectionArtistName")
    val collectionArtistName: String? = null,
    @SerializedName("collectionArtistViewUrl")
    val collectionArtistViewUrl: String? = null,
    @SerializedName("collectionCensoredName")
    val collectionCensoredName: String? = null,
    @SerializedName("collectionExplicitness")
    val collectionExplicitness: String? = null,
    @SerializedName("collectionHdPrice")
    val collectionHdPrice: Double? = null,
    @SerializedName("collectionId")
    val collectionId: Int? = null,
    @SerializedName("collectionName")
    val collectionName: String? = null,
    @SerializedName("collectionPrice")
    val collectionPrice: Double? = null,
    @SerializedName("collectionViewUrl")
    val collectionViewUrl: String? = null,
    @SerializedName("contentAdvisoryRating")
    val contentAdvisoryRating: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("currency")
    val currency: String? = null,
    @SerializedName("discCount")
    val discCount: Int? = null,
    @SerializedName("discNumber")
    val discNumber: Int? = null,
    @SerializedName("hasITunesExtras")
    val hasITunesExtras: Boolean? = null,
    @SerializedName("isStreamable")
    val isStreamable: Boolean? = null,
    @SerializedName("kind")
    val kind: String? = null,
    @SerializedName("longDescription")
    val longDescription: String? = null,
    @SerializedName("previewUrl")
    val previewUrl: String? = null,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String? = null,
    @SerializedName("releaseDate")
    val releaseDate: String? = null,
    @SerializedName("trackCensoredName")
    val trackCensoredName: String? = null,
    @SerializedName("trackCount")
    val trackCount: Int? = null,
    @SerializedName("trackExplicitness")
    val trackExplicitness: String? = null,
    @SerializedName("trackHdPrice")
    val trackHdPrice: Double? = null,
    @SerializedName("trackHdRentalPrice")
    val trackHdRentalPrice: Double? = null,
    @SerializedName("trackId")
    val trackId: Int? = null,
    @SerializedName("trackName")
    val trackName: String? = null,
    @SerializedName("trackNumber")
    val trackNumber: Int? = null,
    @SerializedName("trackPrice")
    val trackPrice: Double? = null,
    @SerializedName("trackRentalPrice")
    val trackRentalPrice: Double? = null,
    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Int? = null,
    @SerializedName("trackViewUrl")
    val trackViewUrl: String? = null,
    @SerializedName("wrapperType")
    val wrapperType: String? = null
)