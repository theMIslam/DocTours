package com.example.doctour.data.utils

/**
 * Base mapper interface
 *
 * @param T domain layer model
 *
 * @author London
 */
interface DataMapper<T> {

    /**
     * Function for map data layer model to domain layer model
     */
    fun mapToDomain(): T
}