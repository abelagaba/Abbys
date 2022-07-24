package com.agaba.abbys

import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

    }

    fun favorite(view: View){
        var favoriteAdapter:ItemAdapter? = null
        var listOFFavorites = ArrayList<Item>()
        var favIcon = findViewById<ImageView>(R.id.favorite)
        var itemName = findViewById<TextView>(R.id.itemName).text.toString()
        var fav:Item? = null

        for (x in listOfItems){
            if(x.name.equals(itemName))
                fav = x
        }

        if(favIcon.drawable.equals(R.drawable.ic_baseline_favorite_border_24)){
            favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
            listOFFavorites.add(fav!!)
        }else if(favIcon.drawable.equals(R.drawable.ic_baseline_favorite_24)){
            favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            listOFFavorites.remove(fav!!)
        }

        favoriteAdapter = ItemAdapter(this, listOFFavorites)
        findViewById<GridView>(R.id.favGridView).adapter = favoriteAdapter
    }

}