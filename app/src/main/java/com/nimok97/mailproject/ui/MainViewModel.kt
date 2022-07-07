package com.nimok97.mailproject.ui

import androidx.lifecycle.ViewModel
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentType
import com.nimok97.mailproject.data.model.Information

class MainViewModel : ViewModel() {

    lateinit var information : Information
    var bottonNavigaionFragment : BottomNavigationFragmentType

    init {
        bottonNavigaionFragment = BottomNavigationFragmentType.MAIL
    }

    fun updateCurrentBottomNavigationFragmentType(currentTab: BottomNavigationFragmentType){
        bottonNavigaionFragment = currentTab
    }

}