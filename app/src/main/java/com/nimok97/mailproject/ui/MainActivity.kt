package com.nimok97.mailproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.nimok97.mailproject.R
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentType
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.data.model.Information
import com.nimok97.mailproject.databinding.ActivityMainBinding
import com.nimok97.mailproject.ui.mail.MailFragment
import com.nimok97.mailproject.ui.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private val mailFragment by lazy { MailFragment() }
    private val settingFragment by lazy { SettingFragment() }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val information = intent.getSerializableExtra("information") as Information
        PrintLog.printLog("$this / onCreate, nickName : ${information.nickName}, email : ${information.email}")
        viewModel.information = information

        setBottomNavigationView()
        setNavigationRailView()
        initView()
    }

    private fun initView() { // 화면 회전 시 탭 선택 상태도 유지를 해줘야 한다
        when (viewModel.bottonNavigaionFragment) {
            BottomNavigationFragmentType.MAIL -> {
                changeFragment(mailFragment)
                binding.bottomNavigationViewMain?.menu?.getItem(0)?.isChecked = true
                binding.navigationRailViewMain?.menu?.getItem(0)?.isChecked = true
            }
            BottomNavigationFragmentType.SETTING -> {
                changeFragment(settingFragment)
                binding.bottomNavigationViewMain?.menu?.getItem(1)?.isChecked = true
                binding.navigationRailViewMain?.menu?.getItem(1)?.isChecked = true
            }
        }

//        changeFragment(mailFragment)

//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView_main, mailFragment)
//            .addToBackStack("Mail")
//            .commit()
    }

    private fun setBottomNavigationView() {
        binding.bottomNavigationViewMain?.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.fragment_mail -> {
                        clearBackStack()
                        changeFragment(mailFragment)
                    }
                    R.id.fragment_search -> {
                        //changeFragment(settingFragment)
                        //clearBackStack()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView_main, settingFragment, "Setting")
                            .addToBackStack("Setting")
                            .commit()
                    }
                }
                true
            }
        }
    }

    private fun setNavigationRailView(){
        binding.navigationRailViewMain?.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.fragment_mail -> {
                        clearBackStack()
                        changeFragment(mailFragment)
                    }
                    R.id.fragment_search -> {
                        //changeFragment(settingFragment)
                        //clearBackStack()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView_main, settingFragment, "Setting")
                            .addToBackStack("Setting")
                            .commit()
                    }
                }
                true
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView_main, fragment)
            .commit()
    }

    private fun clearBackStack() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onBackPressed() {
        binding.bottomNavigationViewMain?.let {
            if (binding.bottomNavigationViewMain?.selectedItemId == R.id.fragment_search) { // 현재 탭이 Setting
                binding.bottomNavigationViewMain?.selectedItemId = R.id.fragment_mail
            } else { // 현재 탭이 Mail
                mailFragment?.let {
                    PrintLog.printLog("${it.childFragmentManager.backStackEntryCount}")

                    if (it.childFragmentManager.backStackEntryCount >= 1) {
                        it.backToPrimary()
                    } else {
                        super.onBackPressed()
                    }
                }
            }
        }

        binding.navigationRailViewMain?.let {
            if (binding.navigationRailViewMain?.selectedItemId == R.id.fragment_search) { // 현재 탭이 Setting
                binding.navigationRailViewMain?.selectedItemId = R.id.fragment_mail
            } else { // 현재 탭이 Mail
                mailFragment?.let {
                    PrintLog.printLog("${it.childFragmentManager.backStackEntryCount}")

                    if (it.childFragmentManager.backStackEntryCount >= 1) {
                        it.backToPrimary()
                    } else {
                        super.onBackPressed()
                    }
                }
            }
        }

        // super.onBackPressed()
    }

    //

    override fun onResume() {
        super.onResume()
        PrintLog.printLog("$this / onResume")
    }

    override fun onPause() {
        super.onPause()
        PrintLog.printLog("$this / onPause")
    }

    override fun onStop() {
        super.onStop()
        PrintLog.printLog("$this / onStop")
    }
}