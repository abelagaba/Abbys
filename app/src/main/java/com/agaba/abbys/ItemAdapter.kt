package com.agaba.abbys

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

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
        itemView.findViewById<TextView>(R.id.rating).text = item.ratg!!
        itemView.findViewById<TextView>(R.id.itemName).text = item.name!!

        var favIcon = itemView.findViewById<ImageView>(R.id.favorite)
        var orderIcon = itemView.findViewById<ImageView>(R.id.addToBag)
        var itemName = itemView.findViewById<TextView>(R.id.itemName).text.toString()

        if(item.favorite!!){
            favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
            favIcon.tag = "fav"
        }else {
            favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            favIcon.tag = "unFav"
        }

        if(item.ordered!!){
            orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_24)
            orderIcon.tag = "ordered"
        }else {
            orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_black_24)
            orderIcon.tag = "removed"
        }

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

        favIcon.setOnClickListener{
            var fav:Item? = null

            if(favIcon.tag == "unFav"){
                favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
                favIcon.tag = "fav"

                for (item in com.agaba.abbys.listOfItems){
                    if(item.name == itemName) {
                        item.favorite = true
                        fav = item
                    }
                }

                listOFFavorites.add(fav!!)

                Snackbar.make(favIcon, "Added ${fav!!.name} to favorites", Snackbar.LENGTH_SHORT).show()
            }else {
                favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                favIcon.tag = "unFav"

                for (item in com.agaba.abbys.listOfItems){
                    if(item.name == itemName) {
                        item.favorite = false
                        fav = item
                    }
                }

                listOFFavorites.remove(fav!!)

                Snackbar.make(favIcon, "Removed ${fav!!.name} from favorites", Snackbar.LENGTH_SHORT).show()
            }
        }

        orderIcon.setOnClickListener{
            var order:Item? = null

            if(orderIcon.tag == "removed"){
                orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_24)
                orderIcon.tag = "added"

                for (item in com.agaba.abbys.listOfItems){
                    if(item.name == itemName){
                        item.ordered = true
                        order = item
                    }
                }

                orderList.add(order!!)

                Snackbar.make(orderIcon, "Added ${order!!.name} to bag", Snackbar.LENGTH_SHORT).show()
            }else {
                orderIcon.setImageResource(R.drawable.ic_baseline_shopping_bag_black_24)
                orderIcon.tag = "removed"

                for (item in com.agaba.abbys.listOfItems){
                    if(item.name == itemName){
                        item.ordered = false
                        order = item
                    }
                }

                orderList.remove(order!!)

                Snackbar.make(orderIcon, "Removed ${order!!.name} from bag", Snackbar.LENGTH_SHORT).show()
            }
        }

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