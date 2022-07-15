package com.agaba.abbys

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class  ItemAdapter: BaseAdapter {
    var listOfItems= ArrayList<Item>()
    var context: Context?=null
    constructor(context: Context, listOfItems:ArrayList<Item>):super(){
        this.context=context
        this.listOfItems=listOfItems
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.listOfItems[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var itemView= inflator.inflate(R.layout.item_ticket,null)
        itemView.findViewById<ImageView>(R.id.backgroundImage).setImageResource(item.img!!)
        itemView.findViewById<ImageView>(R.id.backgroundImage).setOnClickListener {

            val intent = Intent(context,FoodDetailsActivity::class.java)
            intent.putExtra("name",food.name!!)
            intent.putExtra("des",food.des!!)
            intent.putExtra("image",food.image!!)
            context!!.startActivity(intent)
        }
        foodView.findViewById<TextView>(R.id.tvName).text =  food.name!!
        return  foodView

    }

    override fun getItem(p0: Int): Any {
        return listOfItems[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {

        return listOfItems.size
    }

}