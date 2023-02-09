package com.example.musicapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.model.MusicResponse
import com.example.musicapp.rest.MusicRepository
import com.example.musicapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicAppViewModel @Inject constructor(
    private val musicRepository: MusicRepository
): ViewModel() {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO


    private val _rock : MutableLiveData<UIState<MusicResponse>> = MutableLiveData(UIState.LOADING)
    val rock : MutableLiveData<UIState<MusicResponse>> get() = _rock

    init {
        getMusic()
    }

    private fun getMusic() {

    }




}