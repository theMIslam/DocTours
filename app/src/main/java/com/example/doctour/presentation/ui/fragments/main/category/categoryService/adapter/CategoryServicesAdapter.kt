package com.example.doctour.presentation.ui.fragments.main.category.categoryService.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemServicesBinding

class CategoryServicesAdapter
    : PagingDataAdapter<String, CategoryServicesAdapter.CategoryServiceViewHolder>(BaseDiffUtilItemCallback()) {
    inner class CategoryServiceViewHolder (
        private val binding:ItemServicesBinding
            ):RecyclerView.ViewHolder(binding.root){
            fun bind(title: String){

            }
    }

    override fun onBindViewHolder(holder: CategoryServiceViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {

            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryServiceViewHolder {
        return CategoryServiceViewHolder(ItemServicesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}