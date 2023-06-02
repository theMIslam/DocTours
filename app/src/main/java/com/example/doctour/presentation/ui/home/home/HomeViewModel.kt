package com.example.doctour.presentation.ui.home.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctour.data.base.BaseViewModel
import com.example.doctour.presentation.ui.home.home.model.Notification

class HomeViewModel : BaseViewModel() {

    private val _notification = MutableLiveData<List<Notification>>()
    val notification: LiveData<List<Notification>> get() = _notification

    fun getNotification(){
        _notification.value = listOf(Notification("asd", "asd", "asd", "asd"))


    }
}