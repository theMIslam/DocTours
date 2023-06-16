package com.example.doctour.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.doctour.domain.core.Either
import com.example.doctour.domain.core.NetworkError
import com.example.doctour.presentation.ui.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {

    @Suppress("FunctionName")
    protected fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    protected fun <T> MutableStateFlow<UIState<T>>.reset() {
        value = UIState.Idle()
    }


    protected fun <T> Flow<Either<NetworkError, T>>.collectNetworkRequest(
        state: MutableStateFlow<UIState<T>>
    ) = collectUIState(state) {
        UIState.Success(it)
    }

    protected fun <T, S> Flow<Either<NetworkError, T>>.collectNetworkRequest(
        state: MutableStateFlow<UIState<S>>,
        mapToUI: (T) -> S
    ) = collectUIState(state) {
        UIState.Success(mapToUI(it))
    }

    private fun <T, S> Flow<Either<NetworkError, T>>.collectUIState(
        state: MutableStateFlow<UIState<S>>,
        successful: (T) -> UIState.Success<S>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectUIState.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value.toString())
                    is Either.Right -> state.value = successful(it.value)
                }
            }
        }
    }

    protected fun <T, S> Flow<T>.collectLocalRequest(
        mapToUI: (T) -> S
    ): Flow<S> = map { value: T ->
        mapToUI(value)
    }

    protected fun <T, S> Flow<List<T>>.collectLocalRequestForList(
        mapToUI: (T) -> S
    ): Flow<List<S>> = map { value: List<T> ->
        value.map { data: T ->
            mapToUI(data)
        }
    }

    protected fun <T : Any, S : Any> Flow<PagingData<T>>.collectPagingRequest(
        mapToUI: (T) -> S
    ): Flow<PagingData<S>> = map { value: PagingData<T> ->
        value.map { data: T ->
            mapToUI(data)
        }
    }.cachedIn(viewModelScope)
}
