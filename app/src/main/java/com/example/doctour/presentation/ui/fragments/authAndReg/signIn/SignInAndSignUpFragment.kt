package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentSignInAndSignUpBinding
import com.example.doctour.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SignInAndSignUpFragment : BaseFragment<FragmentSignInAndSignUpBinding, SignInViewModel>(
    R.layout.fragment_sign_in_and_sign_up
) {

    override val binding: FragmentSignInAndSignUpBinding by viewBinding(FragmentSignInAndSignUpBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()
    private lateinit var loginAdapter: SignInAdapter
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun initialize() {
        super.initialize()
        showTabs()
    }

    private fun showTabs() {
        loginAdapter= SignInAdapter(this)
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