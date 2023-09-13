package com.example.restoretodefault_frank.zbrdatas

import android.content.ContentUris
import android.net.Uri
import android.net.wifi.aware.AwareResources
import java.io.Serializable

class DtlSetting(
    val dtlSetting: String,
    val dtlDescription: String,
    val dtlImageResourceId: List<Int>,
    val dtlUrl: String
) : Serializable
