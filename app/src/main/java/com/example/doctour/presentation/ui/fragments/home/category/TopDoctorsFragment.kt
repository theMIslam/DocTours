package com.example.doctour.presentation.ui.fragments.home.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doctour.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TopDoctorsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_doctors, container, false)
    }

}