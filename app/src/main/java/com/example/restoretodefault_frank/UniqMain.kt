package com.example.restoretodefault_frank

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.restoretodefault_frank.zbradapters.UnqAdapters
import com.example.restoretodefault_frank.zbrdatas.UnqSetting
import kotlinx.android.synthetic.main.unq_main.unqListView


class UniqMain : AppCompatActivity() {

    val  mUniqList = ArrayList<UnqSetting>()
    lateinit var mUnqdapters: UnqAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.unq_main)

        mUniqList.add(UnqSetting("공장초기화","..", listOf(R.drawable.nls00sensemode)))




        mUnqdapters = UnqAdapters(this, R.layout.unq_setting_item, mUniqList)
        unqListView.adapter = mUnqdapters

        unqListView.setOnItemClickListener {adapterView, view, position, l ->
            val  clickedUniq = mUniqList[position]
            val  myIntent = Intent(this, UniqSettingDetail::class.java)
            myIntent.putExtra("setting", clickedUniq)
            startActivity(myIntent)

        }

    }
    }
