package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.presentation.model.ClinicsUi

class AdapterHomeClinic(
    private val onCLick: () -> Unit
) : ListAdapter<ClinicsUi, AdapterHomeClinic.ViewHolderHomeClinic>(
    DFUtilHomeClinicsUi()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeClinic {
        return ViewHolderHomeClinic(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderHomeClinic, position: Int) {
        holder.bind(getItem(position))
    }
    inner class ViewHolderHomeClinic(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clinics: ClinicsUi) {

            itemView.setOnClickListener {
                onCLick
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