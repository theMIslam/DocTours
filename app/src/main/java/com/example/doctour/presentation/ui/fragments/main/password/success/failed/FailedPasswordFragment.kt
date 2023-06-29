package com.example.doctour.presentation.ui.fragments.main.password.success.failed

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentFailedPasswordBinding
import com.example.doctour.presentation.ui.fragments.main.password.PasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FailedPasswordFragment : BaseFragment<FragmentFailedPasswordBinding, PasswordViewModel>(
    R.layout.fragment_failed_password
) {
    override val binding: FragmentFailedPasswordBinding by viewBinding(FragmentFailedPasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels<PasswordViewModel>()
}