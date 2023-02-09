package com.example.musicapp.ui.rock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RockViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is rock Fragment"
    }
    val text: LiveData<String> = _text
}