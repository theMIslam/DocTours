package com.example.doctour.presentation.ui.fragments.authAndReg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doctour.base.BaseViewModel
import com.example.doctour.data.remote.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TokenViewModel @Inject constructor(
private val tokenManager: TokenManager
) :ViewModel(){

    private val _token = MutableLiveData<String?>()
    val token :LiveData< String? > =_token

    init {
        viewModelScope.launch ( Dispatchers.IO){
            tokenManager.getToken().collect{
                withContext(Dispatchers.Main){
                    _token.value = it
                }
            }
        }
    }

    fun saveToken(token:String){
        viewModelScope.launch(Dispatchers.IO){
            tokenManager.saveToken(token)
        }
    }
    fun deleteToken(){
        viewModelScope.launch(Dispatchers.IO){
            tokenManager.deleteToken()
        }
    }
}