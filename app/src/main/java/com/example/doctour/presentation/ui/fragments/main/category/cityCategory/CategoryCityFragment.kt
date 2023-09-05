package com.example.doctour.presentation.ui.fragments.main.category.cityCategory

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentCategoryCityBinding
import com.example.doctour.presentation.ui.fragments.main.category.category.CategoryViewModel
import com.example.doctour.presentation.ui.fragments.main.category.observer.DataChangeListener
import com.example.doctour.presentation.ui.fragments.main.category.observer.TextUpdate
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus

@AndroidEntryPoint
class CategoryCityFragment: BaseFragment<FragmentCategoryCityBinding, CategoryViewModel>(
    R.layout.fragment_category_city
) {
    private var dataChangeListener: DataChangeListener? = null
    override val binding: FragmentCategoryCityBinding by viewBinding(FragmentCategoryCityBinding::bind)
    override val viewModel: CategoryViewModel by viewModels<CategoryViewModel>()


    override fun initListeners() {
        super.initListeners()
        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvBishkek.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvOsh.setOnClickListener {
            EventBus.getDefault().post(TextUpdate(getString(R.string.osh)))
            findNavController().navigateUp()
        }
    }

}