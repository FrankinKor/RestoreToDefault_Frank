package com.example.restoretodefault_frank.zbrdatas


import java.io.Serializable

class ZbxSetting (
    val zbxSetting: String,
    val zbxDescription: String,
    val zbxImageResourceId: List<Int>
) : Serializable