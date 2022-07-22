package com.agaba.abbys

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class  CategoryAdapter: BaseAdapter {
    var listOfCategories= ArrayList<Category>()
    var context: Context?=null
    constructor(context: Context, listOfCategories:ArrayList<Category>):super(){
        this.context=context
        this.listOfCategories=listOfCategories
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val category = this.listOfCategories[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var categoryView= inflator.inflate(R.layout.category_ticket,null)
        categoryView.findViewById<ImageView>(R.id.categoryImage).setImageResource(category.image!!)
        categoryView.findViewById<ImageView>(R.id.categoryImage).setOnClickListener {

            val intent = Intent(context,CategoryDetailsActivity::class.java)
            intent.putExtra("name",category.name!!)
            intent.putExtra("tagline",category.tagline!!)
            context!!.startActivity(intent)
        }
        categoryView.findViewById<TextView>(R.id.categoryName).text = category.name!!

        return  categoryView

    }

    override fun getItem(p0: Int): Any {
        return listOfCategories[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {

        return listOfCategories.size
    }

}