package com.example.doctour.presentation.ui.fragments.appoiment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.R
import com.example.doctour.databinding.ItemDoctorcardBinding
import com.example.doctour.presentation.ui.fragments.appoiment.model.BermetModel
import com.example.doctour.presentation.extensions.loadImage

class CancelledBAdapter: ListAdapter<BermetModel, CancelledBAdapter.CancelledBViewHolder>
    (CancelledBDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancelledBViewHolder {
        return CancelledBViewHolder(ItemDoctorcardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CancelledBViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

   inner class CancelledBViewHolder (private val binding: ItemDoctorcardBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bind(item: BermetModel) {
            binding.tvTimeOfCancel.isVisible=true
            binding.tvTimeOfCancel.text=item.timeOfCancel
            binding.image.loadImage(item.image)
            binding.tvName.text = item.name
            binding.tvDate.text=item.date
            binding.tvTime.text=item.time
            binding.tvPred.text = "Отменен"
            binding.tvPred.setTextColor(Color.RED)
            binding.tvPred.setBackgroundResource(R.color.red_back)
            binding.btnCancel.isVisible=false
            binding.btnReShedule.isVisible=false
        }

    }

}
private class CancelledBDifUtil:DiffUtil.ItemCallback<BermetModel>(){
    override fun areItemsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem==newItem
    }
}