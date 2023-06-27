package com.example.doctour.data.local.db.entities.doctour

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.local.DoctourLocal

@Entity(tableName = "doctour")
class DoctourEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
) : DataMapper<DoctourLocal> {
    override fun mapToDomain() = DoctourLocal(id, bar)
}
