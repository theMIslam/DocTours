package com.example.doctour.presentation.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.ui.fragments.home.model.HomeModel

class AdapterHomeInfoDoctor (
    private val onClick :()->Unit
        ) : RecyclerView.Adapter<AdapterHomeInfoDoctor.ViewHolderHomeInfoDoctor> (){

    private val list :ArrayList<HomeModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeInfoDoctor {
        return ViewHolderHomeInfoDoctor(ItemDoctorsInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderHomeInfoDoctor, position: Int) {
      holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolderHomeInfoDoctor (private val binding:ItemDoctorsInfoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(homeModel: HomeModel) {

            itemView.setOnClickListener {
                onClick
            }
        }

    }

}