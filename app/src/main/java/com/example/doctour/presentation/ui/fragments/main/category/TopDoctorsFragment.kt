package com.example.doctour.presentation.ui.fragments.main.category

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentTopDoctorsBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TopDoctorsFragment : BaseFragment<FragmentTopDoctorsBinding, CategoryViewModel>(
    R.layout.fragment_top_doctors
) {

    override val binding: FragmentTopDoctorsBinding by viewBinding(FragmentTopDoctorsBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()
}