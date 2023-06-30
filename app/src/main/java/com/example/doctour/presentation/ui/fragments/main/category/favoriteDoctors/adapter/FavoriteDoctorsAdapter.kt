package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.model.DoctorUi
import com.example.doctour.presentation.extensions.loadImage

class FavoriteDoctorsAdapter(
    private val onClick: (DoctorUi) -> Unit,
    private val onLongClick: (DoctorUi) -> Unit
) : PagingDataAdapter<DoctorUi, FavoriteDoctorsAdapter.FavoriteDoctorsViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDoctorsViewHolder {
        return FavoriteDoctorsViewHolder(
            ItemDoctorsInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteDoctorsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class FavoriteDoctorsViewHolder(
        private val binding: ItemDoctorsInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: DoctorUi) {
            doctor.apply {
                photo?.let { binding.ivDoctorAvatar.loadImage(it) }
                binding.tvDoctorName.text = full_name
                binding.tvWorkExperience.text = experience.toString()
                binding.tvWorkSpeciality.text = doctor.specialties.toString()
                binding.tvWorkClinic.text = doctor.clinic.toString()
                binding.tvRecommendation.text = "${doctor.num_reviews} рекомендаций"
                binding.tvPoints.text = average_rating.toString()
                binding.tvSumma.text = num_reviews.toString()
            }

            itemView.setOnClickListener {
                onClick(doctor)
            }
            itemView.setOnLongClickListener {
                onLongClick(doctor)
                return@setOnLongClickListener false
            }
        }

    }
}