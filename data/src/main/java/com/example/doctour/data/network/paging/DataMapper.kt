package com.example.doctour.data.network.paging

interface DataMapper<T> {
    fun responseToModel(): List<T>
}