package com.example.doctour.ui.home

data class Notification(
    val title: String,
    val desc: String,
    val icon: String,
    val time: String
)

data class StateData(
    val notifications: List<Notification>
)
