package com.example.restoretodefault_frank

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restoretodefault_frank.zbradapters.HnwAdapters
import com.example.restoretodefault_frank.zbrdatas.HnwSetting
import kotlinx.android.synthetic.main.hnw_main.hnwListView

class HoneywellMain : AppCompatActivity() {

    val  mHoneywellList = ArrayList<HnwSetting>()
    lateinit var mHnwAdapters: HnwAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hnw_main)

        mHoneywellList.add(HnwSetting("초기화","", listOf(R.drawable.hnw00default1, R.drawable.hnw00default2),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=353"))
        mHoneywellList.add(HnwSetting("엔터값","", listOf(R.drawable.hnw00enter),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=354"))
        mHoneywellList.add(HnwSetting("USB 세팅","", listOf(R.drawable.hnw00usb),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=456"))
        mHoneywellList.add(HnwSetting("USB Serial 세팅","가상컴포트", listOf( R.drawable.hnw00cdc),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=355"))
        mHoneywellList.add(HnwSetting("시리얼 (RS232) 세팅","", listOf(R.drawable.hnw00rs232),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=457"))
        mHoneywellList.add(HnwSetting("RS232 Baud Rate / 전송속도","-", listOf(R.drawable.hnw00rs232, R.drawable.hnw009600, R.drawable.hnw0019200, R.drawable.hnw0038400, R.drawable.hnw00115200),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=458"))
        mHoneywellList.add(HnwSetting("스캔모드","-", listOf(R.drawable.hnw00presenation),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=358"))
        mHoneywellList.add(HnwSetting("[3220g] Read Mode","Manual trigger / Streaming Presentaion - Enhanced,mobile", listOf(R.drawable.hnw003220gmode1, R.drawable.hnw003220mode2, R.drawable.hnw003220mode3),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=462"))
        mHoneywellList.add(HnwSetting("[HH490] 초기화","", listOf(R.drawable.hnw00490default1, R.drawable.hnw00490default2),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=459"))
        mHoneywellList.add(HnwSetting("[HH490] 인터페이스","USB / RS232 / CDC", listOf(R.drawable.hnw00490usb, R.drawable.hnw00490rs232, R.drawable.hnw00490cdc),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=460"))
        mHoneywellList.add(HnwSetting("[HH490] RS232 Baud Rate / 전송속도","9600 19,200 38,400 57,600 115,200", listOf(R.drawable.hnw004909600, R.drawable.hnw0049019200, R.drawable.hnw0049038400, R.drawable.hnw0049057600, R.drawable.hnw00490115200),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=461"))




        mHnwAdapters = HnwAdapters(this, R.layout.hnw_setting_item, mHoneywellList)
        hnwListView.adapter = mHnwAdapters

        hnwListView.setOnItemClickListener {adapterView, view, position, l ->
            val  clickedHoneywell = mHoneywellList[position]
            val  myIntent = Intent(this, HoneywellSettingDetail::class.java)
            myIntent.putExtra("setting", clickedHoneywell)
            startActivity(myIntent)

        }

    }
    }
