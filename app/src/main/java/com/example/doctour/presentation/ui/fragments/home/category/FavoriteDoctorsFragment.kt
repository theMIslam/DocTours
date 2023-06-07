package com.example.doctour.presentation.ui.fragments.home.category


import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentFavoriteDoctorsBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDoctorsFragment : BaseFragment<FragmentFavoriteDoctorsBinding,CategoryViewModel>(
    R.layout.fragment_favorite_doctors
) {

    override val binding: FragmentFavoriteDoctorsBinding by viewBinding(FragmentFavoriteDoctorsBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()
}