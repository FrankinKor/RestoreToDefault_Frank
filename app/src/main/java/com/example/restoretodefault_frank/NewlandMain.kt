package com.example.restoretodefault_frank

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restoretodefault_frank.zbradapters.NlsAdapters
import com.example.restoretodefault_frank.zbrdatas.NlsSetting
import kotlinx.android.synthetic.main.nls_main.nlsListView

class NewlandMain : AppCompatActivity() {

    val  mNewlandList = ArrayList<NlsSetting>()
    lateinit var mNlsAdapters: NlsAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nls_main)

        mNewlandList.add(NlsSetting("공장초기화","", listOf(R.drawable.nls00enter, R.drawable.nls00default, R.drawable.nls00exit)))


        mNlsAdapters = NlsAdapters(this, R.layout.nls_setting_item, mNewlandList)
        nlsListView.adapter = mNlsAdapters

        nlsListView.setOnItemClickListener { adapterView, view, position, l ->
            val  clickedNewland = mNewlandList[position]
            val  myIntent = Intent(this, NewlandSettingDetail::class.java)
            myIntent.putExtra("setting", clickedNewland)
            startActivity(myIntent)

        }

    }
    }
