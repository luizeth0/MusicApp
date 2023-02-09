package com.example.musicapp.ui.classic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClassicViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is classic Fragment"
    }
    val text: LiveData<String> = _text
}