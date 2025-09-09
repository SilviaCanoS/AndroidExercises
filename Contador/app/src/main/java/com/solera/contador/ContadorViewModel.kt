package com.solera.contador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    private val _contador = MutableLiveData(0)
    val contador: LiveData<Int> get() = _contador

    fun incrementar (){
        _contador.value = (_contador.value ?: 0) + 1
    }

    fun decrementar (){
        _contador.value = (_contador.value ?: 0) - 1
    }

    fun resetear (){
        _contador.value = 0
    }
}