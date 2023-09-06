package com.example.restoretodefault_frank.zbrdatas

import java.io.Serializable

class NlsSetting (
    val nlsSetting: String,
    val nlsDescription: String,
    val nlsImageResourceId: List<Int>
) : Serializable