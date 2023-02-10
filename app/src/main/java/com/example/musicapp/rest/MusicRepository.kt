package com.example.musicapp.rest

import android.content.ContentValues.TAG
import android.util.Log
import com.example.musicapp.model.MusicResponse
import com.example.musicapp.utils.FailureResponse
import com.example.musicapp.utils.NullMusicResponse
import com.example.musicapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MusicRepository {
    fun getMusic(term: String): Flow<UIState<MusicResponse>>
}

class MusicRepositoryImpl @Inject constructor(
    private val musicAppApi: MusicAppApi
) : MusicRepository {

    override fun getMusic(term: String): Flow<UIState<MusicResponse>> = flow {
        emit(UIState.LOADING)

        try {
            val response = musicAppApi.getMusic(term)
            Log.d(TAG, "Hello1: $response")
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d(TAG, "Hello2: $it")
                   emit(UIState.SUCCESS(it))
                } ?: throw NullMusicResponse()
            } else {
                throw FailureResponse(response.errorBody()?.string())
            }
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }









}