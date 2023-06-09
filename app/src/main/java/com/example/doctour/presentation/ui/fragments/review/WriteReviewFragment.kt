package com.example.doctour.presentation.ui.fragments.review

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentWriteReviewBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class WriteReviewFragment : BaseFragment<FragmentWriteReviewBinding,ReviewViewModel>(
    R.layout.fragment_write_review
) {

    override val binding: FragmentWriteReviewBinding by viewBinding(FragmentWriteReviewBinding::bind)
    override val viewModel: ReviewViewModel by viewModels<ReviewViewModel>()


    override fun initListeners() {
        super.initListeners()
        clickers()
    }

    private fun clickers() {
        if (binding.etYourReview.text.isEmpty()) {
            // TODO: Toast.makeText(this@WriteReviewFragment, getString(R.string.write_your_review_toast), Toast.LENGTH_SHORT).show()
        }
    }
}