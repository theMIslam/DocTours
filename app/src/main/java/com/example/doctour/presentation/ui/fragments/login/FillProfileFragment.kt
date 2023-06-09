package com.example.doctour.presentation.ui.fragments.login

import android.widget.ArrayAdapter
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

    override fun initListeners() {
        super.initListeners()
        setDropDownMenu()
    }

    private fun setDropDownMenu() {
        val gender = arrayOf("Женский", "Мужской")
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.item_dropdown, gender)
        binding.actvGender.setAdapter(arrayAdapter)
    }

    private fun checking() {
        // TODO: отправка данных на сервер
        if (binding.etFio.text.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.fio_), Toast.LENGTH_SHORT).show()
        }
    }
}