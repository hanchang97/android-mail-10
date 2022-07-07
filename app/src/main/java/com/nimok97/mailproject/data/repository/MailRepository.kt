package com.nimok97.mailproject.data.repository

class MailRepository(private val mailDataSource: MailDataSource) {
    fun getMailData() = mailDataSource.getMailData()
}