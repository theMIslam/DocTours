package com.example.doctour.presentation.ui.fragments.home.home.model

data class Notification(
    val title: String,
    val desc: String,
    val icon: String,
    val time: String
)

data class StateData(
    val notifications: List<Notification>
)
