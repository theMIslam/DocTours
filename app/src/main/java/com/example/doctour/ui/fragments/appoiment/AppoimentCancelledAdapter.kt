package com.example.doctour.ui.fragments.appoiment

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AppoimentCancelledAdapter(fragment:Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment =
        when(position){
            0->{
                AppoimentUpcomingBFragment()
            }

            1->{
                AppoimentCompletedBFragment()
            }

            2->{
                AppoimentCancelledBFragment()
            }
            else -> {
                throw Resources.NotFoundException("Position not found")
            }
        }
}
