package com.agaba.abbys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        //reference of background for animation
        val animDrawable = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.splashId).background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(1000)
        animDrawable.start()

        //reference of image for animation
        val icon1: ImageView = findViewById(R.id.icon1)
        val icon2: ImageView = findViewById(R.id.icon2)
        val icon3: ImageView = findViewById(R.id.icon3)
        val appearAnimation = AnimationUtils.loadAnimation(this, R.anim.appear)
        icon1.startAnimation(appearAnimation)
        icon2.startAnimation(appearAnimation)
        icon3.startAnimation(appearAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}