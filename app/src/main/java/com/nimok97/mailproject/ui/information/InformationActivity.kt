package com.nimok97.mailproject.ui.information

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.databinding.ActivityInformationBinding

class InformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding
    private val viewModel: InformationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information)

        PrintLog.printLog("$this / onCreate")

        initView()
        setEditText()
    }

    private fun initView() {
        binding.tietInformationNickname.setText(viewModel.nickname)
        binding.tietInformationEmail.setText(viewModel.email)
    }

    private fun setEditText(){
        binding.tilInformationNickname.editText?.doOnTextChanged { inputText, start, before, count ->
            PrintLog.printLog("$this / nickname input : ${inputText}")
            viewModel.checkNickName(inputText.toString())
        }

        binding.tilInformationEmail.editText?.doOnTextChanged { inputText, start, before, count ->
            viewModel.checkEmail(inputText.toString())
        }
    }

    // 생명주기 check
    override fun onStart() {
        super.onStart()
        PrintLog.printLog("$this / onStart")
    }

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

    override fun onDestroy() {
        super.onDestroy()
        PrintLog.printLog("$this / onDestroy")
    }
}