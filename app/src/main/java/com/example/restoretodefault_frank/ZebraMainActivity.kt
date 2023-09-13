package com.example.restoretodefault_frank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restoretodefault_frank.R
import com.example.restoretodefault_frank.ZebraSettingDetailActivity
import com.example.restoretodefault_frank.zbradapters.ZbrAdapters
import com.example.restoretodefault_frank.zbrdatas.ZbrSetting
import kotlinx.android.synthetic.main.activity_zebra_main.zbrListView

class ZebraMainActivity : AppCompatActivity() {

    val mZebraList = ArrayList<ZbrSetting>()

    lateinit var mZbrAdapters: ZbrAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zebra_main)

        mZebraList.add(ZbrSetting("Zebra 기본 세팅 1D",
            "초기화, 엔터값, ITF 등 활성화",
            listOf(R.drawable.zbrsetdefaults1d,
                R.drawable.zbrscanoptions,
                R.drawable.zbrdatasuffix,
                R.drawable.zbrenter,
                R.drawable.zbrcodabar,
                R.drawable.zbrcode93,
                R.drawable.zbritf),
            "https://www.hihimall.com/shop/unicare/pages/download_view.php?number=454"))
        mZebraList.add(ZbrSetting("Zebra 기본 세팅 2D","초기화, 엔터값", listOf(R.drawable.zbrdefaultdm),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=350"))
        mZebraList.add(ZbrSetting("엔터 세팅 I","3개", listOf(R.drawable.zbrscanoptions, R.drawable.zbrdatasuffix, R.drawable.zbrenter),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=409"))
        mZebraList.add(ZbrSetting("엔터 세팅 II", "1개", listOf(R.drawable.zbrenterkeylong),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=352"))
        mZebraList.add(ZbrSetting("0 추가", "UPC-A to EAN13, System Character&Country Code", listOf(R.drawable.zbraddzero),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=364"))
        mZebraList.add(ZbrSetting("0 제거", "System Character", listOf(R.drawable.zbrnozero),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=416"))
        mZebraList.add(ZbrSetting("TAB 세팅", "", listOf(R.drawable.zbrtab),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=408"))
        mZebraList.add(ZbrSetting("ITF Any Length", "ITF 길이 제한 해제", listOf(R.drawable.zbritfanylength),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=410"))
        mZebraList.add(ZbrSetting("영문 세팅", "영문 고정", listOf(R.drawable.zbronlyenglish),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=411"))
        mZebraList.add(ZbrSetting("USB 설정", "USB", listOf(R.drawable.zbrusb),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=417"))
        mZebraList.add(ZbrSetting("CDC 설정", "CDC,", listOf(R.drawable.zbrcdc),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=351"))
        mZebraList.add(ZbrSetting("톤 (Tone)", "비프음 톤 세팅", listOf(R.drawable.zbrbeeperhigh, R.drawable.zbrbeepermedium,R.drawable.zbrbeeperlow, R.drawable.zbrbeeperoff),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=414"))
        mZebraList.add(ZbrSetting("음량 (Volume)", "비프음 음량 조절", listOf(R.drawable.zbrvolumehigh, R.drawable.zbrvolumemedium, R.drawable.zbrvolumelow),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=415"))
        mZebraList.add(ZbrSetting("RS232 Baud Rate", "9,600  19,200  38,400  57,600  115,200", listOf(R.drawable.zbr9600, R.drawable.zbr19200, R.drawable.zbr38400, R.drawable.zbr57600, R.drawable.zbr115200),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=413"))
        mZebraList.add(ZbrSetting("도서 바코드 (ISBN)", "EAN13 Add-on", listOf(R.drawable.zbrisbn),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=412"))
        mZebraList.add(ZbrSetting("DPM 모드 & 조명", "DPM 종류별 모드, 조명 설정", listOf(R.drawable.zbrmpmmodedesccription, R.drawable.zbrdpmilluminationdescription,R.drawable.zbrdpmmode1, R.drawable.zbrdpmmode2,R.drawable.zbrdpmdirect, R.drawable.zbrdpmindirect, R.drawable.zbrdpmcycle ),""))
        mZebraList.add(ZbrSetting("Polling Interval", "1ms ~ 9ms", listOf(R.drawable.zbrpolling1,R.drawable.zbrpolling2,R.drawable.zbrpolling3,R.drawable.zbrpolling4,R.drawable.zbrpolling5,R.drawable.zbrpolling6,R.drawable.zbrpolling7,R.drawable.zbrpolling8,R.drawable.zbrpolling9),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=455"))
        mZebraList.add(ZbrSetting("MP7000 기본 세팅", "USB / RS232(9600,N,8,1) / 엔터값 / Mobile-Enable",listOf(R.drawable.mp7000addzero1, R.drawable.mp7000addzero2, R.drawable.mp7000nozero1, R.drawable.mp7000nozero2),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=419"))
        mZebraList.add(ZbrSetting("[무선] 블루투스 연결 모드", "Cradle Mode, HID BT, BLE", listOf(R.drawable.zbrcradlemode, R.drawable.zbrhidbt, R.drawable.zbrble),"https://www.hihimall.com/shop/unicare/pages/download_view.php?number=418"))

        mZbrAdapters = ZbrAdapters(this, R.layout.zebra_setting_item, mZebraList)
        zbrListView.adapter = mZbrAdapters

        zbrListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedZebra = mZebraList[position]

            val  myIntent = Intent(this, ZebraSettingDetailActivity::class.java)
            myIntent.putExtra("setting", clickedZebra)
            startActivity(myIntent)

        }
    }

}