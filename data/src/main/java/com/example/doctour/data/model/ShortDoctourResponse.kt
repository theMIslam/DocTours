package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.data.network.paging.IBaseDiffModel

data class ShortDoctourResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ShortDoctourModel>,
) : DataMapper<ShortDoctourModel> {
    override fun responseToModel(): List<ShortDoctourModel> = this.results
}

data class ShortDoctourModel(
    val average_rating: String,
    val duration: String,
    val id: Int,
    val price: Int,
    val region: List<Region>,
    val slug: String,
    val title: String,
    val doctour_images: List<TourImage>,
) : IBaseDiffModel<Long> {
    override val idDif: Long
        get() = this.id.toLong()
}

