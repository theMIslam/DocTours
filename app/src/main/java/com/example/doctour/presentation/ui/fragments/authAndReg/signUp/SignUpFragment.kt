package com.example.doctour.presentation.ui.fragments.authAndReg.signUp

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentSignUpBinding
import com.example.doctour.preferences.UserPreferences
import com.example.doctour.presentation.module.hideKeyboard
import com.example.doctour.presentation.module.showToast
import com.example.doctour.presentation.ui.fragments.authAndReg.TokenViewModel
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
    private val tokenViewModel: TokenViewModel by activityViewModels()

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

            etRepeatPassword.text.toString().trim().length < 4
                    || etRepeatPassword.text.toString().trim().length > 10 -> {
                tilRepeatPassword.error =
                    getString(R.string.Password_should_be_between_4_and_10_characters)
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

            etPassword.text.toString().trim().length < 4
                    || etPassword.text.toString().trim().length > 10 -> {
                tilPassword.error =
                    getString(R.string.Password_should_be_between_4_and_10_characters)
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
        if (password.length < 4) {
            return getString(R.string.Minimum_number_of_characters_4)
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

        tokenViewModel.token.observe(viewLifecycleOwner) { token ->
            if (token != null) {
                findNavController().navigate(R.id.homeFragment)
            }else{
                showToast("Token is null")
            }
        }

        viewModel.tokenRefresh.collectUiStateBema(
            onSuccess = {
                tokenViewModel.saveToken(it.refresh)
                showToast(getString(R.string.You_successfully_logged_in))
            },
            onError = {
                showToast(it)
                Log.e("TAG", it)
            }
        )

        viewModel.signUpState.spectateUiState(
            success = {
                findNavController().navigate(R.id.homeFragment)
                //showToast(getString(R.string.You_have_successfully_registered_you_will_receive_a_letter_to_the_number))
            showToast("Вы успешно зарегистрировались")
                      }, error = {
                showToast(it)
                // showToast(getString(R.string.Something_went_wrong))
                binding.etNumber.text!!.clear()
                binding.etPassword.text!!.clear()
                binding.etRepeatPassword.text!!.clear()
                binding.etFullName.text!!.clear()
            })
    }
}