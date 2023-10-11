package com.example.doctour.presentation.ui.adapters.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemFoundVecanciesBinding
import com.example.doctour.presentation.module.loadImage
import com.example.doctour.presentation.model.doctour.DoctorUI

class SearchAdapter(
    private var onClickListener: (DoctorUI) -> Unit
) : PagingDataAdapter<DoctorUI, SearchAdapter.SearchViewHolder>(
    BaseDiffUtilItemCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemFoundVecanciesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    inner class SearchViewHolder(private var binding: ItemFoundVecanciesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctorUi: DoctorUI) {
            doctorUi.photo?.let { binding.ivDoctorAvatar.loadImage(it) }
            binding.tvDoctorName.text = doctorUi.full_name
            binding.tvWorkExperience.text = doctorUi.experience.toString()
           // binding.tvWorkSpeciality.text = doctorUi.specialties.toString()
           // binding.tvWorkClinic.text = doctorUi.clinic.toString()
            binding.tvPoints.text = doctorUi.average_rating.toString()
            binding.tvRecommendation.text = doctorUi.summary
            binding.tvSumma.text = doctorUi.price.toString()

            itemView.setOnClickListener {
                onClickListener(doctorUi)
            }
        }

    }

}