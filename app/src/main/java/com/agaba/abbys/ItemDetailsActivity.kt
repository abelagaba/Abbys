package com.agaba.abbys

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItemDetailsActivity : AppCompatActivity() {

    val bundle = intent.extras
    var qty = findViewById<TextView>(R.id.itemQuantity)
    var qtyInt = qty.text.toString().toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_item_details)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        findViewById<ImageView>(R.id.itemDetailsImage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.itemDetailsName).text = bundle!!.getString("name")
        findViewById<TextView>(R.id.calories).text = bundle!!.getString("cal")
        findViewById<TextView>(R.id.itemDescription).text = bundle!!.getString("desc")
        findViewById<TextView>(R.id.itemPrice).text = bundle!!.getString("price")
        findViewById<TextView>(R.id.Ingredients).text = bundle!!.getString("ingrd")
    }

    fun increaseQty(view: View){
        qty.text = (++ qtyInt).toString()

        for (x in listOfItems){
            if(x.name.equals(bundle!!.getString("name")))
                x.qty = qtyInt
        }
    }

    fun decreaseQty(view: View){
        if(qtyInt != 0)
            qty.text = (-- qtyInt).toString()
        else return

        for (x in listOfItems){
            if(x.name.equals(bundle!!.getString("name")))
                x.qty = qtyInt
        }
    }
}