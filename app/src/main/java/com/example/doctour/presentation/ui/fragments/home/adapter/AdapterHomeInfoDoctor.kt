package com.example.doctour.presentation.ui.fragments.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.ItemDoctorsInfoBinding
import com.example.doctour.presentation.ui.fragments.OnClickListener
import com.example.doctour.presentation.ui.fragments.home.model.HomeModel
import com.example.doctour.presentation.ui.fragments.main.model.BermetModel

class AdapterHomeInfoDoctor(
    private val onClickListener: ()->Unit
) : androidx.recyclerview.widget.ListAdapter<BermetModel, AdapterHomeInfoDoctor.ViewHolderHomeInfoDoctor>(
    DFUtilCallBack){

    private val list: ArrayList<HomeModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeInfoDoctor {
        return ViewHolderHomeInfoDoctor(ItemDoctorsInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderHomeInfoDoctor, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderHomeInfoDoctor(private val binding: ItemDoctorsInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BermetModel?) {

        }

    }

}

object DFUtilCallBack : DiffUtil.ItemCallback<BermetModel>() {
    override fun areItemsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem == newItem
    }
}