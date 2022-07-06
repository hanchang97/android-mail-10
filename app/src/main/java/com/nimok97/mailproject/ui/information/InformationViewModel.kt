package com.nimok97.mailproject.ui.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformationViewModel : ViewModel() {

    lateinit var nickname: String
    lateinit var email: String

    private var isNickNameValid = false
    private var isEmailValid = false
    private val _isNextPossible = MutableLiveData<Boolean>(false)
    val isNextPossible: LiveData<Boolean> = _isNextPossible

    init {
        nickname = ""
        email = ""
    }

    fun checkNickName(str : String){
        // 4~12 자리면 유효
        isNickNameValid = str.length in 4..12
        checkIsNextPossible()
    }

    fun checkEmail(str: String){
        // 이메일 형식 유효 검사 로직 추가하기

        checkIsNextPossible()
    }

    fun checkIsNextPossible(){
        _isNextPossible.value = isNickNameValid && isEmailValid
    }

}