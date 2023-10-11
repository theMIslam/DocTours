package com.example.doctour.presentation.ui.fragments.splash

import android.annotation.SuppressLint
import android.os.Handler
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSplashScreenBinding
import com.example.doctour.preferences.OnBoardingPreferences
import com.example.doctour.preferences.UserPreferences
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment :
    BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>(R.layout.fragment_splash_screen) {

    override val binding: FragmentSplashScreenBinding by viewBinding(FragmentSplashScreenBinding::bind)
    override val viewModel by viewModels<SplashScreenViewModel>()

    override fun initialize() {
        Handler().postDelayed({

            if (!OnBoardingPreferences(requireContext()).isShowOnBoarding()) {
                findNavController().navigate(R.id.onBoardingFragment)
            } else if (!UserPreferences(requireContext()).isOtpCodeRight()) {
                findNavController().navigate(R.id.SignInAndSignUpFragment)
            } else {
                findNavController().navigate(R.id.homeFragment)
            }
        }, 2000)

    }
}