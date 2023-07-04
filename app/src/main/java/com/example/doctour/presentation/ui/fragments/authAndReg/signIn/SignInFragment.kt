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
        numberCode()
        passwordFocusListener()
        phoneNumberFocusListener()

        binding.btnLogIn.setOnClickListener {
            when{
                binding.etNumber.text.toString().isEmpty() ->{
                    showToast("Имя / Фамилия не должна быть пустой")
                }
                binding.etPassword.text.toString().isEmpty()->{
                    showToast("Пароль не может быть пустым")
                }
                else ->{
                        viewModel.logInUser(binding.etNumber.text.toString(),binding.etPassword.text.toString())
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
        viewModel.signIn.spectateUiState (success = {
            //userPreferences.accessToken = getAuthenticationToken(it.tokens, true)
           // userPreferences.refreshToken = getAuthenticationToken(it.tokens, true)
            userPreferences.isAuthenticated = true
           // userPreferences.userID = it.id
            //userPreferences.username = it.username
            userPreferences.userNumber = it.phone_number
            userPreferences.password = it.password
            findNavController().navigate(R.id.homeFragment)
           // activityNavController().navigateSafely(R.id.action_authAndRegFlowFragment_to_mainFlowFragment)
            showToast("Вы успешно зашли")
            initListeners()
        }, error = {
            showToast(getString(R.string.something_went_wrong))
            //Toast.makeText(requireContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
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