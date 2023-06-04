package com.example.doctour.presentation.ui.fragments.appoiment.model

data class BermetModel(
    val id :Int,
    val name:String,
    val status :String,
    val date:String,
    val time:String,
    val pred :String,
    val image :String,
    val timeOfCancel:String,
    val experience:String,
    val profession :String,
    val clinic:String,
    val rating:String,
    val recomendation:String,
    val price:String,
    val numberOfFeedbacks:Int,
    val infoAboutDoctor :String
)
data class BermetFeedbacks(
    val name:String,
    val image:String,
    val feedback:String,
    val date:Int,
    val numberOfLikes:Int
)
