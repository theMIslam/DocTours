package com.example.doctour.presentation.ui.fragments.aboutdoctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemFeedbacksBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.ui.fragments.appoiment.model.BermetFeedbacks

class AdapterFeedbacks: RecyclerView.Adapter< AdapterFeedbacks.FeedBacksViewHolder>(){

    private var list :ArrayList<BermetFeedbacks> =ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedBacksViewHolder {
        return FeedBacksViewHolder(ItemFeedbacksBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FeedBacksViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FeedBacksViewHolder (private var binding: ItemFeedbacksBinding):RecyclerView.ViewHolder (binding.root)  {
        fun bind(bermetFeedbacks: BermetFeedbacks) {
            binding.ivImage.loadImage(bermetFeedbacks.image)
            binding.tvName.text=bermetFeedbacks.name
            binding.tvFeedback.text=bermetFeedbacks.feedback
        }

    }


}