package com.example.doctour.presentation.ui.fragments.main.category.categoryService.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemServicesBinding
import com.example.doctour.presentation.model.ServiceUi

class CategoryServicesAdapter(private val onClick:(ServiceUi)->Unit)
    : PagingDataAdapter<ServiceUi, CategoryServicesAdapter.CategoryServiceViewHolder>(
    CategoryServiceDFUtil()
) {
    inner class CategoryServiceViewHolder (
        private val binding:ItemServicesBinding
            ):RecyclerView.ViewHolder(binding.root){
            fun bind(serviceUi: ServiceUi){
                binding.tvServiceName.text=serviceUi.name
                itemView.setOnClickListener{
                    onClick.invoke(serviceUi)
                }
            }
    }

    override fun onBindViewHolder(holder: CategoryServiceViewHolder, position: Int) {
         getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryServiceViewHolder {
        return CategoryServiceViewHolder(ItemServicesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}
private class CategoryServiceDFUtil:DiffUtil.ItemCallback<ServiceUi>(){
    override fun areItemsTheSame(oldItem: ServiceUi, newItem: ServiceUi): Boolean {
        return oldItem.slug == newItem.slug
    }

    override fun areContentsTheSame(oldItem: ServiceUi, newItem: ServiceUi): Boolean {
        return  oldItem == newItem
    }
}