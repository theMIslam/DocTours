package com.example.doctour.presentation.ui.fragments.main.review.aboutDoctorReview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.base.BaseDiffUtilItemCallback
import com.example.doctour.databinding.ItemFeedbacksBinding
import com.example.doctour.presentation.model.ReviewUi

class AboutDoctorReviewAdapter
    : PagingDataAdapter<ReviewUi, AboutDoctorReviewAdapter.AboutDoctorViewHolder>(
    BaseDiffUtilItemCallback()
) {
    override fun onBindViewHolder(holder: AboutDoctorViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutDoctorViewHolder {
        return AboutDoctorViewHolder(
            ItemFeedbacksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class AboutDoctorViewHolder(
        private val binding: ItemFeedbacksBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(reviewUi: ReviewUi) {
       binding.tvName.text=reviewUi.doctor.toString()
            binding.tvStars.text=reviewUi.stars.toString()
            binding.tvFeedback.text=reviewUi.text.toString()
        }
    }
}