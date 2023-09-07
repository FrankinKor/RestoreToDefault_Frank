package com.example.restoretodefault_frank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_sample_barcode.barcodeNameText
import kotlinx.android.synthetic.main.activity_sample_barcode.imageIndicator
import kotlinx.android.synthetic.main.activity_sample_barcode.imageViewPager

class SampleBarcodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_barcode)
        val imageIds = listOf(
            R.raw.sample1,
            R.raw.sample2,
            R.raw.sample3,
            R.raw.sample4,
            R.raw.sample5,
            R.raw.sample6,
            R.raw.sample7,
            R.raw.sample8,
            R.raw.sample9,
            R.raw.sample10,
            R.raw.sample11,
            R.raw.sample12,
            R.raw.sample13,
            R.raw.sample14,
            R.raw.sample15,
            R.raw.sample16,
            R.raw.sample17,
            R.raw.sample18,
            R.raw.sample19,
            R.raw.sample20,
            R.raw.sample21,
            R.raw.sample22,
            R.raw.sample23,
            R.raw.sample24,



//            R.raw.code128,
//            R.raw.ean13,
//            R.raw.itf,
//            R.raw.upca,
//            R.raw.upce,
//            R.raw.code39,
//            R.raw.code93,
//            R.raw.qrcode,
//            R.raw.dm,
//            R.raw.pdf417,
            R.raw.gs1dm,
            R.raw.gs1code128

        )
        val barcodeNames = listOf("","","","","","","","","","","","","","","","","","","","","","","","","GS1-DataMatrix","GS1-Code128",)

        val adapter = ImageViewPagerAdapter(barcodeNames, imageIds)
        imageViewPager.adapter = adapter
        imageIndicator.setViewPager(imageViewPager)


        imageViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position < barcodeNames.size) {
                    barcodeNameText.text = barcodeNames[position]
                }

                // 페이지가 변경될 때 이미지 크기 초기화
                resetImageSize()

            }
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    val currentItem = imageViewPager.currentItem
                    if (currentItem < barcodeNames.size) {
                        barcodeNameText.text = barcodeNames[currentItem]
                    }
                }
            }

        })
        barcodeNameText.text = barcodeNames[0]

        val zoomInButton = findViewById<View>(R.id.zoomInButton)
        val zoomOutButton = findViewById<View>(R.id.zoomOutButton)

        zoomInButton.setOnClickListener {
            scaleImage(1.1f) // 예시로 10% 확대
        }

        zoomOutButton.setOnClickListener {
            scaleImage(0.9f) // 예시로 10% 축소
        }

    }

    private fun scaleImage(scaleFactor: Float) {
        val newScale = imageViewPager.scaleX * scaleFactor
        imageViewPager.scaleX = newScale.coerceIn(0.1f, 1.4f)
        imageViewPager.scaleY = newScale.coerceIn(0.1f, 1.4f)
    }

    private fun resetImageSize() {
        imageViewPager.scaleX = 1.0f
        imageViewPager.scaleY = 1.0f
    }
}

class ImageViewPagerAdapter(private val barcodeNames: List<String>, private val imageIds: List<Int>) :
    RecyclerView.Adapter<ImageViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return imageIds.size
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        val imageId = imageIds[position]
        holder.itemImage.setImageResource(imageId)


    }
}