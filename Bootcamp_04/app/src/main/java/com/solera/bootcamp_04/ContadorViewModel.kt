package com.solera.bootcamp_04

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    private val _contador = MutableLiveData(0)
    val contador:LiveData<Int> get() = _contador

    fun incrementar (){
        _contador.value = (_contador.value ?: 0) + 1
    }
}