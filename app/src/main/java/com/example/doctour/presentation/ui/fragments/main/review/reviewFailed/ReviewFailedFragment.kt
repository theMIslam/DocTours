package com.example.doctour.presentation.ui.fragments.main.review.reviewFailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctour.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ReviewFailedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_failed, container, false)
    }

}