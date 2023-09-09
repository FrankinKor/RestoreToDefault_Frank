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

        mZebexList.add(ZbxSetting("공장초기화","..", listOf(R.drawable.nls00sensemode)))




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
