package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.model.DoctorUI

class HomeInfoDoctorAdapter (
    private val onCLick: ClickListener
        ) : PagingDataAdapter<DoctorUI, HomeInfoDoctorAdapter.ViewHolderHomeInfoDoctor>(
    BaseDiffUtilItemCallback())
    , View.OnClickListener {

    override fun onClick(v: View) {
        val doctorUi = v.tag as DoctorUI
        onCLick.onClick(doctorUi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeInfoDoctor {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDoctorsInfoBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)

        return ViewHolderHomeInfoDoctor(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderHomeInfoDoctor, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolderHomeInfoDoctor(private val binding: ItemDoctorsInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: DoctorUI) {
            binding.root.tag = doctor

            doctor.photo?.let { binding.ivDoctorAvatar.loadImage(it) }
            binding.tvDoctorName.text = doctor.full_name.toString()
            binding.tvWorkExperience.text = "Стаж работы ${doctor.experience.toString()} года"
           // binding.tvWorkSpeciality.text = doctor.specialtiesObject?.name
             //binding.tvWorkClinic.text = doctor.clinicObject?.title
            binding.tvPoints.text = doctor.average_rating.toString()
            binding.tvRecommendation.text = "(${doctor.num_reviews} отзыва)"
            binding.tvSumma.text = doctor.price.toString()
            binding.tvHeart.isChecked = doctor.isChoosen
        }
    }

    interface ClickListener {
        fun onClick(doctorUi: DoctorUI)
    }
}