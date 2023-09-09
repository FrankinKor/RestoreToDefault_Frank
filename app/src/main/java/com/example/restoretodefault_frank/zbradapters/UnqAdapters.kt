package com.example.restoretodefault_frank.zbradapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.restoretodefault_frank.R
import com.example.restoretodefault_frank.zbrdatas.UnqSetting


class UnqAdapters(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<UnqSetting>): ArrayAdapter<UnqSetting>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.unq_setting_item, null)
        }

        val row = tempRow!!

        val uniqData = mList[position]

        val unqSettingTitle = row.findViewById<TextView>(R.id.unqSettingTitle)
        val unqSettingDescription = row.findViewById<TextView>(R.id.unqSettingDescription)

        unqSettingTitle.text = uniqData.unqSetting
        unqSettingDescription.text = uniqData.unqDescription

        return row
    }

}