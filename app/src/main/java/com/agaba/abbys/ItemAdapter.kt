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
        itemView.findViewById<ImageView>(R.id.itemImage).setImageResource(item.image!!)
        itemView.findViewById<ImageView>(R.id.itemImage).setOnClickListener {

            val intent = Intent(context,ItemDetailsActivity::class.java)
            intent.putExtra("name",item.name!!)
            intent.putExtra("desc",item.desc!!)
            intent.putExtra("price",item.price!!)
            intent.putExtra("cal",item.cal!!)
            intent.putExtra("ingrd",item.ingrd!!)
            intent.putExtra("ratg",item.ratg!!)
            intent.putExtra("image",item.image!!)
            context!!.startActivity(intent)
        }
        itemView.findViewById<TextView>(R.id.rating).text = item.ratg!!
        itemView.findViewById<TextView>(R.id.itemName).text = item.name!!

        return  itemView

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