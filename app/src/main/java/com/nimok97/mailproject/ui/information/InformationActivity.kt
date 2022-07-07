package com.nimok97.mailproject.ui.information

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.data.model.Information
import com.nimok97.mailproject.databinding.ActivityInformationBinding
import com.nimok97.mailproject.ui.MainActivity

class InformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding
    private val viewModel: InformationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_information)

        PrintLog.printLog("$this / onCreate")

        val width = getScreenWidth(this)
        PrintLog.printLog("width / $width")

        initView()
        setEditText()
        observeData()
        setNextBtn()
    }

    fun getScreenWidth(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = wm.currentWindowMetrics
            val insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            windowMetrics.bounds.width() - insets.left - insets.right
        } else {
            val displayMetrics = DisplayMetrics()
            wm.defaultDisplay.getMetrics(displayMetrics)
            displayMetrics.widthPixels
        }
    }

    private fun initView() {
        binding.tietInformationNickname.setText(viewModel.nickName)
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

    private fun observeData(){
        viewModel.isNickNameValid.observe(this){
            if(it){
                binding.tilInformationNickname.error = null
            }
            else{
                binding.tilInformationNickname.error = getString(R.string.information_error_nickname)
            }
        }

        viewModel.isEmailValid.observe(this){
            if(it){
                binding.tilInformationEmail.error = null
            }
            else{
                binding.tilInformationEmail.error = getString(R.string.information_eror_email)
            }
        }

        viewModel.isNextPossible.observe(this){
            binding.btnInformationNext.isEnabled = it
        }
    }

    private fun setNextBtn(){ // finish 로도 가능
        binding.btnInformationNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("information", Information(viewModel.nickName, viewModel.email))
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
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