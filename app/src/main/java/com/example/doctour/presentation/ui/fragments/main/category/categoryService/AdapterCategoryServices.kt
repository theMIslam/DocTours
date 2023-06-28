package com.example.doctour.presentation.ui.fragments.main.category.categoryService

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemServicesBinding
import com.example.doctour.model.ServiceUi

class AdapterCategoryServices
    : PagingDataAdapter<ServiceUi,AdapterCategoryServices.CategoryServiceViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class CategoryServiceViewHolder (
        private val binding:ItemServicesBinding
            ):RecyclerView.ViewHolder(binding.root){
            fun bind(serviceUi: ServiceUi){

            }
    }

    override fun onBindViewHolder(holder: CategoryServiceViewHolder, position: Int) {
         getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryServiceViewHolder {
        return CategoryServiceViewHolder(ItemServicesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}