package com.example.doctour.presentation.ui.fragments.main.password

import android.content.ContentValues.TAG
import android.text.format.DateUtils
import android.util.Log
import androidx.core.view.isEmpty
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentOTRCodeBinding
import com.example.doctour.preferences.UserPreferences
import com.example.doctour.presentation.extensions.showToast
import com.fraggjkee.smsconfirmationview.SmsConfirmationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OTRCodeFragment(

) : BaseFragment<FragmentOTRCodeBinding, PasswordViewModel>(
    R.layout.fragment_o_t_r_code
) {
    override val binding: FragmentOTRCodeBinding by viewBinding(FragmentOTRCodeBinding::bind)
    override val viewModel: PasswordViewModel by viewModels()
    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        super.initListeners()

            val view: SmsConfirmationView = binding.smsView

            view.onChangeListener = SmsConfirmationView.OnChangeListener { code, isComplete ->
                viewModel.code.observe(viewLifecycleOwner){
                    if (code == it){
                        viewModel.confirmUserCode()
                        userPreferences.setOTPKode(true)
                    }
                }
                viewModel.resetPasswordCodeToken(code=code)
            }

    }

    override fun initSubscribers() {
        super.initSubscribers()
        countDownTimer()

        viewModel.confirmUser.collectUiStateBema(
            onSuccess = {
                findNavController().navigate(R.id.newPasswordFragment)
            },
            onError = {
                showToast(getString(R.string.Something_went_wrong))
                Log.e(TAG , "Error ------- $it")
            }
        )
    }

    private fun countDownTimer() {
       viewModel.currentTime.observe(viewLifecycleOwner){long ->
           binding.tvTimeDown.text =DateUtils.formatElapsedTime(long)
       }
        viewModel.snackBar.observe(viewLifecycleOwner){text->
            if (binding.smsView.isEmpty()) {
                ///send code
                viewModel.searchUserAndCreateCode(binding.tvNumber.text.toString())
                showToast("Отправили еще 1 код")
            }
            showToast(text)
        }
    }
}