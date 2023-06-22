package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentSignInBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>(
    R.layout.fragment_sign_in
){

    override val binding: FragmentSignInBinding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()

}