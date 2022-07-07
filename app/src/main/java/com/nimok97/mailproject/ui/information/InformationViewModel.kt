package com.nimok97.mailproject.ui.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class InformationViewModel : ViewModel() {

    var nickName: String
    var email: String

    private val _isNickNameValid = MutableLiveData<Boolean>()
    val isNickNameValid: LiveData<Boolean> = _isNickNameValid
    private val _isEmailValid = MutableLiveData<Boolean>()
    val isEmailValid: LiveData<Boolean> = _isEmailValid
    private val _isNextPossible = MutableLiveData<Boolean>()
    val isNextPossible: LiveData<Boolean> = _isNextPossible

    init {
        nickName = ""
        email = ""
    }

    fun checkNickName(str: String) {
        // 4~12 자리면 유효
        nickName = str

        val nickNamePattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{4,12}$" // 영문, 숫자 + 4~12자리

        _isNickNameValid.value = Pattern.matches(nickNamePattern, nickName)
        checkIsNextPossible()
    }

    fun checkEmail(str: String) {
        // 이메일 형식 유효 검사 로직 추가하기
        email = str

        val pattern = android.util.Patterns.EMAIL_ADDRESS
        _isEmailValid.value = pattern.matcher(email).matches()

        checkIsNextPossible()
    }

    fun checkIsNextPossible() {
        _isNextPossible.value = _isNickNameValid.value == true && _isEmailValid.value == true
    }

}