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

        mHoneywellList.add(HnwSetting("공장초기화","..", listOf(R.drawable.nls00sensemode)))




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
