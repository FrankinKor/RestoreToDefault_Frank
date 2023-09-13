package com.example.restoretodefault_frank

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restoretodefault_frank.zbradapters.DtlAdapters
import com.example.restoretodefault_frank.zbradapters.HnwAdapters
import com.example.restoretodefault_frank.zbradapters.ZbxAdapters
import com.example.restoretodefault_frank.zbrdatas.DtlSetting
import com.example.restoretodefault_frank.zbrdatas.HnwSetting
import com.example.restoretodefault_frank.zbrdatas.ZbxSetting
import kotlinx.android.synthetic.main.hnw_main.hnwListView
import kotlinx.android.synthetic.main.dtl_main.dtlListView

class DatalogicMain : AppCompatActivity() {

    val  mDatalogicList = ArrayList<DtlSetting>()
    lateinit var mDtlAdapters: DtlAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dtl_main)

        mDatalogicList.add(DtlSetting("초기화","1D", listOf(R.drawable.dtl00enterexit,R.drawable.dtl001100default,R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=468"))
        mDatalogicList.add(DtlSetting("0 추가","Expand UPC-A to EAN13", listOf(R.drawable.dtl00enterexit,R.drawable.dtl00addzero,R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=469"))
        mDatalogicList.add(DtlSetting("0 제거","Don't expand UPC-A to EAN13 ", listOf(R.drawable.dtl00enterexit,R.drawable.dtl00nozero,R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=470"))
        mDatalogicList.add(DtlSetting("[1500i] 2D 활성화","QR Code, Data Matrix 활성화", listOf(R.drawable.dtl00enterexit,R.drawable.dtl001500qr, R.drawable.dtl1500dm,R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=474"))
        mDatalogicList.add(DtlSetting("[1500i] USB ","", listOf(R.drawable.dtl00enterexit,R.drawable.dtl001500usb, R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=473"))
        mDatalogicList.add(DtlSetting("[1500i] RS232","", listOf(R.drawable.dtl00enterexit, R.drawable.dtl001500rs232, R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=475"))
        mDatalogicList.add(DtlSetting("[1500i] URL 활성화","URL (http://) 활성화", listOf(R.drawable.dtl00enterexit,R.drawable.dtl001500url, R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=476"))
        mDatalogicList.add(DtlSetting("[1500i] 초기화","", listOf(R.drawable.dtl1500default),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=477"))
        mDatalogicList.add(DtlSetting("[2D] 라벨아이디 비활성화","Label ID", listOf(R.drawable.dtl00enterexit,R.drawable.dtl00labeliddis,R.drawable.dtl00enterexit),"https://www.hihimall.com/shop/unicare/pages/download_view.ph p?number=478"))




        mDtlAdapters = DtlAdapters(this, R.layout.dtl_setting_item, mDatalogicList)
        dtlListView.adapter = mDtlAdapters

        dtlListView.setOnItemClickListener {adapterView, view, position, l ->
            val  clickedDatalogic = mDatalogicList[position]
            val  myIntent = Intent(this, DatalogicSettingDetail::class.java)
            myIntent.putExtra("setting", clickedDatalogic)
            startActivity(myIntent)

        }

    }
    }
