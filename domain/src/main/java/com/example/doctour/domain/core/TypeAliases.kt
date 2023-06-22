package com.example.doctour.domain.core

import kotlinx.coroutines.flow.Flow

internal typealias RemoteWrapper<T> = Flow<Either<NetworkError, T>>