package com.example.doctour.data.remote.dto.favourites


import com.google.gson.annotations.SerializedName

data class FavoriteTourResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("favorite_tour")
    val favoriteTour: List<FavoriteTourDto>
)