package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.doctour.presentation.ui.fragments.authAndReg.signUp.SignUpFragment

class SignInAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment =
        when(position){
            0->{
                SignInFragment()
            }

            1->{
                SignUpFragment()
            }
            else -> {
                throw Resources.NotFoundException("Position not found")
            }
        }
}