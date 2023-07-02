package com.example.doctour.presentation.ui.fragments.main.category.categoryService

import androidx.paging.PagingSource
import androidx.paging.PagingState

class StringPagingSource(private val stringList: List<String>) : PagingSource<Int, String>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        try {
            val currentPage = params.key ?: 0
            val nextPage = currentPage + 1

            val items = stringList.subList(
                currentPage * params.loadSize,
                minOf((currentPage + 1) * params.loadSize, stringList.size)
            )

            // Возвращение результата загрузки данных
            return LoadResult.Page(
                data = items,
                prevKey = null,
                nextKey = nextPage.takeIf { nextPage < stringList.size / params.loadSize }
            )
        } catch (e: Exception) {
            // Обработка ошибки
            return LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        // Определение ключа обновления
        return null
    }
}