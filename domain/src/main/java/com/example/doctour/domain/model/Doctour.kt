package com.example.doctour.domain.model

class Doctour(
    val id: Int = DEFAULT_ID,
    var tittle: String? = null,
    var description: String? = null
): java.io.Serializable {
    companion object {
        const val  DEFAULT_ID = 0
    }
}