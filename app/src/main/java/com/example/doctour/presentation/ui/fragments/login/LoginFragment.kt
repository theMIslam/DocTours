package com.example.doctour.presentation.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentLoginBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class LoginFragment : BaseFragment<FragmentLoginBinding,LoginViewModel>(
    R.layout.fragment_login
){

    override val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()

}