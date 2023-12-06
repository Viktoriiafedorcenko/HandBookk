package com.example.inspectorr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieDrawable
import com.example.inspectorr.databinding.ActivityMainBinding


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val iv_splash=findViewById<ImageView>(R.id.splash)
        iv_splash.alpha=0f
        iv_splash.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent (this,MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_in)
            finish()
        }
    }
    }

