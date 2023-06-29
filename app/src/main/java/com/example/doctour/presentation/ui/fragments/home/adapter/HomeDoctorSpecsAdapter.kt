package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.model.SpecializationUI
import com.example.doctour.presentation.ui.fragments.home.model.ItemPhoto


class HomeDoctorSpecsAdapter(
    private val onClick: () -> Unit
): RecyclerView.Adapter<HomeDoctorSpecsAdapter.ViewHolder>() {

    private var list = ArrayList<ItemPhoto>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDoctorSpecsAdapter.ViewHolder {
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
    override fun onBindViewHolder(holder: HomeDoctorSpecsAdapter.ViewHolder, position: Int) {
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
