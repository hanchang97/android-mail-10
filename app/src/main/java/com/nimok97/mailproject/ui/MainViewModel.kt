package com.nimok97.mailproject.ui

import androidx.lifecycle.ViewModel
import com.nimok97.mailproject.common.BottomNavigaionFragment
import com.nimok97.mailproject.data.Information

class MainViewModel : ViewModel() {

    lateinit var information : Information
    var bottonNavigaionFragment : BottomNavigaionFragment

    init {
        bottonNavigaionFragment = BottomNavigaionFragment.MAIL
    }

    fun updateCurrentTab(currentTab: BottomNavigaionFragment){
        bottonNavigaionFragment = currentTab
    }

}