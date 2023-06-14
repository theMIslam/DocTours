package com.example.doctour.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentLoginAndSignUpBinding
import com.example.doctour.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoginAndSignUpFragment :BaseFragment<FragmentLoginAndSignUpBinding,LoginViewModel>(
    R.layout.fragment_login_and_sign_up
) {

    override val binding: FragmentLoginAndSignUpBinding by viewBinding(FragmentLoginAndSignUpBinding::bind)
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()
    private lateinit var loginAdapter: LoginAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun initialize() {
        super.initialize()
        showTabs()
    }

    private fun showTabs() {
        loginAdapter= LoginAdapter(this)
        viewPager2 = binding.viewpager2
        viewPager2.adapter = loginAdapter
        tabLayout = binding.tabLayout
        val tabNames = arrayListOf(
            getString(R.string.Login),
            getString(R.string.Registration)
        )
        TabLayoutMediator(tabLayout, viewPager2) { tab, pos ->
            tab.text = tabNames[pos]
        }.attach()
    }
}