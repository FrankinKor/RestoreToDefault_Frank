package com.example.restoretodefault_frank.zbrdatas


import java.io.Serializable

class UnqSetting (
    val unqSetting: String,
    val unqDescription: String,
    val unqImageResourceId: List<Int>
) : Serializable