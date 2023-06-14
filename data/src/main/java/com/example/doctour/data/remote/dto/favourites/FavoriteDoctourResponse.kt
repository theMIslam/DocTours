package com.example.doctour.data.remote.dto.favourites


import com.google.gson.annotations.SerializedName

data class FavoriteDoctourResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("favorite_tour")
    val favoriteTour: List<FavoriteDoctourDto>
)