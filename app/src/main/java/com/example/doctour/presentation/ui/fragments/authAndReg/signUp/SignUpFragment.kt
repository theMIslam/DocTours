package com.example.doctour.presentation.ui.fragments.authAndReg.signUp

import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSignUpBinding
import com.example.doctour.di.UserPreferences
import com.example.doctour.presentation.extensions.hideKeyboard
import com.example.doctour.presentation.extensions.showToast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>(
    R.layout.fragment_sign_up
) {

    override val binding: FragmentSignUpBinding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels()

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        super.initListeners()
        passwordFocusListener()
        passwordValidate()

        binding.btnSignUp.setOnClickListener {
            when {

                binding.etFullName.text.toString().isEmpty() ->
                    showToast(getString(R.string.Field_must_not_be_empty))

                binding.etNumber.text.toString().isEmpty() ->
                    showToast(getString(R.string.Field_must_not_be_empty))

                binding.etRepeatPassword.text.toString() != binding.etPassword.text.toString() ->
                    showToast(getString(R.string.Reset_password_does_not_math))

                binding.etPassword.text.toString().isEmpty() ->
                    showToast(getString(R.string.Password_should_not_be_empty))

                else -> {
                    hideKeyboard()
                    userPreferences.userNumber = binding.etNumber.text.toString()
                    viewModel.registerUser(
                        binding.etNumber.text.toString(),
                        binding.etFullName.text.toString(),
                        binding.etGender.text.toString(),
                        binding.etBirthday.text.toString(),
                        binding.etPassword.text.toString()
                    )
                }
            }
        }
    }

    private fun passwordValidate() {
        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                onValidate(binding.etPassword, binding.tilPassword)
            }
        })

        binding.etRepeatPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                onValidateRepeatPassword(
                    binding.etPassword,
                    binding.etRepeatPassword,
                    binding.tilRepeatPassword
                )
            }
        })


    }

    private fun onValidateRepeatPassword(
        etPassword: TextInputEditText,
        etRepeatPassword: TextInputEditText,
        tilRepeatPassword: TextInputLayout
    ): Boolean {
        return when {
            etRepeatPassword.text.toString().trim().isEmpty() -> {
                tilRepeatPassword.error = getString(R.string.Helper_text)
                false
            }

            etRepeatPassword.text.toString().trim().length < 8
                    || etRepeatPassword.text.toString().trim().length > 16 -> {
                tilRepeatPassword.error =
                    getString(R.string.Password_should_be_between_8_and_16_characters)
                false
            }

            etPassword.text.toString().trim() != etRepeatPassword.text.toString().trim() -> {
                tilRepeatPassword.error = getString(R.string.Password_does_not_match)
                false
            }

            else -> {
                tilRepeatPassword.error = null
                true
            }

        }
    }

    private fun onValidate(etPassword: TextInputEditText, tilPassword: TextInputLayout): Boolean {
        return when {
            etPassword.text.toString().trim().isEmpty() -> {
                binding.tilPassword.error = getString(R.string.Helper_text)
                false
            }

            etPassword.text.toString().trim().length < 8
                    || etPassword.text.toString().trim().length > 16 -> {
                tilPassword.error =
                    getString(R.string.Password_should_be_between_8_and_16_characters)
                false
            }

            else -> {
                tilPassword.error = null
                true
            }

        }
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
        viewModel.signUpState.spectateUiState(success = {
            findNavController().navigate(R.id.OTRCodeFragment)
            showToast(getString(R.string.You_have_successfully_registered_you_will_receive_a_letter_to_the_number))
        }, error = {
            showToast(getString(R.string.Something_went_wrong))

            binding.etNumber.text!!.clear()
            binding.etPassword.text!!.clear()
            binding.etRepeatPassword.text!!.clear()
            binding.etFullName.text!!.clear()
        })
    }
}