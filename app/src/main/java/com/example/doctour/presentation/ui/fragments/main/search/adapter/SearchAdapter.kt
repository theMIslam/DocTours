package com.example.doctour.presentation.ui.fragments.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemFoundVecanciesBinding
import com.example.doctour.model.DoctorUi
import com.example.doctour.presentation.extensions.loadImage

class SearchAdapter (
    private var userList: ArrayList<DoctorUi>,
    private var onClickListener :(DoctorUi)->Unit
): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    private var list :ArrayList<DoctorUi> =ArrayList()

    fun filterList(filteredNames: ArrayList<DoctorUi>) {
        this.userList = filteredNames
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemFoundVecanciesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    inner class SearchViewHolder(private var binding: ItemFoundVecanciesBinding) : RecyclerView.ViewHolder(binding.root)  {
        fun bind(doctorUi: DoctorUi) {
            doctorUi.photo?.let { binding.image.loadImage(it) }
            binding.name.text = doctorUi.full_name
            binding.tvExperience.text = doctorUi.experience.toString()
            binding.profession.text=doctorUi.specialties.toString()
            binding.tvClinic.text=doctorUi.clinic.toString()
            binding.rating.text =doctorUi.average_rating.toString()
            binding.recommendation.text =doctorUi.summary
            binding.tvPrice.text=doctorUi.price.toString()

            itemView.setOnClickListener {
                onClickListener(doctorUi)
            }
        }

    }

}