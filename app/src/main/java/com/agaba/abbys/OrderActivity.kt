package com.agaba.abbys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    var orderIcon = findViewById<ImageView>(R.id.order)
    var itemName = findViewById<TextView>(R.id.itemName).text.toString()
    var order:Item? = null
    var orderAdapter:OrderAdapter? = null
    var orderList = ArrayList<Item>()
    var totalCharge = findViewById<TextView>(R.id.totalCharge)
    var total:Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        for(x in orderList){
            total = total?.plus(x.qty!! * x.price!!.toFloat())
        }
        totalCharge.text = total.toString()

    }

    fun order(view: View){
        for (x in listOfItems){
            if(x.name.equals(itemName))
                order = x
        }

        if(orderIcon.drawable.equals(R.drawable.ic_baseline_shopping_bag_black_24)){
            orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_24)
            orderList.add(order!!)
        }else if(orderIcon.drawable.equals(R.drawable.ic_baseline_shopping_bag_24)){
            orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_black_24)
            orderList.remove(order!!)
        }

        orderAdapter = OrderAdapter(this, orderList)
        findViewById<GridView>(R.id.orderGridView).adapter = orderAdapter
    }

    fun removeOrderItem(view: View){
        for (x in orderList){
            if(x.name.equals(itemName))
                order = x
        }

        if(orderIcon.drawable.equals(R.drawable.ic_baseline_shopping_bag_24)){
            orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_black_24)
            orderList.remove(order!!)

            orderAdapter = OrderAdapter(this, orderList)
            findViewById<GridView>(R.id.orderGridView).adapter = orderAdapter

            val orderIntent = Intent(this, OrderActivity::class.java)
                startActivity(orderIntent)
        }
    }
}