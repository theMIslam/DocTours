package com.example.doctour.presentation.ui.fragments.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.doctour.databinding.ItemOnboardingBinding
import com.example.doctour.presentation.extensions.loadImage
import com.example.doctour.presentation.ui.fragments.onboarding.model.OnBoard

class OnBoardingAdapter : Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            "Найдите себе лучших врачей в вашем городе",
            "С помощью нашего мобильного приложение, Вы можете с легкостью найти лучших врачей",
            "istock_000020150008medium-1025x1536-removebg-preview.png"
        ),
        OnBoard(
            "Записывайтесь на прием \n" +
                    "к опытным врачам",
            "Найдите опытных врачей специалистов и запишитесь на прием\n",
            "happy-doctors-working-together-with-tablet-and-cli-JKNCATD-960x750-removebg-preview.png"
        ),
        OnBoard(
            "Найдите себе лучших врачей в вашем городе",
            "С помощью нашего мобильного приложение, Вы можете с легкостью найти лучших врачей",
            "78b630d7a0cb6fac09f21e1ac850c8cb-removebg-preview.png"
        )

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.text1.text = onBoard.title
            binding.text2.text = onBoard.desc
            binding.imageView.loadImage(onBoard.image.toString())
        }

    }
}