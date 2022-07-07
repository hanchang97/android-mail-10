package com.nimok97.mailproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.BottomNavigaionFragment
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.data.Information
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
        initView()
    }

    private fun initView() {
        when(viewModel.bottonNavigaionFragment){
            BottomNavigaionFragment.MAIL -> changeFragment(mailFragment)
            BottomNavigaionFragment.SETTING -> changeFragment(settingFragment)
        }

//        changeFragment(mailFragment)

//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView_main, mailFragment)
//            .addToBackStack("Mail")
//            .commit()
    }

    private fun setBottomNavigationView() {
        binding.bottomNavigationViewMain.run {
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
        if (binding.bottomNavigationViewMain.selectedItemId == R.id.fragment_search) {
            binding.bottomNavigationViewMain.selectedItemId = R.id.fragment_mail
        } else {
            super.onBackPressed()
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