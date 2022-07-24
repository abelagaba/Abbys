package com.agaba.abbys

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)

        val animDrawable = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.splashId).background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(1000)
        animDrawable.start()

        val icon = findViewById<ImageView>(R.id.icon)
        val appName = findViewById<TextView>(R.id.appName)
        val appearAnimation = AnimationUtils.loadAnimation(this, R.anim.appear)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)
        icon.startAnimation(scaleAnimation)
        appName.startAnimation(appearAnimation)
    }
}