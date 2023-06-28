package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.model.DoctorUi

class HomeInfoDoctorAdapter(
    private val onClickListener: (DoctorUi) -> Unit
) : PagingDataAdapter<DoctorUi, HomeInfoDoctorAdapter.ViewHolderHomeInfoDoctor>(
    BaseDiffUtilItemCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeInfoDoctor {
        return ViewHolderHomeInfoDoctor(
            ItemDoctorsInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderHomeInfoDoctor, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
    inner class ViewHolderHomeInfoDoctor(private val binding: ItemDoctorsInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: DoctorUi)= with(binding){
            ivDoctorAvatar.loadImage(doctor.photo)
            tvDoctorName.text=doctor.full_name
            tvWorkExperience.text= doctor.experience.toString()
            tvWorkSpeciality.text=doctor.specialties.toString()
            tvWorkClinic.text=doctor.clinic.toString()
            tvPoints.text=doctor.average_rating.toString()
            tvRecommendation.text="${doctor.num_reviews} рекомендаций"
        }
    }
}