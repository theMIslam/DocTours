package com.example.doctour.presentation.ui.fragments.appoiment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doctour.databinding.ItemDoctorcardBinding
import com.example.doctour.presentation.ui.fragments.appoiment.model.BermetModel
import com.example.doctour.utils.extensions.loadImage

class UpComingBAdapter (
    private val btnCancelClick :() ->Unit,
private val btnReSheduleClick:()->Unit): ListAdapter<BermetModel, UpComingBAdapter.UpComingViewHolder>
    (UpComingDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpComingViewHolder {
        return UpComingViewHolder(ItemDoctorcardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UpComingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UpComingViewHolder(private val binding: ItemDoctorcardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BermetModel) {
            binding.image.loadImage(item.image)
            binding.tvName.text=item.name
            binding.tvPred.text=item.pred
            binding.tvDate.text=item.date
            binding.tvTime.text=item.time
            binding.btnCancel.setOnClickListener {
                btnCancelClick()
            }
            binding.btnReShedule.setOnClickListener {
                btnReSheduleClick()
            }
        }
    }

}
private class UpComingDifUtil: DiffUtil.ItemCallback<BermetModel>() {
    override fun areItemsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: BermetModel, newItem: BermetModel): Boolean {
        return oldItem==newItem
    }
}