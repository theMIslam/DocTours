package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemClinicBinding
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.presentation.ui.fragments.home.model.HomeModel

class AdapterHomeClinic(
    private val onCLick: () -> Unit
) : ListAdapter<HomeModel, AdapterHomeClinic.ViewHolderHomeClinic>(
    DFUtilHomeClinic()
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
        holder.bind(getItem(position))
    }
    inner class ViewHolderHomeClinic(private val binding: ItemClinicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel) {
            binding.tvClinicName.text = model.title
            model.image?.let { binding.imgClinicAvatar.setImageResource(it) }
            itemView.setOnClickListener {
                onCLick
            }
        }

    }
}
private class DFUtilHomeClinic : DiffUtil.ItemCallback<HomeModel>() {
    override fun areItemsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
        return oldItem.title == newItem.title && oldItem.image == newItem.image
    }
}