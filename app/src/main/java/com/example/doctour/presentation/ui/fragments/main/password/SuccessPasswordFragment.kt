package com.example.doctour.presentation.ui.fragments.main.password

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSuccessPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class SuccessPasswordFragment : BaseFragment<FragmentSuccessPasswordBinding, PasswordViewModel>(
    R.layout.fragment_success_password
){
    override val binding: FragmentSuccessPasswordBinding by viewBinding(FragmentSuccessPasswordBinding::bind)
    override val viewModel: PasswordViewModel by viewModels<PasswordViewModel>()

    override fun initListeners() {
        super.initListeners()
        clickers()
    }

    private fun clickers() {
        binding.btnDone.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}