package com.agaba.abbys

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ItemDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_item_details)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val bundle = intent.extras
        val qty = findViewById<TextView>(R.id.itemQuantity)
        var qtyInt = qty.text.toString().toInt()
        var itemIndex = 0
        val favIcon = findViewById<ImageView>(R.id.itemFavorite)
        val orderButton = findViewById<Button>(R.id.addItemToBag)
        val itemName = bundle!!.getString("name")

        for (x in listOfItems){
            if(x.name == itemName)
                itemIndex = listOfItems.indexOf(x)
        }

        findViewById<ImageView>(R.id.itemDetailsImage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.itemDetailsName).text = bundle!!.getString("name")
        findViewById<TextView>(R.id.calories).text = bundle!!.getString("cal")
        findViewById<TextView>(R.id.itemDescription).text = bundle!!.getString("desc")
        findViewById<TextView>(R.id.itemPrice).text = bundle!!.getString("price")
        findViewById<TextView>(R.id.itemRating).text = bundle!!.getString("ratg")
        findViewById<TextView>(R.id.Ingredients).text = bundle!!.getString("ingrd")
        
        findViewById<ImageView>(R.id.increaseQty).setOnClickListener {
            qty.text = (++ qtyInt).toString()

            listOfItems[itemIndex].qty = qtyInt
        }

        findViewById<ImageView>(R.id.decreaseQty).setOnClickListener {
            if(qtyInt != 1) {
                qty.text = (--qtyInt).toString()

                listOfItems[itemIndex].qty = qtyInt
            }
        }

        if(listOfItems[itemIndex].favorite!!){
            favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
            favIcon.tag = "fav"
        }else {
            favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            favIcon.tag = "unFav"
        }

        if(listOfItems[itemIndex].ordered!!){
            orderButton.text = "REMOVE FROM BAG"
            orderButton.setTextColor(resources.getColor(R.color.black))
            orderButton.tag = "ordered"
        }else {
            orderButton.text = "ADD TO BAG"
            orderButton.setTextColor(resources.getColor(R.color.white))
            orderButton.tag = "removed"
        }

        favIcon.setOnClickListener {
            if(favIcon.tag == "unFav"){
                favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
                favIcon.tag = "fav"

                listOfItems[itemIndex].favorite = true

                listOFFavorites.add(listOfItems[itemIndex])

                Snackbar.make(favIcon, "Added ${listOfItems[itemIndex].name} to favorites", Snackbar.LENGTH_SHORT).show()
            }else {
                favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                favIcon.tag = "unFav"

                listOfItems[itemIndex].favorite = false

                listOFFavorites.remove(listOfItems[itemIndex])

                Snackbar.make(favIcon, "Removed ${listOfItems[itemIndex].name} from favorites", Snackbar.LENGTH_SHORT).show()
            }
        }

        orderButton.setOnClickListener{
            if(orderButton.tag == "removed"){
                orderButton.text = "REMOVE FROM BAG"
                orderButton.setTextColor(resources.getColor(R.color.black))
                orderButton.tag = "added"

                listOfItems[itemIndex].ordered = true

                orderList.add(listOfItems[itemIndex])

                Snackbar.make(orderButton, "Added ${listOfItems[itemIndex].name} to bag", Snackbar.LENGTH_SHORT).show()
            }else {
                orderButton.text = "ADD TO BAG"
                orderButton.setTextColor(resources.getColor(R.color.white))
                orderButton.tag = "removed"

                listOfItems[itemIndex].ordered = false

                orderList.remove(listOfItems[itemIndex])

                Snackbar.make(orderButton, "Removed ${listOfItems[itemIndex].name} from bag", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    fun showPopup(view: View){
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater

        inflater.inflate(R.menu.activity_menu, popup.menu)

        popup.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.favoritesActivity -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
                    this.startActivity(intent)
                }

                R.id.orderActivity -> {
                    val intent = Intent(this, OrderActivity::class.java)
                    this.startActivity(intent)
                }
            }
            true
        }
        popup.show()
    }

}