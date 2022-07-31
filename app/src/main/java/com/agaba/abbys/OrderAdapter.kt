package com.agaba.abbys

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class  OrderAdapter: BaseAdapter {
    var listOfItems= ArrayList<Item>()
    var context: Context?=null
    constructor(context: Context, listOfItems:ArrayList<Item>):super(){
        this.context=context
        this.listOfItems=listOfItems
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.listOfItems[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var orderItemView= inflator.inflate(R.layout.order_ticket,null)

        orderItemView.findViewById<ImageView>(R.id.orderImage).setImageResource(item.image!!)
        orderItemView.findViewById<TextView>(R.id.orderItemName).text = item.name!!
        orderItemView.findViewById<TextView>(R.id.orderItemRating).text = item.ratg!!
        orderItemView.findViewById<TextView>(R.id.orderItemQuantity).text = item.qty!!.toString()
        orderItemView.findViewById<TextView>(R.id.orderItemPrice).text = item.price!!

        orderItemView.findViewById<ImageView>(R.id.orderImage).setOnClickListener {

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

        orderItemView.findViewById<ImageView>(R.id.removeOrderItem).setOnClickListener {
            var itemName = item.name!!
            var itemIndex = 0

            for (x in com.agaba.abbys.listOfItems){
                if(x.name == itemName)
                    itemIndex = com.agaba.abbys.listOfItems.indexOf(x)
            }

            orderList.remove(com.agaba.abbys.listOfItems[itemIndex])

            com.agaba.abbys.listOfItems[itemIndex].ordered = false
        }

        return  orderItemView
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