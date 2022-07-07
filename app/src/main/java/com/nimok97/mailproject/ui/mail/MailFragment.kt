package com.nimok97.mailproject.ui.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import com.nimok97.mailproject.R
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentType
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.ui.util.BottomNavigationFragmentTypeService
import com.nimok97.mailproject.databinding.FragmentMailBinding
import com.nimok97.mailproject.ui.MainViewModel
import com.nimok97.mailproject.ui.mail.type.PrimaryFragment
import com.nimok97.mailproject.ui.mail.type.PromotionsFragment
import com.nimok97.mailproject.ui.mail.type.SocialFragment
import com.nimok97.mailproject.ui.mail.type.TestFragment
import com.nimok97.mailproject.ui.util.MailFragmentType

class MailFragment : Fragment(), BottomNavigationFragmentTypeService {

    private lateinit var binding: FragmentMailBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private val mailViewModel: MailViewModel by activityViewModels()

    private val primaryFragment by lazy { PrimaryFragment() }
    private val socialFragment by lazy { SocialFragment() }
    private val promotionsFragment by lazy { PromotionsFragment() }
    private val testFragment by lazy { TestFragment() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrintLog.printLog("$this / onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PrintLog.printLog("$this / onViewCreated")

        updateCurrentBottomNavigationFragmentType()

        setAppBar()
        setNavView()
        initView()
        getData()
    }

    override fun updateCurrentBottomNavigationFragmentType() {
        mainViewModel.updateCurrentBottomNavigationFragmentType(BottomNavigationFragmentType.MAIL)
    }

    private fun setAppBar() {
        binding.contentMail.toolbarMail.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
    }

    private fun setNavView() {
        binding.navViewMail.menu.findItem(R.id.fragment_primary).isChecked = true

        binding.navViewMail.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.fragment_primary -> {
                    clearBackStack()
                    changeFragment(primaryFragment)
                }
                R.id.fragment_social -> {
                    changeFragmentExceptPrimary("Social", socialFragment)
                }
                R.id.fragment_promotions -> {
                    changeFragmentExceptPrimary("Promotions", promotionsFragment)
                }
                R.id.fragment_test -> {
                    changeFragmentExceptPrimary("Test", testFragment)
                }
            }
            binding.drawerLayout.close()
            true
        }
    }

    private fun initView() {
        clearBackStack()
        changeFragment(primaryFragment)
        PrintLog.printLog("MailFragment / ${mailViewModel.mailTypeFragment}")
        when (mailViewModel.mailTypeFragment) { // 회전 시 탭 유지 위함
            MailFragmentType.SOCIAL -> {
                binding.navViewMail.menu.findItem(R.id.fragment_social).isChecked = true
                changeFragmentExceptPrimary("Social", socialFragment)
            }
            MailFragmentType.PROMOTIONS -> {
                binding.navViewMail.menu.findItem(R.id.fragment_promotions).isChecked = true
                changeFragmentExceptPrimary("Promotions", promotionsFragment)
            }
            MailFragmentType.TEST -> {
                binding.navViewMail.menu.findItem(R.id.fragment_test).isChecked = true
                changeFragmentExceptPrimary("Test", testFragment)
            }
            else -> {}
        }
    }

    private fun getData() {
        mailViewModel.getMailData()
    }

    fun backToPrimary() {
        clearBackStack()
        changeFragment(primaryFragment)
        binding.navViewMail.menu.findItem(R.id.fragment_primary).isChecked = true
    }

    private fun changeFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().replace(R.id.fragmentContainerView_mail, fragment)
            .commit()
    }

    private fun changeFragmentExceptPrimary(name: String, fragment: Fragment) {
        childFragmentManager.popBackStackImmediate(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView_mail, fragment, name)
            .addToBackStack(name)
            .commit()
    }

    private fun clearBackStack() {
        childFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onDestroyView() {
        // Primary Fragment 에서 회전하는 경우를 위해
        if (childFragmentManager.backStackEntryCount < 1)
            mailViewModel.updateCurrentMailType(MailFragmentType.PRIMARY)
        super.onDestroyView()
    }
}