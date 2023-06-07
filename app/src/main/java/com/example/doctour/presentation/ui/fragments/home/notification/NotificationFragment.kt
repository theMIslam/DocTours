package com.example.doctour.presentation.ui.fragments.home.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentNotificationBinding
import com.example.doctour.presentation.base.BaseFragment
import com.example.doctour.presentation.ui.fragments.home.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding,HomeViewModel>(
    R.layout.fragment_notification
) {

    override val binding: FragmentNotificationBinding by viewBinding(FragmentNotificationBinding::bind)
    override val viewModel: HomeViewModel by viewModels<HomeViewModel>()
}