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

        mUniqList.add(UnqSetting("[7100] 초기화","", listOf(R.raw.uv7100donglestart, R.raw.uv7100englinedefault, R.raw.uv7100engineend)))
        mUniqList.add(UnqSetting("[7100] 동글 페어링","", listOf(R.raw.uv7100donglestart, R.raw.uv7100engineparing, R.raw.uv7100engineend)))
        mUniqList.add(UnqSetting("[7300] USB Keyboard","", listOf(R.raw.uv7300usb)))
        mUniqList.add(UnqSetting("[7300] 0 추가","UPC-A to EAN13", listOf(R.raw.uv7300addzero)))
        mUniqList.add(UnqSetting("[7300] 0 제거","Diasble UPC-A to EAN13", listOf(R.raw.uv7300nozero)))
        mUniqList.add(UnqSetting("[7400] 초기화","", listOf(R.raw.uv7400start, R.raw.uv7400default, R.raw.uv7400end)))
        mUniqList.add(UnqSetting("[7400] 인터페이스","USB RS232 VCOM", listOf(R.raw.uv7400start, R.raw.uv7400usb, R.raw.uv7400rs232, R.raw.uv7400vcom, R.raw.uv7400end)))
        mUniqList.add(UnqSetting("[7500] 초기화","UPC-A to EAN13", listOf(R.raw.uv7500default)))
        mUniqList.add(UnqSetting("[7500] 동글 페어링","UPC-A to EAN13", listOf(R.raw.uv7500donglesetup, R.raw.uv7500paring)))
        mUniqList.add(UnqSetting("[7500] BT 프로토콜","BT HID, SPP, BLE", listOf(R.raw.uv7500bthid, R.raw.uv7500spp, R.raw.uv7500ble)))
        mUniqList.add(UnqSetting("[7500] Total Clear","카운트 clear / 저장 데이터 clear", listOf(R.raw.uv7500totalclear, R.raw.uv7500totalstoredclear)))
        mUniqList.add(UnqSetting("[6400] 초기화","", listOf(R.raw.uv6400default)))
        mUniqList.add(UnqSetting("[6400] 인터페이스","USB VCOM", listOf(R.raw.uv6400usb, R.raw.uv6400vcom)))
        mUniqList.add(UnqSetting("[6400] 0 추가","UPC-A to EAN13", listOf(R.raw.uv6400addzero)))
        mUniqList.add(UnqSetting("[여권리더기] 가상컴포트","USB CDC", listOf(R.drawable.passport00usbcom)))
        mUniqList.add(UnqSetting("[여권리더기] 스캔 모드","Manual Trigger / presntation", listOf(R.drawable.passport00manualtriger, R.drawable.passport00presentation)))
        mUniqList.add(UnqSetting("[여권리더기] 조명 설정","1200 1500 1800", listOf(R.drawable.passport00light1200, R.drawable.passport00light1500, R.drawable.passport00light1800)))
        mUniqList.add(UnqSetting("다이소 출고 세팅","", listOf(R.drawable.daiso001,R.drawable.daiso002, R.drawable.daiso003, R.drawable.daiso004, R.drawable.daiso005, R.drawable.daiso006,R.drawable.daiso007)))



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
