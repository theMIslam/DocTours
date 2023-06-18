package com.example.doctour.presentation.ui.fragments.authAndReg.signUp

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentSignUpBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.authAndReg.signIn.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>(
    R.layout.fragment_sign_up
) {

    override val binding: FragmentSignUpBinding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels<SignUpViewModel>()

}