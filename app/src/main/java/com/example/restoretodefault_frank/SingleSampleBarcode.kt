package com.example.restoretodefault_frank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_sample_barcode.imageViewPager
import kotlinx.android.synthetic.main.sample_single.singleBarcodeNameText
import kotlinx.android.synthetic.main.sample_single.singleImageIndicator

class SingleSampleBarcode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_single)
        val singleImageIds = listOf(
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

        val singleBarcodeNames = listOf(
            "Code 128",
            "EAN13",
            "Interleaved 2 of 5",
            "UPC-A",
            "UPC-E",
            "Code39",
            "Code93",
            "QR Code",
            "Data Matrix",
            "PDF417",
            "GS1-DataMatrix",
            "GS1-Code128"
        )

        val adapter = ImageViewPagerAdapter(singleBarcodeNames, singleImageIds)
        imageViewPager.adapter = adapter
        singleImageIndicator.setViewPager(imageViewPager)

        imageViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position < singleBarcodeNames.size) {
                    singleBarcodeNameText.text = singleBarcodeNames[position]
                }
                //페이지가 변경될 때 이미지 크기 초기화
                resetImageSize()

            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    val currentItem = imageViewPager.currentItem
                    if (currentItem < singleBarcodeNames.size)
                        singleBarcodeNameText.text = singleBarcodeNames[currentItem]
                }
            }

        })
        singleBarcodeNameText.text = singleBarcodeNames[0]

        val singleZoomInButton = findViewById<View>(R.id.singleZoomInButton)
        val singleZoomOutButton = findViewById<View>(R.id.singleZoomOutButton)

        singleZoomInButton.setOnClickListener {
            scaleImage(1.1f)//
        }
        singleZoomOutButton.setOnClickListener {
            scaleImage(0.9f)
        }
    }
    private fun scaleImage(scaleFactor: Float) {
        val newScale = imageViewPager.scaleX * scaleFactor
        imageViewPager.scaleX = newScale.coerceIn(0.1f, 1.7f)
        imageViewPager.scaleY = newScale.coerceIn(0.1f, 1.7f)
    }
    private fun resetImageSize() {
        imageViewPager.scaleX = 1.0f
        imageViewPager.scaleY = 1.0f
    }
}

class SingleSampleBarcodeImageViewPagerAdapter(private val singleBarcodeNames: List<String>, private val singleImageIds: List<Int>) :
        RecyclerView.Adapter<SingleSampleBarcodeImageViewPagerAdapter.Pager2ViewHolder>() {
            inner class Pager2ViewHolder(itemView: View) :
                    RecyclerView.ViewHolder(itemView) {
                        val itemImage: ImageView = itemView.findViewById(R.id.imageView)
                    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return singleImageIds.size
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        val imageId =singleImageIds[position]
        holder.itemImage.setImageResource(imageId)
    } }
