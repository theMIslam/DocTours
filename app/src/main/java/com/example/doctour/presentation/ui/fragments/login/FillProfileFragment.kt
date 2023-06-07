package com.example.doctour.presentation.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentProfileFillBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FillProfileFragment : BaseFragment<FragmentProfileFillBinding,LoginViewModel>(
    R.layout.fragment_profile_fill
){
    override val binding: FragmentProfileFillBinding by viewBinding(FragmentProfileFillBinding::bind)
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()

    override fun initialize() {
        super.initialize()
        checking()
    }

    private fun checking() {
        //отправка данных на сервер
        if (binding.etFio.text.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.fio_), Toast.LENGTH_SHORT).show()
        }
    }
}