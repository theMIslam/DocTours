package com.example.doctour.data.utils

interface DataMapper<T> {
    fun responseToModel(): List<T>
}