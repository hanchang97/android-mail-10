package com.nimok97.mailproject.ui.mail.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nimok97.mailproject.R
import com.nimok97.mailproject.common.PrintLog
import com.nimok97.mailproject.data.model.MailType
import com.nimok97.mailproject.databinding.FragmentPromotionsBinding
import com.nimok97.mailproject.ui.mail.MailViewModel
import com.nimok97.mailproject.ui.mail.adapter.MailRecyclerViewAdpater
import com.nimok97.mailproject.ui.util.MailFragmentType
import com.nimok97.mailproject.ui.util.MailFragmentTypeService

class PromotionsFragment : Fragment(), MailFragmentTypeService {

    private lateinit var binding: FragmentPromotionsBinding
    private lateinit var rvAdpater: MailRecyclerViewAdpater
    private val mailViewModel: MailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PrintLog.printLog("$this / onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_promotions, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PrintLog.printLog("$this / onViewCreated")

        updateCurrentMailType()
        setRecyclerView()
        observeData()
    }

    override fun updateCurrentMailType() {
        mailViewModel.updateCurrentMailType(MailFragmentType.PROMOTIONS)
    }

    private fun setRecyclerView() {
        rvAdpater = MailRecyclerViewAdpater()
        binding.recyclerViewPromotions.apply {
            adapter = rvAdpater
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeData() {
        mailViewModel.mailDataList.observe(viewLifecycleOwner) {
            val dataList = mailViewModel.getFilteredMialData(MailType.PROMOTIONS)
            dataList?.let {
                rvAdpater.submitList(it.toList())
            }
        }
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