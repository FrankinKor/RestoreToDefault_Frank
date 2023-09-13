package com.example.restoretodefault_frank.zbrdatas


import java.io.Serializable

class HnwSetting (
    val hnwSetting: String,
    val hnwDescription: String,
    val hnwImageResourceId: List<Int>,
    val hnwUrl: String
) : Serializable