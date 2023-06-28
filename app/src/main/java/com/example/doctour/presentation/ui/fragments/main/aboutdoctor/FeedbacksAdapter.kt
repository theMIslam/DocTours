package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import androidx.recyclerview.widget.DiffUtil
import com.example.doctour.presentation.model.ReviewUi

class DFUtilFeedback:DiffUtil.ItemCallback<ReviewUi> (){
    override fun areItemsTheSame(oldItem: ReviewUi, newItem: ReviewUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ReviewUi, newItem: ReviewUi): Boolean {
        return oldItem==newItem
    }
}