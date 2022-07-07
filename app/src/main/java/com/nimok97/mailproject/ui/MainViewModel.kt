package com.nimok97.mailproject.ui

import androidx.lifecycle.ViewModel
import com.nimok97.mailproject.data.model.Information
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    lateinit var information : Information
    var bottonNavigaionFragment : BottomNavigationFragmentType

    init {
        bottonNavigaionFragment = BottomNavigationFragmentType.MAIL
    }

    fun updateCurrentBottomNavigationFragmentType(currentTab: BottomNavigationFragmentType){
        bottonNavigaionFragment = currentTab
    }

}