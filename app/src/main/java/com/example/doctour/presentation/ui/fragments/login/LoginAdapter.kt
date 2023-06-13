package com.example.doctour.presentation.ui.fragments.login

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LoginAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment =
        when(position){
            0->{
                LoginFragment()
            }

            1->{
                RegisterFragment()
            }
            else -> {
                throw Resources.NotFoundException("Position not found")
            }
        }
}