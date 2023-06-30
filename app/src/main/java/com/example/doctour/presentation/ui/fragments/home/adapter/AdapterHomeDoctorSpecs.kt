package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.domain.model.Specialization
import com.example.doctour.model.SpecialityUi
import com.example.doctour.model.SpecializationUI
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.ui.fragments.home.model.ItemPhoto


class AdapterHomeDoctorSpecs(
    private val onClick: () -> Unit
) : PagingDataAdapter<SpecialityUi, AdapterHomeDoctorSpecs.ViewHolder>(
    DFUtilHomeDoctorSpec()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterHomeDoctorSpecs.ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(specializationUI: SpecialityUi) {
            binding.tvDoctorSpecs.text = specializationUI.name

            itemView.setOnClickListener {
                onClick()
            }
        }
    }

    override fun onBindViewHolder(holder: AdapterHomeDoctorSpecs.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    private class DFUtilHomeDoctorSpec : DiffUtil.ItemCallback<SpecialityUi>() {
        override fun areItemsTheSame(
            oldItem: SpecialityUi,
            newItem: SpecialityUi
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SpecialityUi,
            newItem: SpecialityUi
        ): Boolean {
            return oldItem == newItem
        }
    }

}
