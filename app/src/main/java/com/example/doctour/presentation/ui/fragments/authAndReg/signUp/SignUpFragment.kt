package com.example.doctour.presentation.ui.fragments.authAndReg.signUp

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.data.viewmodels.UserRegisterVIewModel
import com.example.doctour.databinding.FragmentSignUpBinding
import com.example.doctour.di.UserPreferences
import com.example.doctour.presentation.extensions.hideKeyboard
import com.example.doctour.presentation.extensions.navigateSafely
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>(
    R.layout.fragment_sign_up
) {

    override val binding: FragmentSignUpBinding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels<SignUpViewModel>()

    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        super.initListeners()
        passwordFocusListener()
        passwordValidate()
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.verificationCodeFragment)
        }
        binding.btnSignUp.setOnClickListener {
            when {

                binding.etFullName.text.toString().isEmpty() ->
                    Toast.makeText(requireContext(), "Имя / Фамилия не должна быть пустой", Toast.LENGTH_LONG).show();


                binding.etNumber.text.toString().isEmpty() ->
                    Toast.makeText(requireContext(), "Электронная почта не должна быть пустой", Toast.LENGTH_LONG).show();

                binding.etRepeatPassword.text.toString() != binding.etPassword.text.toString() ->
                    Toast.makeText(requireContext(), "Повторный пароль не совпадает", Toast.LENGTH_LONG).show();

                binding.etPassword.text.toString().isEmpty() ->
                    Toast.makeText(requireContext(), "Пароль не может быть пустым", Toast.LENGTH_LONG).show();
                else -> {
                    hideKeyboard()
                    userPreferences.userNumber = binding.etNumber.text.toString()
                    viewModel.signUp(
                        binding.etFullName.text.toString(),
                        binding.etNumber.text.toString(),
                        binding.etPassword.text.toString(),
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
                tilRepeatPassword.error = "Подсказка:"
                false
            }

            etRepeatPassword.text.toString().trim().length < 8
                    || etRepeatPassword.text.toString().trim().length > 16 -> {
                tilRepeatPassword.error = "Пароль должен быть от 8 до 16 символов"
                false
            }

            etPassword.text.toString().trim() != etRepeatPassword.text.toString().trim() -> {
                tilRepeatPassword.error = " password dont match"
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
                binding.tilPassword.error = "Подсказка:"
                false
            }

            etPassword.text.toString().trim().length < 8
                    || etPassword.text.toString().trim().length > 16 -> {
                tilPassword.error = "Пароль должен быть от 8 до 16 символов"
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
            return "Минимальное количество символов 8"
        }
        if (!password.matches(".*[A-Z]*.".toRegex())) {
            return "Должен содержать 1 символ верхнего регистра"
        }
        if (!password.matches(".*[a-z]*.".toRegex())) {
            return "Должен содержать 1 символ нижнего регистра"
        }
        return null
    }

    fun initViewModel() {
        val viewModel = ViewModelProvider(this)[UserRegisterVIewModel::class.java]
    }

    override fun initSubscribers() {
        viewModel.signUpState.spectateUiState(success = {

            findNavController().navigateSafely(R.id.action_signUpFragment_to_signInFragment)
            Toast.makeText(requireContext(), "Вы успешно зарегистрировались вам придет письмо на номер", Toast.LENGTH_LONG).show();
        }, error = {
            Toast.makeText(requireContext(), "Что-то пошло не так", Toast.LENGTH_LONG).show();

            binding.etNumber.text!!.clear()
            binding.etPassword.text!!.clear()
            binding.etRepeatPassword.text!!.clear()
            binding.etFullName.text!!.clear()
        })
    }
}