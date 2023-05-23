package com.example.doctour.network.paging

interface DataMapper<T> {
    fun responseToModel(): List<T>
}