package com.example.doctour.presentation.ui.fragments.main.onboarding

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.base.BaseViewModel
import com.example.doctour.databinding.FragmentOnBoardPageBinding
import com.example.doctour.di.OnBoardingPreferences
import com.example.doctour.di.UserPreferences
import com.example.doctour.presentation.ui.fragments.main.onboarding.model.OnBoard

class OnBoardPageFragment (
    private var listenerSkip:() -> Unit,
    private var  listenerNext:() -> Unit
        ): BaseFragment<FragmentOnBoardPageBinding,BaseViewModel> (R.layout.fragment_on_board_page) {

    override val binding: FragmentOnBoardPageBinding by viewBinding(FragmentOnBoardPageBinding::bind)
    override val viewModel: BaseViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        getData()
        listeners()
    }

    private fun listeners() {
        binding.btnReady.setOnClickListener{
                findNavController().navigate(R.id.SignInAndSignUpFragment)
                OnBoardingPreferences(requireContext()).setOnBoarding(true)
            }
        binding.btnNext.setOnClickListener {
            listenerNext.invoke()
        }
        binding.btnSkip.setOnClickListener {
            listenerSkip.invoke()
        }
    }

    private fun getData() {
        arguments.let {
            val data = it?.getSerializable("keyOnBoarding") as OnBoard
            binding.text1.text=data.title
            binding.text2.text=data.desc
            data.image?.let { it1 -> binding.imageView.setImageResource(it1) }
            binding.btnSkip.isVisible = data.isLast == false
            binding.btnNext.isVisible= data.isLast ==false
            binding.btnReady.isVisible =data.isLast ==true
        }
    }
}