package com.example.doctour.presentation.ui.fragments.appoiment

import androidx.recyclerview.widget.DiffUtil
import com.example.doctour.presentation.ui.fragments.appoiment.model.BermetModel

private class CancelledBDifUtil:DiffUtil.ItemCallback<BermetModel>(){
    override fun areItemsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem==newItem
    }
}