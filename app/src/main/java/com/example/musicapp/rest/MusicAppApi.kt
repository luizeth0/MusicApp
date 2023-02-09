package com.example.musicapp.rest

import com.example.musicapp.model.MusicResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicAppApi {

    @GET(PATH)
    suspend fun getMusic(
        @Query("term") term: String,
        @Query("amp;media", encoded = true) media: String,
        @Query("amp;entity", encoded = true) entity: String,
        @Query("amp;limit", encoded = true) limit: String,
    ) : Response<MusicResponse>

    companion object {
        // https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
        const val BASE_URL = "https://itunes.apple.com/"
        private const val PATH = "search"
    }

}