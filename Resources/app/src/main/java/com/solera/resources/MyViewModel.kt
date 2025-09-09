package com.solera.resources

import androidx.lifecycle.MutableLiveData
import  androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var counter: MutableLiveData<Int> = MutableLiveData(0)
    fun increaseCounter() {
        val currentValue: Int = counter.value ?: 0
        counter.value = currentValue + 1
    }
    fun getCount(): Int {
        return counter.value ?: 0
    }
}