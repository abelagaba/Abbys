package com.agaba.abbys

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val bundle = intent.extras

        findViewById<ImageView>(R.id.itemDetailsImage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.itemDetailsName).text = bundle!!.getString("name")
        findViewById<TextView>(R.id.calories).text = bundle!!.getString("cal")
        findViewById<TextView>(R.id.itemDescription).text = bundle!!.getString("desc")
        findViewById<TextView>(R.id.itemPrice).text = bundle!!.getString("price")
        findViewById<TextView>(R.id.Ingredients).text = bundle!!.getString("ingrd")
    }
}