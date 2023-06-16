package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemHomeBinding
import com.example.doctour.presentation.ui.fragments.home.model.HomeModel

class AdapterHomeClinic (
    private val onCLick:()->Unit
        ):RecyclerView.Adapter<AdapterHomeClinic.ViewHolderHomeClinic>(){

    private val list :ArrayList<HomeModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeClinic {
       return ViewHolderHomeClinic(ItemHomeBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderHomeClinic, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class ViewHolderHomeClinic(private val binding:ItemHomeBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(homeModel: HomeModel) {

            itemView.setOnClickListener {
                onCLick
            }
        }

    }
}