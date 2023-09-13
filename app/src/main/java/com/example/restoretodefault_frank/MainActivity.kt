package com.example.restoretodefault_frank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.moveToSampleBarcode
import kotlinx.android.synthetic.main.activity_main.toDatalogic
import kotlinx.android.synthetic.main.activity_main.toHoneywell
import kotlinx.android.synthetic.main.activity_main.toNewland
import kotlinx.android.synthetic.main.activity_main.toRent
import kotlinx.android.synthetic.main.activity_main.toUniqvision
import kotlinx.android.synthetic.main.activity_main.toZebex
import kotlinx.android.synthetic.main.activity_main.toZebra

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToSampleBarcode.setOnClickListener {
            val myIntent = Intent(this, SampleBarcodeActivity::class.java)
            startActivity(myIntent)

        }
        toZebra.setOnClickListener {
            val myIntent = Intent(this, ZebraMainActivity::class.java)
            startActivity(myIntent)
        }
        toNewland.setOnClickListener {
            val myIntent = Intent(this, NewlandMain::class.java)
            startActivity(myIntent)
        }
        toHoneywell.setOnClickListener {
            val myIntent = Intent(this, HoneywellMain::class.java)
            startActivity(myIntent)
        }

        toZebex.setOnClickListener {
            val myIntent = Intent(this, ZebexlMain::class.java)
            startActivity(myIntent)
        }


    toUniqvision.setOnClickListener {
        val myIntent = Intent(this, UniqMain::class.java)
        startActivity(myIntent)
    }


        toDatalogic.setOnClickListener {
            val myIntent = Intent(this, DatalogicMain::class.java)
            startActivity(myIntent)
    }
        toRent.setOnClickListener{
            Toast.makeText(this, "임대합니다. 연락주세요.", Toast.LENGTH_SHORT).show()
        }



    }
}