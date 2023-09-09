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
        mNewlandList.add(NlsSetting("인터페이스 설정","USB, RS232, CDC", listOf(R.drawable.nls00enter, R.drawable.nls00usb, R.drawable.nls00rs232, R.drawable.nls00cdc, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("RS232 (전송속도) Baud Rate","9,600 19,200 38,400 115,200", listOf(R.drawable.nls00enter, R.drawable.nls009600, R.drawable.nls0019200, R.drawable.nls0038400, R.drawable.nls00115200, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("0 추가","UPCA to EAN13, System Character & Country Code", listOf(R.drawable.nls00enter, R.drawable.nls00add0, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("0 제거","System Character", listOf(R.drawable.nls00enter, R.drawable.nls00nozero, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("엔터 추가","", listOf(R.drawable.nls00enter, R.drawable.nls00enter01,R.drawable.nls00enter02, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("ITF Transmit Check Character","ITF 체크캐릭터 전송 ", listOf(R.drawable.nls00enter, R.drawable.nls00itfcheckcharacter, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("1D 활성화 / 비활성화","", listOf(R.drawable.nls00enter, R.drawable.nls001denable,R.drawable.nls001ddisable, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("2D 활성화 / 비활성화","", listOf(R.drawable.nls00enter, R.drawable.nls002denable, R.drawable.nls002ddisable, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("ALT Mode On / Off","", listOf(R.drawable.nls00enter, R.drawable.nls00alton, R.drawable.nls00altoff, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("QR Inverse","일반, 반전, 일반 & 반전", listOf(R.drawable.nls00enter, R.drawable.nls00regularqr, R.drawable.nls00inverseqr, R.drawable.nls00bothqr, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("DM Inverse","일반, 반전, 일반 & 반전", listOf(R.drawable.nls00enter, R.drawable.nls00regulardm, R.drawable.nls00inversedm, R.drawable.nls00bothdm, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("GS1 괄호 활성, 비활성","", listOf(R.drawable.nls00enter, R.drawable.nls00gs1paren, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("Code93 활성화","", listOf(R.drawable.nls00enter, R.drawable.nls00code93, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("1D Twin 바코드 설정","1D Twin(2열)바코드 활성화 / 비활성화 / 모두 사용", listOf(R.drawable.nls00enter, R.drawable.nls001dsingleonly, R.drawable.nls001dtwinonly, R.drawable.nls001dsingletwin, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[Fiexd] 센스 모드 / 컨티뉴어스 모드","Sense / Continuous Mode", listOf(R.drawable.nls00enter, R.drawable.nls00sensemode, R.drawable.nls00continuousmode, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[Fiexd] 스캔 모드 설정","일반(인쇄) / 스크린 / 페이모드", listOf(R.drawable.nls00enter, R.drawable.nls00normalmode, R.drawable.nls00sensemode, R.drawable.nls00barcodepaymode, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[Fixed] Same Barcode Reread 활성 / 비활성","Reread Same Barcode enable / disable", listOf(R.drawable.nls00enter, R.drawable.nls00reread, R.drawable.nls00disablereread, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[Fixed] Reread Timeout 설정","동일바코드 Reread Timeout 시간 설정", listOf(R.drawable.nls00rereaddescription, R.drawable.nls00enter, R.drawable.nls00setreread, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[무선] 공장초기화 & 크레들 모드","", listOf(R.drawable.nls00enter, R.drawable.nls00default, R.drawable.nls00cradlemode, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[무선] 리셋 스캐너, 크레들","Reset Scanner & Cradle", listOf(R.drawable.nls00enter, R.drawable.nls00btresetscanner,R.drawable.nls00btresetcradle, R.drawable.nls00exit, R.drawable.nls00enter, R.drawable.nls00cradlemode, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[무선] 블루투스 HID","BT HID - PC, 모바일 연결", listOf(R.drawable.nls00enter, R.drawable.nls00bthid, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[무선] 연결 정보 삭제","Clear Pairing Information of Scanner ", listOf(R.drawable.nls00enter, R.drawable.nls00clearpairinfo, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("[BS80] 공장초기화","", listOf(R.drawable.nls00bs80default)))
        mNewlandList.add(NlsSetting("[BS80] 엔터값","", listOf(R.drawable.nls00bs80setsuffix, R.drawable.nls00bs80enter,)))
        mNewlandList.add(NlsSetting("[BS80] 블루투스 인터페이스","HID / SPP", listOf(R.drawable.nls00bs80btmode, R.drawable.nls00bs80spp,)))
        mNewlandList.add(NlsSetting("[BS80] 입력 속도","BS80 데이터 입력 속도", listOf(R.drawable.nls00bs800ms, R.drawable.nls00bs805ms,R.drawable.nls00bs8015ms,R.drawable.nls00bs8025ms)))
        mNewlandList.add(NlsSetting("[BS80] Code93 * 미전송","", listOf(R.drawable.nls00bs80code93del)))
        mNewlandList.add(NlsSetting("스캐너 정보 쿼리","펌웨어, 시리얼번호, 제조일자 등", listOf(R.drawable.nls00enter, R.drawable.nls00qproductname, R.drawable.nls00qproductinfo, R.drawable.nls00qfirmware,R.drawable.nls00qserialnumber,R.drawable.nls00qoemsn,R.drawable.nls00qhardware,R.drawable.nls00qmanudate,R.drawable.nls00qdecoderversion,R.drawable.nls00qdataformatter, R.drawable.nls00exit)))
        mNewlandList.add(NlsSetting("숫자 Digit Barcode","Digit 0~9 / 세팅용", listOf(R.drawable.nls00digit0,R.drawable.nls00digit1,R.drawable.nls00digit2,R.drawable.nls00digit3,R.drawable.nls00digit4,R.drawable.nls00digit5,R.drawable.nls00digit6,R.drawable.nls00digit7,R.drawable.nls00digit8,R.drawable.nls00digit9)))
        mNewlandList.add(NlsSetting("알파벳 Alphabet Barcode","Alphabet A~F / 세팅용", listOf(R.drawable.nls00digita,R.drawable.nls00digitb,R.drawable.nls00digitc,R.drawable.nls00digitd,R.drawable.nls00digite,R.drawable.nls00digitf)))
        mNewlandList.add(NlsSetting("Save & Cancel","세팅용", listOf(R.drawable.nls00save, R.drawable.nls00cancel)))



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
