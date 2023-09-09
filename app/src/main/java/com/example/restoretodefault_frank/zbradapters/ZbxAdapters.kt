package com.example.restoretodefault_frank.zbradapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.restoretodefault_frank.R
import com.example.restoretodefault_frank.zbrdatas.HnwSetting
import com.example.restoretodefault_frank.zbrdatas.ZbxSetting

class ZbxAdapters(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<ZbxSetting>) : ArrayAdapter<ZbxSetting>(mContext, resId, mList) {

        val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.zbx_setting_item, null)
        }
        val  row = tempRow!!
        val zebexData = mList[position]

        val zbxSettingTitle = row.findViewById<TextView>(R.id.zbxSettingTitle)
        val zbxSettingDescription = row.findViewById<TextView>(R.id.zbxSettingDescription)

        zbxSettingTitle.text = zebexData.zbxSetting
        zbxSettingDescription.text = zebexData.zbxDescription

        return  row
    }


}