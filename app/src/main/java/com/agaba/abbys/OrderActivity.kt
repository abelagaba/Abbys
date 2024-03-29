package com.agaba.abbys

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

var orderList = ArrayList<Item>()
var orderAdapter: OrderAdapter?=null

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val totalCharge = findViewById<TextView>(R.id.totalCharge)
        val checkout = findViewById<Button>(R.id.checkout)
        var total = 0.0f
        
        if(orderList.isEmpty()){
            findViewById<TextView>(R.id.noOrder).visibility = View.VISIBLE
            findViewById<LinearLayout>(R.id.chargeAndCheckout).visibility = View.INVISIBLE
        }else {
            findViewById<TextView>(R.id.noOrder).visibility = View.GONE
            findViewById<LinearLayout>(R.id.chargeAndCheckout).visibility = View.VISIBLE

            for(x in orderList){
                total += (x.qty!!.toFloat()) * (x.price!!.toFloat())
            }
            totalCharge.text = total.toString()

            orderAdapter = OrderAdapter(this, orderList)
            findViewById<GridView>(R.id.orderGridView).adapter = orderAdapter
        }

        checkout.setOnClickListener{
            Snackbar.make(checkout, "Cleared", 3000).show()

            for(x in orderList){
                for(y in listOfItems){
                    if(x.name == y.name)
                        y.ordered = false
                }
            }

            orderList.clear()

            Handler().postDelayed({
                finish()
                startActivity(intent)
            }, 3000)
        }
    }

    override fun onRestart() {
        super.onRestart()

        finish()
        startActivity(intent)
    }
}

