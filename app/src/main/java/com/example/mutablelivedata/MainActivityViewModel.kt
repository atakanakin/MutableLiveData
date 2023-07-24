package com.example.mutablelivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startVal: Int): ViewModel() {
    private var mutableLiveData: MutableLiveData<Int> = MutableLiveData()

    val res : LiveData<Int> get() = mutableLiveData

    init {
        mutableLiveData.value = startVal
    }

    fun trigger(){
        mutableLiveData.value = (mutableLiveData.value)?.plus(1)
    }
    fun unDo(){
        mutableLiveData.value = (mutableLiveData.value)?.minus(1)
    }

}