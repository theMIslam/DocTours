package com.example.doctour.ui.fragments.splash

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.core.base.BaseFragment
import com.example.doctour.core.extension.navigateSafely
import com.example.doctour.data.local.pref.UserPreferences
import com.example.doctour.databinding.FragmentSplashScreenBinding
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
        transparentStatusBar()

        val avd = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.icon)
        binding.logoAnim.setImageDrawable(avd)
        binding.logoAnim.animate()
            .alpha(1f)
            .setDuration(2000L)
            .withEndAction {
                when {
                    userPreferences.isAuthenticated -> {
                        findNavController().navigateSafely(R.id.action_splashScreenFragment_to_homeFragment2)
                    }
                    !userPreferences.isAuthenticated -> {
                        findNavController().navigateSafely(R.id.action_splashScreenFragment_to_homeFragment2)
                    }
                }
            }
            .start()
        //avd?.start()
    }

    private fun transparentStatusBar() {
        activity?.window?.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
    }
}