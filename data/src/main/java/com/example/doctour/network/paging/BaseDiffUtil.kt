package com.example.doctour.network.paging

import androidx.recyclerview.widget.DiffUtil
import com.example.doctour.data.network.paging.IBaseDiffModel


interface IBaseDiffModel<T> {
    val idDif: T
    override fun equals(other: Any?): Boolean
}

class BaseDiffUtilItemCallback<T : IBaseDiffModel<S>, S> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.idDif == newItem.idDif
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}