package com.agaba.abbys

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var categoryAdapter:CategoryAdapter?=null
    var listOfCategories =ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        listOfCategories.add(Category("Beverages", "Quenching your thirst has never been this tasty", R.drawable.beverages))
        listOfCategories.add(Category("Breakfast", "Start your day full", R.drawable.breakfast))
        listOfCategories.add(Category("Burgers", "Char-grilled and flavor-fllled", R.drawable.burgers))
        listOfCategories.add(Category("Chicken & Sandwiches", "See and taste the crunch", R.drawable.chicken_and_sandwiches))
        listOfCategories.add(Category("Desserts & Shakes", "If your sweet tooth is calling...", R.drawable.desserts_and_shakes))
        listOfCategories.add(Category("Snacks & Sides", "We're all about the foodie lifestyle", R.drawable.snacks_and_sides))

        categoryAdapter = CategoryAdapter(this, listOfCategories)
        findViewById<GridView>(R.id.mainGridView).adapter = categoryAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.activity_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }
}

