package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.domain.model.Specialization
import com.example.doctour.model.SpecializationUI
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.ui.fragments.home.model.ItemPhoto


class AdapterHomeDoctorSpecs(
    private val onClick: () -> Unit
): RecyclerView.Adapter<AdapterHomeDoctorSpecs.ViewHolder>() {

    private var list = ArrayList<ItemPhoto>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AdapterHomeDoctorSpecs.ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context
                ), parent, false))
    }

    inner class ViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemPhoto:ItemPhoto) {

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: AdapterHomeDoctorSpecs.ViewHolder, position: Int) {
        holder.bind(list[position])
    }
   private class DFUtilHomeDoctorSpec : DiffUtil.ItemCallback<SpecializationUI>() {
        override fun areItemsTheSame(oldItem: SpecializationUI, newItem: SpecializationUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SpecializationUI, newItem: SpecializationUI): Boolean {
            return oldItem == newItem
        }
    }

}
