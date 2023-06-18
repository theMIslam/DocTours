package com.example.doctour.presentation.ui.fragments.main.notification

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.databinding.FragmentNotificationBinding
import com.example.doctour.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding, ViewModelNotification>(
    R.layout.fragment_notification
) {

    override val binding: FragmentNotificationBinding by viewBinding(FragmentNotificationBinding::bind)
    override val viewModel: ViewModelNotification by viewModels<ViewModelNotification>()
}