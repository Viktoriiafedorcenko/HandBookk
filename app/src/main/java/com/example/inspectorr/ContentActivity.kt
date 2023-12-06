package com.example.inspectorr

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
val tvContent=findViewById<TextView>(R.id.tvContent)
        val imageView=findViewById<ImageView>(R.id.imageView)
        val tvTitle=findViewById<TextView>(R.id.tvTitle)
        tvTitle.text=intent.getStringExtra("title")
        tvContent.text=intent.getStringExtra("content")
        imageView.setImageResource(intent.getIntExtra("image",R.drawable.os))
    }
}