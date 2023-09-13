package com.example.restoretodefault_frank.zbrdatas

import android.content.ContentUris
import android.net.Uri
import android.net.wifi.aware.AwareResources
import java.io.Serializable

class ZbrSetting(
    val zbrSetting: String,
    val zbrDescription: String,
    val zbrImageResourceId: List<Int>,
    val zbrUrl: String
) : Serializable
