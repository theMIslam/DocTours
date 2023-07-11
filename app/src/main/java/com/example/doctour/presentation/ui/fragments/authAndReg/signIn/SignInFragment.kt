package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.data.model.UserLoginDt
import com.example.doctour.databinding.FragmentSignInBinding
import com.example.doctour.di.UserPreferences
import com.example.doctour.presentation.extensions.activityNavController
import com.example.doctour.presentation.extensions.navigateSafely
import com.example.doctour.presentation.extensions.showToast
import com.example.doctour.presentation.model.UserLoginUi
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

    override fun initListeners() {
        super.initListeners()
       // numberCode()
        passwordFocusListener()
        phoneNumberFocusListener()

        binding.btnLogIn.setOnClickListener {
            when {
                binding.etNumber.text.toString().isEmpty() -> {
                    showToast(getString(R.string.Field_must_not_be_empty))
                }

                binding.etPassword.text.toString().isEmpty() -> {
                    showToast(getString(R.string.Password_should_not_be_empty))
                }

                else -> {
                    viewModel.signIn(
                        phone_number = binding.etNumber.text.toString(),
                        password = binding.etPassword.text.toString()
                    )
//                        viewModel.logInUser(binding.etNumber.text.toString(),
//                            binding.etPassword.text.toString())
                }
            }
        }
        binding.tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun numberCode() {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        val defaultCountryNumber = phoneNumberUtil.getCountryCodeForRegion("KG")
        binding.etNumber.setText("+$defaultCountryNumber")
    }

    private fun phoneNumberFocusListener() {
        binding.etNumber.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilNumber.helperText = validPhoneNumber()
            }
        }
    }

    private fun validPhoneNumber(): String? {
        val phone = binding.etNumber.text.toString()
        if (!phone.matches(".*[0-9]*.".toRegex())) {
            return getString(R.string.Should_be_numbers)
        }
        if (phone.length < 10) {
            return getString(R.string.Should_be_10_dijits)
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.etPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tilPassword.helperText = validPassword()
            }
        }
    }


    private fun validPassword(): String? {
        val password = binding.etPassword.text.toString()
        if (password.length < 8) {
            return getString(R.string.Minimum_number_of_characters_8)
        }
        if (!password.matches(".*[A-Z]*.".toRegex())) {
            return getString(R.string.Should_contain_1_upper_case_character)
        }
        if (!password.matches(".*[a-z]*.".toRegex())) {
            return getString(R.string.Should_contain_1_lowercase_character)
        }
        return null
    }

    override fun initSubscribers() {
        viewModel.signIn.collectUiStateBema(
            onSuccess = {
                userPreferences.accessToken = getAuthenticationToken(it.access!!, true)
                userPreferences.refreshToken = getAuthenticationToken(it.refresh!!, true)
                userPreferences.isAuthenticated = true
                userPreferences.accessToken = it.access
                 userPreferences.refreshToken = it.refresh
                showToast(getString(R.string.You_successfully_logged_in))
                findNavController().navigate(R.id.homeFragment)
                initListeners()
            },
            onError = {

                showToast(it)
            })
    }

    private fun getAuthenticationToken(
        tokenString: String,
        shouldGetAccessToken: Boolean
    ) = when (shouldGetAccessToken) {
        true -> {
            val tokenMap = tokenString.substring(1, tokenString.length - 1)
                .split(", ")
                .map { it.split(": ") }
                .associate { (k, v) -> k to v }
            tokenMap["'access'"]?.removeSurrounding("'")
        }

        false -> {
            val tokenMap = tokenString.substring(1, tokenString.length - 1)
                .split(", ")
                .map { it.split(": ") }
                .associate { (k, v) -> k to v }
            tokenMap["'refresh'"]?.removeSurrounding("'")
        }
    }
}