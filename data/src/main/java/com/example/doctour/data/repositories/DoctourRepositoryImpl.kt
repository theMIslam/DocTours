package com.example.doctour.data.repositories

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.local.db.daos.DoctourDao
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class DoctourRepositoryImpl @Inject constructor(
      private val dao: DoctourDao
)
   // : BaseRepository(), DoctourRepository
{

   // override fun fetchDoctour() = doNetworkRequestWithMapping {
//        service.fetchDoctour().onSuccess { data ->
//            dao.insertDoctour(data.toEntity())
//        }
    }
  //  override fun getDoctour() = doLocalRequestForList { dao.getAllDoctour() }
//}
