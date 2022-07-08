package com.nimok97.mailproject.data.model

data class Mail(
    val id: Int,
    val sender: String,
    val title: String,
    val content: String,
    val date: String,
    val mailType: MailType,
    val imageProfileColor: Int,
    val textProfileColor: Int
)
