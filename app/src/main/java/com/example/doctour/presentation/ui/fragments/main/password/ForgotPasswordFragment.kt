package com.example.doctour.presentation.ui.fragments.main.password

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentForgotPasswordBinding
import com.example.doctour.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment() : BaseFragment<FragmentForgotPasswordBinding, PasswordViewModel>(
    R.layout.fragment_forgot_password
) {
    override val binding: FragmentForgotPasswordBinding by viewBinding(FragmentForgotPasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels<PasswordViewModel>()
}