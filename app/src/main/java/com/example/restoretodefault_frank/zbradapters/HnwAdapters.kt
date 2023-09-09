package com.example.restoretodefault_frank.zbradapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.restoretodefault_frank.R
import com.example.restoretodefault_frank.zbrdatas.HnwSetting

class HnwAdapters(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<HnwSetting>) : ArrayAdapter<HnwSetting>(mContext, resId, mList) {

        val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.hnw_setting_item, null)
        }
        val  row = tempRow!!
        val honeywellData = mList[position]

        val hnwSettingTitle = row.findViewById<TextView>(R.id.hnwSettingTitle)
        val hnwSettingDescription = row.findViewById<TextView>(R.id.hnwSettingDescription)

        hnwSettingTitle.text = honeywellData.hnwSetting
        hnwSettingDescription.text = honeywellData.hnwDescription

        return  row
    }


}