package com.example.restoretodefault_frank

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.restoretodefault_frank.zbrdatas.HnwSetting
import com.example.restoretodefault_frank.zbrdatas.ZbxSetting
import kotlinx.android.synthetic.main.hnw_setting_detail.hnwSettingTitle
import kotlinx.android.synthetic.main.hnw_setting_detail.hnwZoomInButton
import kotlinx.android.synthetic.main.hnw_setting_detail.hnwZoomOutButton
import kotlinx.android.synthetic.main.zbx_setting_detail.zbxZoomInButton
import kotlinx.android.synthetic.main.zbx_setting_detail.zbxZoomOutButton
import kotlinx.android.synthetic.main.zbx_setting_item.zbxSettingTitle
import me.relex.circleindicator.CircleIndicator3

class ZebexSettingDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zbx_setting_detail)

        val zebexData = intent.getSerializableExtra("setting") as? ZbxSetting

        if(zebexData != null){
            zbxSettingTitle.text = zebexData.zbxSetting
            val zbxImageResourceId = zebexData.zbxImageResourceId

            //ViewPager 설정
            val viewPager = findViewById<ViewPager2>(R.id.zebexViewPager)
            val imageAdapter = ZebexSettingDetail.ImagePagerAdapter(this, zbxImageResourceId)
            viewPager.adapter = imageAdapter

            //CircleIndicator 초기화
            val circleIndicator = findViewById<CircleIndicator3>(R.id.zebexImageIndicator)
            circleIndicator.setViewPager(viewPager)


            // 이미지 확대 버튼
           zbxZoomInButton.setOnClickListener {
                imageAdapter.scaleImage(1.1f) // 예시로 10% 확대
            }

            // 이미지 축소 버튼
            zbxZoomOutButton.setOnClickListener {
                imageAdapter.scaleImage(0.9f) // 예시로 10% 축소
            }

            // 페이지가 변경될 때 이미지 크기 초기화
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    imageAdapter.resetImagesize()
                }
            })
        }
    }

    class ImagePagerAdapter(private val context: Context, private val imageResources: List<Int>) :
        RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

        private var currentScaleFactor = 1.0f // 멤버 변수로 추가
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val inflater = LayoutInflater.from(context)
            val itemView = inflater.inflate(R.layout.image_pager_item, parent, false)
            return ImageViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageResourceId = imageResources[position]
            holder.imageView.setImageResource(imageResourceId)

            // 이미지 크기 조절
            holder.imageView.scaleX = currentScaleFactor
            holder.imageView.scaleY = currentScaleFactor
        }

        override fun getItemCount(): Int {
            return imageResources.size
        }

        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageView)
        }

        // 이미지 확대/축소 메서드
        fun scaleImage(scaleFactor: Float) {
            currentScaleFactor *= scaleFactor
            // 이미지 크기를 범위 내로 유지
            currentScaleFactor = currentScaleFactor.coerceIn(0.1f, 1.7f)
            notifyDataSetChanged() // 변경된 크기를 갱신
        }

        fun resetImagesize() {
            currentScaleFactor = 1.0f
            notifyDataSetChanged() // 이미지 크기를 초기화하고 갱신
        }

    }

}