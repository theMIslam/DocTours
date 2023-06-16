package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemFeedbacksBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.ui.fragments.main.model.BermetFeedback

class AdapterFeedbacks: RecyclerView.Adapter<AdapterFeedbacks.FeedBacksViewHolder>(){

    private var list :ArrayList<BermetFeedback> = ArrayList()

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
        fun bind(bermetFeedbacks: BermetFeedback) {
            binding.ivImage.loadImage(bermetFeedbacks.image)
            binding.tvName.text=bermetFeedbacks.name
            binding.tvFeedback.text=bermetFeedbacks.feedback
        }

    }


}