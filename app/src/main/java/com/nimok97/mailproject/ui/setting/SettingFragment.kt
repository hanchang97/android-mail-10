package com.nimok97.mailproject.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.BottomNavigaionFragment
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.common.SaveBottomNavigationTab
import com.nimok97.mailproject.databinding.FragmentMailBinding
import com.nimok97.mailproject.databinding.FragmentSettingBinding
import com.nimok97.mailproject.ui.MainViewModel

class SettingFragment : Fragment(), SaveBottomNavigationTab {

    private lateinit var binding : FragmentSettingBinding
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrintLog.printLog("$this / onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PrintLog.printLog("$this / onViewCreated")

        updateCurrentTab()


    }

    override fun updateCurrentTab() {
        viewModel.updateCurrentTab(BottomNavigaionFragment.SETTING)
    }
}