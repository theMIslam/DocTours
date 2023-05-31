package com.example.doctour.presentation.ui.fragments.appoiment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.R
import com.example.doctour.core.extension.glide
import com.example.doctour.data.model.BermetModel
import com.example.doctour.databinding.ItemDoctorcardBinding

class CompletedBAdapter(
    private val btnScheduleClick:()->Unit,
    private val btnLeaveFeedbackClick:()->Unit
)
    :ListAdapter<BermetModel, CompletedBAdapter.CompletedViewHolder>
    (CompletedDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedViewHolder {
        return CompletedViewHolder(ItemDoctorcardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CompletedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CompletedViewHolder(private val binding:ItemDoctorcardBinding):RecyclerView.ViewHolder (binding.root){
        fun bind(item: BermetModel) {
            binding.tvTimeOfCancel.isVisible=false
            binding.image.glide(item.image)
            binding.tvName.text = item.name
            binding.tvDate.text=item.date
            binding.tvTime.text=item.time
            binding.tvPred.text = "Завершен"
            binding.tvPred.setTextColor(Color.GREEN)
            binding.tvPred.setBackgroundResource(R.color.green_back)
            binding.btnCancel.text = "Записаться"
            binding.btnReShedule.text="Оставить отзыв"

            binding.btnCancel.setOnClickListener {
                btnScheduleClick()
            }
            binding.btnReShedule.setOnClickListener {
                btnLeaveFeedbackClick()
            }
        }

    }
}
private class CompletedDiffUtil:DiffUtil.ItemCallback<BermetModel>(){
    override fun areItemsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
       return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem==newItem
    }
}