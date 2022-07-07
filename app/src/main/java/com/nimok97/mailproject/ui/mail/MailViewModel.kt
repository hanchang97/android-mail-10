package com.nimok97.mailproject.ui.mail

import androidx.lifecycle.ViewModel
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.ui.util.MailFragmentType

class MailViewModel : ViewModel() {
    var mailTypeFragment : MailFragmentType

    init {
        PrintLog.printLog("MailViewModel / init")
        mailTypeFragment = MailFragmentType.PRIMARY
    }

    fun updateCurrentMailType(currentMail: MailFragmentType){
        mailTypeFragment = currentMail
    }

    override fun onCleared() {
        super.onCleared()
        PrintLog.printLog("MailViewModel / onCleared")
    }
}