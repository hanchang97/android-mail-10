package com.nimok97.mailproject.ui.mail.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.databinding.FragmentPrimaryBinding
import com.nimok97.mailproject.databinding.FragmentSocialBinding
import com.nimok97.mailproject.ui.mail.MailViewModel
import com.nimok97.mailproject.ui.util.MailFragmentType
import com.nimok97.mailproject.ui.util.MailFragmentTypeService

class SocialFragment : Fragment(), MailFragmentTypeService {

    private lateinit var binding: FragmentSocialBinding
    private val mailViewModel: MailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrintLog.printLog("$this / onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_social, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PrintLog.printLog("$this / onViewCreated")

        updateCurrentMailType()

    }

    override fun updateCurrentMailType() {
        mailViewModel.updateCurrentMailType(MailFragmentType.SOCIAL)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        PrintLog.printLog("$this / onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        PrintLog.printLog("$this / onDestroy")
    }
}