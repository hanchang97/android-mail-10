package com.nimok97.mailproject.ui.mail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.data.model.Mail
import com.nimok97.mailproject.data.model.MailType
import com.nimok97.mailproject.data.repository.MailDataSource
import com.nimok97.mailproject.data.repository.MailRepository
import com.nimok97.mailproject.ui.util.MailFragmentType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO - repository, datasource di
@HiltViewModel
class MailViewModel @Inject constructor(private val mailRepository: MailRepository) :
    ViewModel() {

    var mailTypeFragment: MailFragmentType

    private val _mailDataList = MutableLiveData<List<Mail>>()
    val mailDataList: LiveData<List<Mail>> = _mailDataList

    init {
        PrintLog.printLog("MailViewModel / init")
        mailTypeFragment = MailFragmentType.PRIMARY
    }

    fun updateCurrentMailType(currentMail: MailFragmentType) {
        mailTypeFragment = currentMail
    }

    override fun onCleared() {
        super.onCleared()
        PrintLog.printLog("MailViewModel / onCleared")
    }

    fun getMailData() {
        viewModelScope.launch {
            _mailDataList.value = mailRepository.getMailData()
        }
    }

    fun getFilteredMialData(mailType: MailType): List<Mail>? {
        val filteredMailList = _mailDataList.value?.let {
            it.filter { it.mailType == mailType }
        }

        // TODO - 날짜 최신순 정렬하기
        return filteredMailList
    }
}