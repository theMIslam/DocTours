package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemClinicBinding
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.model.ClinicsUi
import com.example.doctour.presentation.extensions.loadImage

class AdapterHomeClinic(
    private val onCLick: () -> Unit
) : PagingDataAdapter<ClinicsUi, AdapterHomeClinic.ViewHolderHomeClinic>(
    DFUtilHomeClinicsUi()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeClinic {
        return ViewHolderHomeClinic(
            ItemClinicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderHomeClinic, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
    inner class ViewHolderHomeClinic(private val binding: ItemClinicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clinics: ClinicsUi) {
            clinics.photo?.let { binding.imgClinicAvatar.loadImage(it) }
            binding.tvClinicName.text=clinics.title

            itemView.setOnClickListener {
                onCLick()
            }
        }

    }
}
private class DFUtilHomeClinicsUi : DiffUtil.ItemCallback<ClinicsUi>() {
    override fun areItemsTheSame(oldItem: ClinicsUi, newItem: ClinicsUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ClinicsUi, newItem: ClinicsUi): Boolean {
        return oldItem == newItem
    }
}