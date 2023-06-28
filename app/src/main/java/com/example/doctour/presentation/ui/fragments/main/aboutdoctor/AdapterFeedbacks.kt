package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemFeedbacksBinding
import com.example.doctour.model.ReviewUi

class AdapterFeedbacks: ListAdapter<ReviewUi,AdapterFeedbacks.FeedBacksViewHolder>(
    DFUtilFeedback()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedBacksViewHolder {
        return FeedBacksViewHolder(ItemFeedbacksBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FeedBacksViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FeedBacksViewHolder (private var binding: ItemFeedbacksBinding):RecyclerView.ViewHolder (binding.root)  {
        fun bind(reviewUi: ReviewUi) {
            binding.tvName.text=reviewUi.doctor.toString()
            binding.tvFeedback.text=reviewUi.text
            binding.tvStars.text=reviewUi.stars.toString()
        }

    }
}
private class DFUtilFeedback:DiffUtil.ItemCallback<ReviewUi> (){
    override fun areItemsTheSame(oldItem: ReviewUi, newItem: ReviewUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ReviewUi, newItem: ReviewUi): Boolean {
        return oldItem==newItem
    }
}