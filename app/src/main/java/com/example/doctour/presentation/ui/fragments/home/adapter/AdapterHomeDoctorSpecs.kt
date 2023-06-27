package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.domain.model.Specialization


class AdapterHomeDoctorSpecs (
    private val onClick: () -> Unit
): ListAdapter<Specialization,AdapterHomeDoctorSpecs.ViewHolder>(
   DFUtilHomeDoctorSpec()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AdapterHomeDoctorSpecs.ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context
                ), parent, false))
    }
    inner class ViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(specialization: Specialization) {
            itemView.setOnClickListener {

                onClick()
            }
        }
    }
    override fun onBindViewHolder(holder: AdapterHomeDoctorSpecs.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
   private class DFUtilHomeDoctorSpec : DiffUtil.ItemCallback<Specialization>() {
        override fun areItemsTheSame(oldItem: Specialization, newItem: Specialization): Boolean {
             return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Specialization, newItem: Specialization): Boolean {
            return oldItem == newItem
        }
    }

}
