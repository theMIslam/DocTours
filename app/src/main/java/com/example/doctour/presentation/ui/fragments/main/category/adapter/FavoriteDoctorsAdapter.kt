package com.example.doctour.presentation.ui.fragments.home.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.ui.fragments.model.BermetModel

class FavoriteDoctorsAdapter(
    private val onClick:()->Unit,
    private val onLongClick:()->Unit
) : RecyclerView.Adapter<FavoriteDoctorsAdapter.FavoriteDoctorsViewHolder>() {

    private val list:ArrayList<BermetModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDoctorsViewHolder {
        return FavoriteDoctorsViewHolder(ItemDoctorsInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteDoctorsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FavoriteDoctorsViewHolder(
        private val binding: ItemDoctorsInfoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bermetModel: BermetModel) {

            itemView.setOnClickListener {
                onClick
            }
            itemView.setOnLongClickListener {
                onLongClick
                return@setOnLongClickListener false
            }
        }

    }
}