package com.nimok97.mailproject.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.data.Information
import com.nimok97.mailproject.databinding.ActivityMainBinding
import com.nimok97.mailproject.ui.mail.MailFragment
import com.nimok97.mailproject.ui.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private val mailFragment by lazy { MailFragment() }
    private val settingFragment by lazy { SettingFragment() }

    private lateinit var binding: ActivityMainBinding
    private  val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val information = intent.getSerializableExtra("information") as Information
        PrintLog.printLog("$this / onCreate, nickName : ${information.nickName}, email : ${information.email}")
        viewModel.information = information

        setBottomNavigationView()
        initView()
    }

    private fun initView(){
        changeFragment(mailFragment)
    }

    private fun setBottomNavigationView(){
        binding.bottomNavigationViewMain.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.fragment_mail -> {
                        changeFragment(mailFragment)
                    }
                    R.id.fragment_search -> {
                        changeFragment(settingFragment)
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
}