package com.example.restoretodefault_frank.zbradapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.restoretodefault_frank.R
import com.example.restoretodefault_frank.zbrdatas.NlsSetting

class NlsAdapters (
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<NlsSetting>
    ) : ArrayAdapter<NlsSetting>(mContext, resId, mList) {

        val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.nls_setting_item, null)
        }
        val  row = tempRow!!
        val newlandData = mList[position]

        val nlsSettingTitle = row.findViewById<TextView>(R.id.nlsSettingTitle)
        val nlsSettingDescription = row.findViewById<TextView>(R.id.nlsSettingDescription)

        nlsSettingTitle.text = newlandData.nlsSetting
        nlsSettingDescription.text = newlandData.nlsDescription

        return  row
    }


}