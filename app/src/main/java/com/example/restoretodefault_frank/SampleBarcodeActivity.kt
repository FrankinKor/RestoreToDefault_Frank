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
            R.raw.code128,
            R.raw.ean13,
            R.raw.itf,
            R.raw.upca,
            R.raw.upce,
            R.raw.code39,
            R.raw.code93,
            R.raw.qrcode,
            R.raw.dm,
            R.raw.pdf417,
            R.raw.gs1dm,
            R.raw.gs1code128

        )
        val barcodeNames = listOf("Code 128", "EAN-13","ITF\n(Interleaved 2of5)", "UPC-A", "UPC-E", "Code 39", "Code 93", "QR Code", "Data Matrix","PDF417","GS1-DataMatrix", "GS1-Code128")

        val adapter = ImageViewPagerAdapter(barcodeNames, imageIds)
        imageViewPager.adapter = adapter
        imageIndicator.setViewPager(imageViewPager)


        imageViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position < barcodeNames.size) {
                    barcodeNameText.text = barcodeNames[position]
                }
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
            scaleImage(1.1f) // 예시로 20% 확대
        }

        zoomOutButton.setOnClickListener {
            scaleImage(0.9f) // 예시로 20% 축소
        }
    }

    private fun scaleImage(scaleFactor: Float) {
        val newScale = imageViewPager.scaleX * scaleFactor
        imageViewPager.scaleX = newScale.coerceIn(0.1f, 5.0f)
        imageViewPager.scaleY = newScale.coerceIn(0.1f, 5.0f)
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