package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.model.DoctorUi

class FavoriteDoctorsAdapter(
    private val onClick:(DoctorUi)-> Unit,
    private val onLongClick:(DoctorUi)->Unit
) : PagingDataAdapter< DoctorUi,FavoriteDoctorsAdapter.FavoriteDoctorsViewHolder>(
    DFUtilFavDoctor()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDoctorsViewHolder {
        return FavoriteDoctorsViewHolder(
            ItemDoctorsInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))}

    override fun onBindViewHolder(holder: FavoriteDoctorsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class FavoriteDoctorsViewHolder(
        private val binding: ItemDoctorsInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: DoctorUi) {
            doctor.photo?.let { binding.ivDoctorAvatar.loadImage(it) }
            binding.tvDoctorName.text = doctor.full_name
            binding.tvWorkExperience.text = doctor.experience.toString()
            binding.tvWorkSpeciality.text = doctor.specialties.toString()
            binding.tvWorkClinic.text = doctor.clinic.toString()
            binding.tvRecommendation.text = "${doctor.num_reviews} рекомендаций"
            binding.tvPoints.text =  doctor.average_rating.toString()
            binding.tvSumma.text = doctor.num_reviews.toString()

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
private class DFUtilFavDoctor : DiffUtil.ItemCallback<DoctorUi>() {
    override fun areItemsTheSame(oldItem: DoctorUi, newItem: DoctorUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DoctorUi, newItem: DoctorUi): Boolean {
        return oldItem == newItem
    }
}