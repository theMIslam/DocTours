package com.example.doctour.presentation.ui.fragments.splash

import android.annotation.SuppressLint
import android.os.Handler
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentSplashScreenBinding
import com.example.doctour.di.UserPreferences
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.extensions.navigateSafely
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment :
    BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>(R.layout.fragment_splash_screen) {

    override val binding: FragmentSplashScreenBinding by viewBinding(FragmentSplashScreenBinding::bind)
    override val viewModel by viewModels<SplashScreenViewModel>()
    @Inject
    lateinit var userPreferences: UserPreferences
    override fun initialize() {
        Handler().postDelayed({
            findNavController().navigate(R.id.homeFragment2)
        }, 2000)

        when{
            userPreferences.isAuthenticated ->{
               // findNavController().navigateSafely(R.id.action_splashScreenFragment_to_onBoarding)
            }
            !userPreferences.isAuthenticated ->{
               // findNavController().navigateSafely(R.id.action_onBoarding_to_fragment_login)
            }
        }
    }
    }