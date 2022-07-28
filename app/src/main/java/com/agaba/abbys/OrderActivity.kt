package com.agaba.abbys

import android.os.Bundle
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var orderList = ArrayList<Item>()

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var orderAdapter:OrderAdapter? = null
        var totalCharge = findViewById<TextView>(R.id.totalCharge)
        var total:Float? = null

        for(x in orderList){
            total = total?.plus(x.qty!! * x.price!!.toFloat())
        }
        totalCharge.text = total.toString()

        orderAdapter = OrderAdapter(this, orderList)
        findViewById<GridView>(R.id.orderGridView).adapter = orderAdapter
    }
}