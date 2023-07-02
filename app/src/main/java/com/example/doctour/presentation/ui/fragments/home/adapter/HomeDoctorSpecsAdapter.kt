package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.presentation.model.SpecialityUi


class HomeDoctorSpecsAdapter(
    private val onClick: () -> Unit
) : PagingDataAdapter<SpecialityUi, HomeDoctorSpecsAdapter.ViewHolder>(
    DFUtilHomeDoctorSpec()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeDoctorSpecsAdapter.ViewHolder {
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

    override fun onBindViewHolder(holder: HomeDoctorSpecsAdapter.ViewHolder, position: Int) {
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
