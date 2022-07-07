package com.nimok97.mailproject.ui.util

import com.nimok97.mailproject.R

object RandomColor {
    val colorList = listOf(R.color.mail_profile_yellow, R.color.mail_profile_green, R.color.mail_profile_orange)

    fun getRandomColor(): Int {
        val inx = (0..2).random()
        return colorList[inx]
    }
}