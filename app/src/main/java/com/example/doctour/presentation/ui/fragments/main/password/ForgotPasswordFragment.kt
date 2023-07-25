package com.example.doctour.presentation.ui.fragments.main.password

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentForgotPasswordBinding
import com.example.doctour.presentation.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment() : BaseFragment<FragmentForgotPasswordBinding, PasswordViewModel>(
    R.layout.fragment_forgot_password
) {
    override val binding: FragmentForgotPasswordBinding by viewBinding(FragmentForgotPasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels()

    override fun initSubscribers() {
        super.initSubscribers()
        viewModel.sacCode.collectUiStateBema(
            onSuccess = {
                binding.tvNumber.text = it.phone_number
                viewModel.searchUserAndCreateCode(it.phone_number)
            },
            onError = {
                showToast(it)
            }
        )
    }

    override fun initListeners() {
        super.initListeners()
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.OTRCodeFragment)
        }
    }
}