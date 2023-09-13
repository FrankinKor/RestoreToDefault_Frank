package com.example.restoretodefault_frank

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restoretodefault_frank.zbradapters.HnwAdapters
import com.example.restoretodefault_frank.zbradapters.ZbxAdapters
import com.example.restoretodefault_frank.zbrdatas.HnwSetting
import com.example.restoretodefault_frank.zbrdatas.ZbxSetting
import kotlinx.android.synthetic.main.hnw_main.hnwListView
import kotlinx.android.synthetic.main.zbx_main.zbxListView

class ZebexlMain : AppCompatActivity() {

    val  mZebexList = ArrayList<ZbxSetting>()
    lateinit var mZbxAdapters: ZbxAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zbx_main)

        mZebexList.add(ZbxSetting("초기화","", listOf(R.drawable.zbx00start,R.drawable.zbx00reset,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=446"))
        mZebexList.add(ZbxSetting("USB","", listOf(R.drawable.zbx00start,R.drawable.zbx00usb,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=463"))
        mZebexList.add(ZbxSetting("시리얼 (RS232)","", listOf(R.drawable.zbx00start,R.drawable.zbx00rs232,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=464"))
        mZebexList.add(ZbxSetting("VCOM","", listOf(R.drawable.zbx00start,R.drawable.zbx00vcom,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=465"))
        mZebexList.add(ZbxSetting("0 추가","UPC-A to EAN13", listOf(R.drawable.zbx00start,R.drawable.zbx00addzero1st, R.drawable.zbx00addzero2nd,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=447"))
        mZebexList.add(ZbxSetting("도서 바코드 / ISBN","EAN13 Add on", listOf(R.drawable.zbx00start,R.drawable.zbx00isbnadd5,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=451"))
        mZebexList.add(ZbxSetting("[무선] 초기화 & 크레들 모드","", listOf(R.drawable.zbx00start,R.drawable.zbx00btdefault, R.drawable.zbx00cradle,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=449"))
        mZebexList.add(ZbxSetting("[무선] 크레들 모드","", listOf(R.drawable.zbx00start,R.drawable.zbx00cradle,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=450"))
        mZebexList.add(ZbxSetting("[무선] 블루투스","BT HID", listOf(R.drawable.zbx00start,R.drawable.zbx00bthid,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=448"))
        mZebexList.add(ZbxSetting("[무선] SPP 모드","SPP Slave", listOf(R.drawable.zbx00start,R.drawable.zbx00sppslave,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=453"))
        mZebexList.add(ZbxSetting("[무선] Power Off","", listOf(R.drawable.zbx00start,R.drawable.zbx00pwroff,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=452"))
        mZebexList.add(ZbxSetting("[무선] iOS 페어링","", listOf(R.drawable.zbx00start,R.drawable.zbx00bthid,R.drawable.zbx00smartphonemode, R.drawable.zbx00multikeyboard, R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=466"))
        mZebexList.add(ZbxSetting("[무선] 키패드 On/Off","", listOf(R.drawable.zbx00start,R.drawable.zbx00keypadonoff,R.drawable.zbx00end),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=467"))
        mZebexList.add(ZbxSetting("Digit 바코드","숫자 & 엔터", listOf(R.drawable.zbx00digit1, R.drawable.zbx00digit2, R.drawable.zbx00enter),""))





        mZbxAdapters = ZbxAdapters(this, R.layout.zbx_setting_item, mZebexList)
        zbxListView.adapter = mZbxAdapters

        zbxListView.setOnItemClickListener {adapterView, view, position, l ->
            val  clickedZebex = mZebexList[position]
            val  myIntent = Intent(this, ZebexSettingDetail::class.java)
            myIntent.putExtra("setting", clickedZebex)
            startActivity(myIntent)

        }

    }
    }
