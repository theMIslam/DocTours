package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

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

@AndroidEntryPoint

class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>(
    R.layout.fragment_sign_in
) {
    @Inject
    lateinit var userPreferences: UserPreferences

    override val binding: FragmentSignInBinding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels<SignInViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.btnLogIn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
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