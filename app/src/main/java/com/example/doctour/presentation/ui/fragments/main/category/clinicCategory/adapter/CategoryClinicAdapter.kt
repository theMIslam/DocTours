package com.example.doctour.presentation.ui.fragments.main.category.clinicCategory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemClinicInfoBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.model.ClinicUI

class CategoryClinicAdapter(
) : PagingDataAdapter<ClinicUI, CategoryClinicAdapter.ClinicsViewHolder>(
    BaseDiffUtilItemCallback()
) {
    override fun onBindViewHolder(holder: ClinicsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicsViewHolder {
        return ClinicsViewHolder(
            ItemClinicInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ClinicsViewHolder(private val binding: ItemClinicInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clinicsUi: ClinicUI) {
            clinicsUi.photo?.let { binding.ivClinicAvatar.loadImage(it) }
            binding.tvClinicName.text = clinicsUi.title

            ///tupik
            //????????
        }
    }
}