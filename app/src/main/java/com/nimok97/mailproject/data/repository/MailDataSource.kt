package com.nimok97.mailproject.data.repository

import com.nimok97.mailproject.R
import com.nimok97.mailproject.data.model.Mail
import com.nimok97.mailproject.data.model.MailType
import com.nimok97.mailproject.ui.util.RandomColor
import javax.inject.Inject

class MailDataSource @Inject constructor() {
    private val dataList = listOf(
        Mail(
            1,
            "Google",
            "보안 알림",
            "Android에서 새로 로그인함",
            "2022-07-07",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            2,
            "David",
            "Hello",
            "Hi, ChangHee",
            "2022-07-04",
            MailType.PROMOTIONS,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            3,
            "구자경",
            "안녕하세요",
            "친하게 지내요",
            "2022-07-01",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            4,
            "김영희",
            "영희에요",
            "잘 지내시나요",
            "2022-07-07",
            MailType.SOCIAL,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            5,
            "Ivy",
            "수업 공지",
            "금일 수업은 ~~ 에서 진행됩니다! 시간 맞춰 오세요",
            "2022-07-06",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            6,
            "한창희",
            "나에게 쓰기",
            "hihihi",
            "2022-06-07",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            7,
            "크롱",
            "우테캠 초대장",
            "우테캠 합격을 축하합니다",
            "2022-06-23",
            MailType.SOCIAL,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            8,
            "호눅스",
            "깃허브 초대",
            "깃허브에 초대합니다",
            "2022-06-12",
            MailType.SOCIAL,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            9,
            "Naver",
            "보안 알림",
            "Android에서 새로 로그인함",
            "2022-07-01",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            10,
            "우아한 형제들",
            "합격 메일",
            "축하드립니다",
            "2022-07-08",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            11,
            "배민",
            "VIP 전용 메일",
            "축하합니다",
            "2022-06-17",
            MailType.PROMOTIONS,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            12,
            "Slack",
            "초대 알림",
            "Android에서 새로 로그인함",
            "2022-06-13",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            13,
            "Notion",
            "notion",
            "Android에서 새로 로그인함",
            "2022-07-03",
            MailType.PROMOTIONS,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            14,
            "James",
            "I'm James",
            "Android에서 새로 로그인함",
            "2022-07-05",
            MailType.PROMOTIONS,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            15,
            "홍길동",
            "길동입니다",
            "Android에서 새로 로그인함",
            "2022-06-22",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            16,
            "Amy",
            "나는 에미미",
            "Android에서 새로 로그인함",
            "2022-06-28",
            MailType.SOCIAL,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
        Mail(
            17,
            "아이비",
            "보안 알림",
            "Android에서 새로 로그인함",
            "2022-06-06",
            MailType.PRIMARY,
            R.color.mail_default_profile_background,
            RandomColor.getRandomColor()
        ),
    )

    fun getMailData() = dataList
}