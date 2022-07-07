package com.nimok97.mailproject.ui.mail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nimok97.mailproject.R
import com.nimok97.mailproject.data.model.Mail
import com.nimok97.mailproject.databinding.RecyclerviewItemMailBinding
import com.nimok97.mailproject.ui.util.RandomColor

class MailRecyclerViewAdpater :
    ListAdapter<Mail, MailRecyclerViewAdpater.MailViewHolder>(diffUtil) {

    class MailViewHolder(private val binding: RecyclerviewItemMailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mail: Mail) {
            binding.mail = mail
            if(mail.sender[0] in 'A'..'z'){
                binding.imageViewDefaultProfile.isVisible = false
                binding.textViewProfile.isVisible = true

                binding.textViewProfile.text = mail.sender[0].toString()
                binding.constraintLayoutProfile.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, RandomColor.getRandomColor())
                )
            }
            else{
                binding.textViewProfile.isVisible = false
                binding.imageViewDefaultProfile.isVisible = true
                binding.constraintLayoutProfile.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, R.color.mail_default_profile_background)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val binding =
            RecyclerviewItemMailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Mail>() {
            override fun areItemsTheSame(oldItem: Mail, newItem: Mail): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Mail, newItem: Mail): Boolean {
                return oldItem == newItem
            }
        }
    }
}