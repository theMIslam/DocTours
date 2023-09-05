package com.example.doctour.presentation.ui.adapter.onBoarding

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.doctour.R
import com.example.doctour.presentation.ui.fragments.main.onboarding.OnBoardPageFragment
import com.example.doctour.presentation.ui.fragments.main.onboarding.model.OnBoard

class AdapterBoardingFragment(
    fm: Fragment,
    private var listenerSkip: () -> Unit,
    private var listenerNext: () -> Unit
) : FragmentStateAdapter(fm) {

    private val listOfBoarding = arrayListOf(
        OnBoard(
            "Найдите себе лучших врачей в вашем городе",
            "С помощью нашего мобильного приложение, Вы можете с легкостью найти лучших врачей",
            R.drawable.istock_1,
            false
        ),
        OnBoard(
            "Записывайтесь на прием \n" +
                    "к опытным врачам",
            "Найдите опытных врачей специалистов и запишитесь на прием\n",
            R.drawable.happy_doctors1,
            false
        ),
        OnBoard(
            "Найдите себе лучших врачей в вашем городе",
            "С помощью нашего мобильного приложение, Вы можете с легкостью найти лучших врачей",
            R.drawable.nurse1,
            true
        )

    )

    override fun getItemCount(): Int {
         return listOfBoarding.size
    }

    override fun createFragment(position: Int): Fragment {
        val  data  = bundleOf("keyOnBoarding" to listOfBoarding[position])
        val fragment= OnBoardPageFragment(listenerSkip,listenerNext)
        fragment.arguments=data
        return fragment
    }
}