package com.example.doctour.presentation.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.presentation.ui.fragments.home.home.model.HomeModel

class AdapterHomeDoctorSpecs (private val onClick: () -> Unit
): ListAdapter<HomeModel, AdapterHomeDoctorSpecs.ViewHolder>(
    AdapterHomeDoctorSpecs.Comparator()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHomeDoctorSpecs.ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context
                ), parent, false))
    }
    inner class ViewHolder(
        private val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel) {
            itemView.setOnClickListener {
                onClick()
            }
        }
    }
    override fun onBindViewHolder(holder: AdapterHomeDoctorSpecs.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    @SuppressLint("DiffUtilEquals")
    class Comparator : DiffUtil.ItemCallback<HomeModel>() {
        override fun areItemsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
             return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HomeModel, newItem: HomeModel): Boolean {
            return oldItem == newItem
        }
    }

}
