package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.domain.model.Clinics

class AdapterHomeClinic(
    private val onCLick: () -> Unit
) : ListAdapter<Clinics, AdapterHomeClinic.ViewHolderHomeClinic>(
    DFUtilHomeClinic()
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
        fun bind(clinics: Clinics) {

            itemView.setOnClickListener {
                onCLick
            }
        }

    }
}
private class DFUtilHomeClinic : DiffUtil.ItemCallback<Clinics>() {
    override fun areItemsTheSame(oldItem: Clinics, newItem: Clinics): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Clinics, newItem: Clinics): Boolean {
        return oldItem == newItem
    }
}