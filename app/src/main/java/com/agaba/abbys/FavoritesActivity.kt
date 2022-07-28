package com.agaba.abbys

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var listOFFavorites = ArrayList<Item>()

class FavoritesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        var favoriteAdapter:ItemAdapter? = null

        if(listOFFavorites == null){
            findViewById<TextView>(R.id.noFavorites).visibility = VISIBLE
            findViewById<TextView>(R.id.noFavorites).text = "Your Favorites will appear here"
        }else {
            favoriteAdapter = ItemAdapter(this, listOFFavorites)
            findViewById<GridView>(R.id.favGridView).adapter = favoriteAdapter
        }
    }
}