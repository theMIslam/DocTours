package com.example.doctour.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctour.core.base.BaseViewModel

class ViewModel :BaseViewModel() {

    private val _notification = MutableLiveData<List<Notification>>()
    val notification: LiveData<List<Notification>> get() = _notification

    fun getNotification(){
        _notification.value = listOf(Notification("asd", "asd", "asd", "asd"))


    }
}