package com.example.doctour.presentation.ui.fragments.model

import android.media.Rating

data class BermetModel(
    var name:String,
    var image:String,
    var profession:String,
    var clinic:String,
    var price:String,
    var experience:String,
    var rating: String,
    var numberOfFeedback:Int,
    var infoAboutDoctor:String,
    var recomendation :String
)
