package com.example.restoretodefault_frank.zbradapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.restoretodefault_frank.R
import com.example.restoretodefault_frank.zbrdatas.DtlSetting

class DtlAdapters(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<DtlSetting>): ArrayAdapter<DtlSetting>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.dtl_setting_item,null)
        }

        val row = tempRow!!

        val datalogicData = mList[position]

        val dtlSettingTitle = row.findViewById<TextView>(R.id.dtlSettingTitle)
        val dtlSettingDescription = row.findViewById<TextView>(R.id.dtlSettingDescription)

        dtlSettingTitle.text = datalogicData.dtlSetting
        dtlSettingDescription.text = datalogicData.dtlDescription

        return row
    }

}