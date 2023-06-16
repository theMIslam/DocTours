package com.example.doctour.presentation.ui.fragments.main.profile

import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentProfileFillBinding
import com.example.doctour.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.authAndReg.signIn.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class FillProfileFragment : BaseFragment<FragmentProfileFillBinding, SignInViewModel>(
    R.layout.fragment_profile_fill
){
    override val binding: FragmentProfileFillBinding by viewBinding(FragmentProfileFillBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()

    override fun initialize() {
        super.initialize()
        checking()
    }

    override fun initListeners() {
        super.initListeners()
        binding.tvArrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        setDropDownMenu()
    }

    private fun setDropDownMenu() {
        val gender = arrayOf("Женский", "Мужской")
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.item_dropdown, gender)
        binding.actvGender.setAdapter(arrayAdapter)
    }

    private fun checking() {
        // TODO: отправка данных на сервер
        if (binding.etFio.text!!.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.fio_), Toast.LENGTH_SHORT).show()
        }
    }
}