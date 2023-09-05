package com.example.doctour.presentation.ui.adapter.category.categoryDoctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemCategoryDoctorsBinding
import com.example.doctour.presentation.model.speciality.SpecialtyUI

class CategoryDoctorSpecAdapter(
    private val onCLick:(SpecialtyUI)->Unit
) :
    PagingDataAdapter<SpecialtyUI, CategoryDoctorSpecAdapter.ViewHolderCategoryDoctor>(
      BaseDiffUtilItemCallback()
    ){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCategoryDoctor {
        return ViewHolderCategoryDoctor(ItemCategoryDoctorsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderCategoryDoctor, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolderCategoryDoctor(
       private val binding:ItemCategoryDoctorsBinding
   ):RecyclerView.ViewHolder(binding.root) {
        fun bind(specialityUi: SpecialtyUI) {
            binding.tvProf.text=specialityUi.name
            itemView.setOnClickListener {
                onCLick(specialityUi)
            }
        }
    }
}