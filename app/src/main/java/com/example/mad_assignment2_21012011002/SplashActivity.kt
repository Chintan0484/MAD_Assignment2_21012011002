package com.example.mad_assignment2_21012011002

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.example.mad_assignment2_21012011002.R.id.imageView

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var frameAnimation : AnimationDrawable

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val img : ImageView = findViewById(imageView)

        img.setBackgroundResource(R.drawable.splash_animation)

        frameAnimation = img.background as AnimationDrawable

        frameAnimation.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        },1400)

    }
}