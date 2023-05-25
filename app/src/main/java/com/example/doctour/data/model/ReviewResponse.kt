package com.example.doctour.data.model

import com.example.doctour.network.paging.DataMapper
import com.example.doctour.network.paging.IBaseDiffModel

data class ReviewResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ReviewModel>,
) : DataMapper<ReviewModel> {
    override fun responseToModel(): List<ReviewModel> = this.results
}

data class ReviewModel(
    val author: String? = "",
    val date_published: String? = "",
    val id: Int,
    val post: Int,
    val rating: Int,
    val text: String? = "",
) : IBaseDiffModel<Long> {
    override val idDif: Long
        get() = this.id.toLong()
}