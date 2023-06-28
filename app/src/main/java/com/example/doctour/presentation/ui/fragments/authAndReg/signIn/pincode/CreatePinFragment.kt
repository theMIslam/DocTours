package com.example.doctour.presentation.ui.fragments.authAndReg.signIn.pincode

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCreatePinBinding
import com.example.doctour.presentation.ui.fragments.authAndReg.signIn.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CreatePinFragment : BaseFragment<FragmentCreatePinBinding, SignInViewModel>(
    R.layout.fragment_create_pin
        ){

    override val binding: FragmentCreatePinBinding by viewBinding(FragmentCreatePinBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()

    override fun initialize() {
        super.initialize()
        checking()
    }
    private fun checking() {
        if (binding.etOne.text.isNotEmpty()) {
            findNavController().navigate(R.id.successPasswordFragment)
        }
    }
}