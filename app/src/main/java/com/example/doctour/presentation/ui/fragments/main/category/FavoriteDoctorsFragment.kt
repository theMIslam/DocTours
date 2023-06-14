package com.example.doctour.presentation.ui.fragments.main.category


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentFavoriteDoctorsBinding
import com.example.doctour.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDoctorsFragment : BaseFragment<FragmentFavoriteDoctorsBinding, CategoryViewModel>(
    R.layout.fragment_favorite_doctors
) {

    override val binding: FragmentFavoriteDoctorsBinding by viewBinding(FragmentFavoriteDoctorsBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()

    override fun initListeners() {
        super.initListeners()
        binding.imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}