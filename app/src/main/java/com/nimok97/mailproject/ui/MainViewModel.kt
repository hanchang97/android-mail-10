package com.nimok97.mailproject.ui

import androidx.lifecycle.ViewModel
import com.nimok97.mailproject.ui.util.BottomNavigaionFragmentType
import com.nimok97.mailproject.data.model.Information

class MainViewModel : ViewModel() {

    lateinit var information : Information
    var bottonNavigaionFragment : BottomNavigaionFragmentType

    init {
        bottonNavigaionFragment = BottomNavigaionFragmentType.MAIL
    }

    fun updateCurrentBottomNavigationFragmentType(currentTab: BottomNavigaionFragmentType){
        bottonNavigaionFragment = currentTab
    }

}