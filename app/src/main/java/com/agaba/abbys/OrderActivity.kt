package com.agaba.abbys

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar

var orderList = ArrayList<Item>()

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var orderAdapter: OrderAdapter
        var totalCharge = findViewById<TextView>(R.id.totalCharge)
        val checkout = findViewById<Button>(R.id.checkout)
        var total:Float? = 0.0f

        if(orderList.isEmpty()){
            findViewById<TextView>(R.id.noOrder).visibility = View.VISIBLE
            findViewById<LinearLayout>(R.id.chargeAndCheckout).visibility = View.INVISIBLE
        }else {
            for(x in orderList){
                total = total?.plus(x.qty!! * x.price!!.toFloat())
            }
            totalCharge.text = total.toString()

            orderAdapter = OrderAdapter(this, orderList)
            findViewById<GridView>(R.id.orderGridView).adapter = orderAdapter
        }

        checkout.setOnClickListener{
            Snackbar.make(checkout, "Cleared", LENGTH_SHORT).show()

            orderList.clear()

            finish()
            startActivity(intent)
        }
    }
}