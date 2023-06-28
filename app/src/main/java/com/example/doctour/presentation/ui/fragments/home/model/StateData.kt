package com.example.doctour.presentation.ui.fragments.home.model

data class Notification(
    val title: String,
    val desc: String,
    val icon: String,
    val time: String
)

data class StateData(
    val notifications: List<Notification>
)
data class ItemPhoto(
    val id:Int,
    val title:String,
    val image :String
)
