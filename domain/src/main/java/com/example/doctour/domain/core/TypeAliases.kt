package com.example.doctour.domain.core

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

internal typealias RemoteWrapper<T> = Flow<Either<NetworkError, T>>

internal typealias RemotePagingWrapper<T> = Flow<PagingData<T>>