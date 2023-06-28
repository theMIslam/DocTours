package com.example.doctour.presentation.ui.fragments.main.category.clinicCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemClinicInfoBinding
import com.example.doctour.presentation.model.ClinicsUi
import com.example.doctour.presentation.extensions.loadImage

class AdapterCategoryClinic(
) : PagingDataAdapter<ClinicsUi, AdapterCategoryClinic.ClinicsViewHolder>(
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
        fun bind(clinicsUi: ClinicsUi) {
            binding.ivClinicAvatar.loadImage(clinicsUi.photo)
            binding.tvClinicName.text=clinicsUi.title
            ///tupik
            //????????
        }
    }
}