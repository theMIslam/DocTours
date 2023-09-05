package com.example.doctour.presentation.ui.fragments.main.password.newPassword

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentNewPasswordBinding
import com.example.doctour.presentation.ui.fragments.main.password.passwordViewmodel.PasswordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class NewPasswordFragment : BaseFragment<FragmentNewPasswordBinding, PasswordViewModel>(
    R.layout.fragment_new_password
) {

    override val binding: FragmentNewPasswordBinding by viewBinding(FragmentNewPasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels()
    override fun initListeners() {
        super.initListeners()
        onClick()
    }
    private fun onClick() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.signInFragment)
        }
        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}