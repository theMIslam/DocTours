package com.example.doctour.presentation.ui.fragments.main.password

import android.text.format.DateUtils
import androidx.core.view.isNotEmpty
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentVerificationCodeBinding
import com.example.doctour.presentation.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationCodeFragment :
    BaseFragment<FragmentVerificationCodeBinding, PasswordViewModel>(R.layout.fragment_verification_code) {

    override val binding: FragmentVerificationCodeBinding by viewBinding(FragmentVerificationCodeBinding::bind)
    override val viewModel: PasswordViewModel by viewModels()

    override fun initListeners() {
        super.initListeners()
        binding.btnSend.setOnClickListener {
            if (binding.smsView.isNotEmpty()) {
                findNavController().navigate(R.id.homeFragment)
            }
        }
    }

    override fun initSubscribers() {
        super.initSubscribers()
        countDownTimer()
    }

    private fun countDownTimer() {
        viewModel.currentTime.observe(viewLifecycleOwner) { long ->
            binding.tvTimeDown.text = DateUtils.formatElapsedTime(long)
        }
        viewModel.snackBar.observe(viewLifecycleOwner) { text ->
            showToast(text)
        }
    }
}