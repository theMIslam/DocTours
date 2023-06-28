package com.example.doctour.presentation.ui.fragments.main.profile

import android.content.Context
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentProfileFillBinding
import com.example.doctour.di.ProfilePreferences
import com.example.doctour.presentation.ui.fragments.authAndReg.signIn.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class FillProfileFragment : BaseFragment<FragmentProfileFillBinding, SignInViewModel>(
    R.layout.fragment_profile_fill
){
    override val binding: FragmentProfileFillBinding by viewBinding(FragmentProfileFillBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()
    @Inject
    lateinit var profilePreferences: ProfilePreferences

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
        binding.btnSave.setOnClickListener {
          //  profilePreferences.saveName(binding.etFio.text.toString())
            profilePreferences.savePhone(binding.etNumber.text.toString())
            profilePreferences.saveBirthday(binding.etData.text.toString())
            profilePreferences.saveGender(binding.actvGender.text.toString())

            putSharedData()
        }
        binding.etNumber.setText(profilePreferences.getPhone())
        binding.etData.setText(profilePreferences.getBirthday())
        binding.actvGender.setText(profilePreferences.getGender())
    }

    private fun putSharedData() {
        val shared = activity?.getSharedPreferences("preferences_profile",Context.MODE_PRIVATE)
        val nicdata = binding.etFio.text.toString()
        val editor =  shared?.edit()
        editor?.putString("fio",nicdata)
        editor?.apply()
        editor?.commit()
    }

    private fun setDropDownMenu() {
        val gender = arrayOf("Женский", "Мужской")
        val arrayAdapter = ArrayAdapter(requireActivity(), R.layout.item_dropdown, gender)
        binding.actvGender.setAdapter(arrayAdapter)
    }

    private fun checking() {
        binding.etNumber.setText(profilePreferences.getPhone())
    }
}