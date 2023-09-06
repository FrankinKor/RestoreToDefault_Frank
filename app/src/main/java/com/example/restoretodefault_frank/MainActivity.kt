package com.example.restoretodefault_frank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.moveToSampleBarcode
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
    }
}