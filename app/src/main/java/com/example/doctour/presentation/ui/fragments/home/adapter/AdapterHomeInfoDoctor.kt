package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.domain.model.Doctor
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.model.DoctorUi

class AdapterHomeInfoDoctor : PagingDataAdapter<DoctorUi, AdapterHomeInfoDoctor.ViewHolderHomeInfoDoctor>(
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
        fun bind(doctor: DoctorUi) {
            doctor.photo?.let { binding.ivDoctorAvatar.loadImage(it) }
            binding.tvDoctorName.text = doctor.full_name.toString()
            binding.tvWorkExperience.text = doctor.experience.toString()
            //binding.tvWorkSpeciality.text = doctor.specialties
           // binding.tvWorkClinic.text = doctor.clinic
            binding.tvPoints.text = doctor.average_rating.toString()
            binding.tvRecommendation.text = "${doctor.num_reviews} рекомендаций"
            binding.tvSumma.text = doctor.price.toString()
        }
    }
}