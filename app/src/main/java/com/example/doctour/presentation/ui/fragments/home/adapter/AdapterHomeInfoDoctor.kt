package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.ui.fragments.home.model.DoctorModel

class AdapterHomeInfoDoctor(
    private val onClickListener: () -> Unit
) : ListAdapter<DoctorModel, AdapterHomeInfoDoctor.ViewHolderHomeInfoDoctor>(
    DFUtilHomeInfoDoctor()
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
        holder.bind(getItem(position))
    }
    inner class ViewHolderHomeInfoDoctor(private val binding: ItemDoctorsInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(doctor: DoctorModel) {

            itemView.setOnClickListener {
                onClickListener
            }
        }
    }
}
private class DFUtilHomeInfoDoctor : DiffUtil.ItemCallback<DoctorModel>() {
    override fun areItemsTheSame(oldItem: DoctorModel, newItem: DoctorModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DoctorModel, newItem: DoctorModel): Boolean {
        return oldItem == newItem
    }
}