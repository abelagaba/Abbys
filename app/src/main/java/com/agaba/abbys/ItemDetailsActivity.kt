package com.agaba.abbys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        findViewById<ImageView>(R.id.ivFoodImage) .setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.tvName) .text = bundle!!.getString("name")
        findViewById<TextView>(R.id.tvDetails).text = bundle!!.getString("des")
    }
}