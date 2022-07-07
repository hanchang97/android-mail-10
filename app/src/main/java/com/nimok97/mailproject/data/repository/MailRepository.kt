package com.nimok97.mailproject.data.repository

import javax.inject.Inject

class MailRepository @Inject constructor(private val mailDataSource: MailDataSource) {
    fun getMailData() = mailDataSource.getMailData()
}