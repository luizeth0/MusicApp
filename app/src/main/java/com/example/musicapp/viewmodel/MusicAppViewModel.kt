package com.example.musicapp.viewmodel

import androidx.lifecycle.LiveData
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

    private val _fragrock = MutableLiveData<String>().apply {
        value = "This is rock Fragment"
    }
    val fragrock: LiveData<String> = _fragrock

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    private val genres = arrayListOf("rock","classic","pop")
    var songUri : String = ""

    private val _rock : MutableLiveData<UIState<MusicResponse>> = MutableLiveData(UIState.LOADING)
    val rock : MutableLiveData<UIState<MusicResponse>> get() = _rock

    private val _classic : MutableLiveData<UIState<MusicResponse>> = MutableLiveData(UIState.LOADING)
    val classic : MutableLiveData<UIState<MusicResponse>> get() = _classic

    private val _pop : MutableLiveData<UIState<MusicResponse>> = MutableLiveData(UIState.LOADING)
    val pop : MutableLiveData<UIState<MusicResponse>> get() = _pop

    init {
        getMusic()
    }

    private fun getMusic() {
        genres.forEach{ genre ->
            run {
                viewModelScope.launch(ioDispatcher) {
                    musicRepository.getMusic(genre).collect() {
                        when (genre) {
                            "rock" -> _rock.postValue(it)
                            "classic" -> _classic.postValue(it)
                            "pop" -> _pop.postValue(it)
                        }
                    }
                }
            }
        }
    }





}