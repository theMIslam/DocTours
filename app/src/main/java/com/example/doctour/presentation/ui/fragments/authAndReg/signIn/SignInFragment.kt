package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import android.annotation.SuppressLint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSignInBinding
import com.example.doctour.di.UserPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.google.i18n.phonenumbers.PhoneNumberUtil

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>(
    R.layout.fragment_sign_in
) {
    @Inject
    lateinit var userPreferences: UserPreferences

    override val binding: FragmentSignInBinding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    private var isPasswordVisible: Boolean = false

    override fun initListeners() {
        super.initListeners()
        passwordFocusListener()
        phoneNumberFocusListener()
        binding.btnLogIn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        binding.eye.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            togglePasswordVisibility()
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.eye.setImageResource(R.drawable.ic_close_eye)
        } else {
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.eye.setImageResource(R.drawable.layer_list_remove_eye)
        }
        binding.etPassword.text?.let { binding.etPassword.setSelection(it.length) }
    }

    @SuppressLint("SetTextI18n")
    private fun numberCode() {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        val defaultCountryNumber = phoneNumberUtil.getCountryCodeForRegion("KG")
        binding.etNumber.setText("+$defaultCountryNumber")
    }

    private fun phoneNumberFocusListener() {
        binding.etNumber.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.tilNumber.helperText=validPhoneNumber()
            }
        }
    }

    private fun validPhoneNumber(): String? {
        val phone = binding.etNumber.text.toString()
        if (!phone.matches(".*[0-9]*.".toRegex())){
            return "Должны быть цифры"
        }
        if (phone.length < 10){
            return  "Должно быть 10 цифр "
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.etPassword.setOnFocusChangeListener{ _,focused->
            if (!focused){
                binding.tilPassword.helperText=validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val password = binding.etPassword.text.toString()
        if (password.length < 8){
            return  "Минимальное количество символов 8"
        }
        if (!password.matches(".*[A-Z]*.".toRegex())){
            return "Должен содержать 1 символ верхнего регистра"
        }
        if (!password.matches(".*[a-z]*.".toRegex())){
            return "Должен содержать 1 символ нижнего регистра"
        }
        return null
    }

    override fun initSubscribers() {
        viewModel.signInState.spectateUiState (success = {
            userPreferences.isAuthenticated = true
            userPreferences.userID = it.id
            userPreferences.username = it.username
            userPreferences.password = binding.etPassword.text.toString()
            initListeners()
        }, error = {
            Toast.makeText(requireContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
        })
    }
}