package com.example.doctour.presentation.ui.fragments.password

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentNewPasswordBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class NewPasswordFragment : BaseFragment <FragmentNewPasswordBinding,PasswordViewModel>(
    R.layout.fragment_new_password
        ) {

    override val binding: FragmentNewPasswordBinding by viewBinding(FragmentNewPasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels<PasswordViewModel>()
    override fun initListeners() {
        super.initListeners()
        onClick()
    }
    private fun onClick() {
        binding.btnNext.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}