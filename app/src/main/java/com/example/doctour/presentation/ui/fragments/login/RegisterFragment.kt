package com.example.doctour.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentRegisterBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RegisterFragment : BaseFragment<FragmentRegisterBinding,LoginViewModel>(
    R.layout.fragment_register
) {

    override val binding: FragmentRegisterBinding by viewBinding(FragmentRegisterBinding::bind)
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()

}