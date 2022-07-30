package com.agaba.abbys

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.view.WindowManager
import android.widget.GridView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var listOfItems =ArrayList<Item>()

var restarted: Boolean = false

var mmsws: Item? = null
var mmtms: Item? = null
var cc: Item? = null
var sprite: Item? = null
var dpp: Item? = null
var fo: Item? = null
var dc: Item? = null
var sbs: Item? = null
var hch: Item? = null
var becb: Item? = null
var becg: Item? = null
var bb: Item? = null
var hc: Item? = null
var fmo: Item? = null
var bm: Item? = null
var qpwc: Item? = null
var cb: Item? = null
var hb: Item? = null
var ccs: Item? = null
var cn: Item? = null
var fof: Item? = null
var cs: Item? = null
var hcs: Item? = null
var bap: Item? = null
var ccc: Item? = null
var fr: Item? = null
var aps: Item? = null

class CategoryDetailsActivity : AppCompatActivity() {

    var itemAdapter:ItemAdapter?=null

    var listOfBeverages =ArrayList<Item>()
    var listOfBreakfast =ArrayList<Item>()
    var listOfBurgers =ArrayList<Item>()
    var listOfChickenAndSandwiches =ArrayList<Item>()
    var listOfDessertsAndShakes =ArrayList<Item>()
    var listOfSnacksAndSides =ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_category_details)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val bundle=intent.extras

        if(!restarted){
            mmsws = Item(getString(R.string.mmsws), getString(R.string.mmsws_desc), getString(R.string.mmsws_price), getString(R.string.mmsws_cal), getString(R.string.mmsws_ingrd), getString(R.string.mmsws_ratg), R.drawable.minute_maid_strawberry_watermelon_slushie)
            mmtms = Item(getString(R.string.mmtms), getString(R.string.mmtms_desc), getString(R.string.mmtms_price), getString(R.string.mmtms_cal), getString(R.string.mmtms_ingrd), getString(R.string.mmtms_ratg), R.drawable.minute_maid_tropical_mango_slushie)
            cc = Item(getString(R.string.cc), getString(R.string.cc_desc), getString(R.string.cc_price), getString(R.string.cc_cal), getString(R.string.cc_ingrd), getString(R.string.cc_ratg), R.drawable.coca_cola)
            sprite = Item(getString(R.string.sprite), getString(R.string.sprite_desc), getString(R.string.sprite_price), getString(R.string.sprite_cal), getString(R.string.sprite_ingrd), getString(R.string.sprite_ratg), R.drawable.sprite)
            dpp = Item(getString(R.string.dpp), getString(R.string.dpp_desc), getString(R.string.dpp_price), getString(R.string.dpp_cal), getString(R.string.dpp_ingrd), getString(R.string.dpp_ratg), R.drawable.dr_pepper)
            fo = Item(getString(R.string.fo), getString(R.string.fo_desc), getString(R.string.fo_price), getString(R.string.fo_cal), getString(R.string.fo_ingrd), getString(R.string.fo_ratg), R.drawable.fanta_orange)
            dc = Item(getString(R.string.dc), getString(R.string.dc_desc), getString(R.string.dc_price), getString(R.string.dc_cal), getString(R.string.dc_ingrd), getString(R.string.dc_ratg), R.drawable.diet_coke)
            sbs = Item(getString(R.string.sbs), getString(R.string.sbs_desc), getString(R.string.sbs_price), getString(R.string.sbs_cal), getString(R.string.sbs_ingrd), getString(R.string.sbs_ratg), R.drawable.strawberry_banana_smoothie)
            hch = Item(getString(R.string.hch), getString(R.string.hch_desc), getString(R.string.hch_price), getString(R.string.hch_cal), getString(R.string.hch_ingrd), getString(R.string.hch_ratg), R.drawable.hot_chocolate)
            becb = Item(getString(R.string.becb), getString(R.string.becb_desc), getString(R.string.becb_price), getString(R.string.becb_cal), getString(R.string.becb_ingrd), getString(R.string.becb_ratg), R.drawable.bacon_egg_and_cheese_biscuit)
            becg = Item(getString(R.string.becg), getString(R.string.becg_desc), getString(R.string.becg_price), getString(R.string.becg_cal), getString(R.string.becg_ingrd), getString(R.string.becg_ratg), R.drawable.bacon_egg_griddle)
            bb = Item(getString(R.string.bb), getString(R.string.bb_desc), getString(R.string.bb_price), getString(R.string.bb_cal), getString(R.string.bb_ingrd), getString(R.string.bb_ratg), R.drawable.big_breakfast)
            hc = Item(getString(R.string.hc), getString(R.string.hc_desc), getString(R.string.hc_price), getString(R.string.hc_cal), getString(R.string.hc_ingrd), getString(R.string.hc_ratg), R.drawable.hot_cakes)
            fmo = Item(getString(R.string.fmo), getString(R.string.fmo_desc), getString(R.string.fmo_price), getString(R.string.fmo_cal), getString(R.string.fmo_ingrd), getString(R.string.fmo_ratg), R.drawable.fruit_and_maple_oatmeal)
            bm = Item(getString(R.string.bm), getString(R.string.bm_desc), getString(R.string.bm_price), getString(R.string.bm_cal), getString(R.string.bm_ingrd), getString(R.string.bm_ratg), R.drawable.big_mac)
            qpwc = Item(getString(R.string.qpwc), getString(R.string.qpwc_desc), getString(R.string.qpwc_price), getString(R.string.qpwc_cal), getString(R.string.qpwc_ingrd), getString(R.string.qpwc_ratg), R.drawable.quarter_pounder_with_cheese)
            cb = Item(getString(R.string.cb), getString(R.string.cb_desc), getString(R.string.cb_price), getString(R.string.cb_cal), getString(R.string.cb_ingrd), getString(R.string.cb_ratg), R.drawable.cheeseburger)
            hb = Item(getString(R.string.hb), getString(R.string.hb_desc), getString(R.string.hb_price), getString(R.string.hb_cal), getString(R.string.hb_ingrd), getString(R.string.hb_ratg), R.drawable.hamburger)
            ccs = Item(getString(R.string.ccs), getString(R.string.ccs_desc), getString(R.string.ccs_price), getString(R.string.ccs_cal), getString(R.string.ccs_ingrd), getString(R.string.ccs_ratg), R.drawable.crispy_chicken_sandwich)
            cn = Item(getString(R.string.cn), getString(R.string.cn_desc), getString(R.string.cn_price), getString(R.string.cn_cal), getString(R.string.cn_ingrd), getString(R.string.cn_ratg), R.drawable.chicken_nuggets)
            fof = Item(getString(R.string.fof), getString(R.string.fof_desc), getString(R.string.fof_price), getString(R.string.fof_cal), getString(R.string.fof_ingrd), getString(R.string.fof_ratg), R.drawable.filet_o_fish)
            cs = Item(getString(R.string.cs), getString(R.string.cs_desc), getString(R.string.cs_price), getString(R.string.cs_cal), getString(R.string.cs_ingrd), getString(R.string.cs_ratg), R.drawable.chocolate_shake)
            hcs = Item(getString(R.string.hcs), getString(R.string.hcs_desc), getString(R.string.hcs_price), getString(R.string.hcs_cal), getString(R.string.hcs_ingrd), getString(R.string.hcs_ratg), R.drawable.hot_caramel_sundae)
            bap = Item(getString(R.string.bap), getString(R.string.bap_desc), getString(R.string.bap_price), getString(R.string.bap_cal), getString(R.string.bap_ingrd), getString(R.string.bap_ratg), R.drawable.baked_apple_pie)
            ccc = Item(getString(R.string.ccc), getString(R.string.ccc_desc), getString(R.string.ccc_price), getString(R.string.ccc_cal), getString(R.string.ccc_ingrd), getString(R.string.ccc_ratg), R.drawable.chocolate_chip_cookie)
            fr = Item(getString(R.string.fr), getString(R.string.fr_desc), getString(R.string.fr_price), getString(R.string.fr_cal), getString(R.string.fr_ingrd), getString(R.string.fr_ratg), R.drawable.fries)
            aps = Item(getString(R.string.aps), getString(R.string.aps_desc), getString(R.string.aps_price), getString(R.string.aps_cal), getString(R.string.aps_ingrd), getString(R.string.aps_ratg), R.drawable.apple_slices)

            listOfItems.add(mmsws!!)
            listOfItems.add(mmtms!!)
            listOfItems.add(cc!!)
            listOfItems.add(sprite!!)
            listOfItems.add(dpp!!)
            listOfItems.add(fo!!)
            listOfItems.add(dc!!)
            listOfItems.add(sbs!!)
            listOfItems.add(hch!!)
            listOfItems.add(becb!!)
            listOfItems.add(becg!!)
            listOfItems.add(bb!!)
            listOfItems.add(hc!!)
            listOfItems.add(fmo!!)
            listOfItems.add(bm!!)
            listOfItems.add(qpwc!!)
            listOfItems.add(cb!!)
            listOfItems.add(hb!!)
            listOfItems.add(ccs!!)
            listOfItems.add(cn!!)
            listOfItems.add(fof!!)
            listOfItems.add(cs!!)
            listOfItems.add(hcs!!)
            listOfItems.add(bap!!)
            listOfItems.add(ccc!!)
            listOfItems.add(fr!!)
            listOfItems.add(aps!!)

            listOfItems.elementAt(0)
        }

        when(bundle!!.getString("name")){
            "Beverages" -> {
                findViewById<TextView>(R.id.category).text = bundle!!.getString("name")
                findViewById<TextView>(R.id.tagline).text = bundle!!.getString("tagline")

                listOfBeverages.clear()
                listOfBeverages.add(listOfItems[listOfItems.indexOf(mmsws)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(mmtms)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(cc)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(sprite)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(dpp)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(fo)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(dc)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(sbs)])
                listOfBeverages.add(listOfItems[listOfItems.indexOf(hch)])

                itemAdapter = ItemAdapter(this, listOfBeverages)
                findViewById<GridView>(R.id.itemGridView).adapter = itemAdapter
            }

            "Breakfast" -> {
                findViewById<TextView>(R.id.category).text = bundle!!.getString("name")
                findViewById<TextView>(R.id.tagline).text = bundle!!.getString("tagline")

                listOfBreakfast.clear()
                listOfBreakfast.add(listOfItems[listOfItems.indexOf(becb)])
                listOfBreakfast.add(listOfItems[listOfItems.indexOf(becg)])
                listOfBreakfast.add(listOfItems[listOfItems.indexOf(bb)])
                listOfBreakfast.add(listOfItems[listOfItems.indexOf(hc)])
                listOfBreakfast.add(listOfItems[listOfItems.indexOf(fmo)])

                itemAdapter = ItemAdapter(this, listOfBreakfast)
                findViewById<GridView>(R.id.itemGridView).adapter = itemAdapter
            }

            "Burgers" -> {
                findViewById<TextView>(R.id.category).text = bundle!!.getString("name")
                findViewById<TextView>(R.id.tagline).text = bundle!!.getString("tagline")

                listOfBurgers.clear()
                listOfBurgers.add(listOfItems[listOfItems.indexOf(bm)])
                listOfBurgers.add(listOfItems[listOfItems.indexOf(qpwc)])
                listOfBurgers.add(listOfItems[listOfItems.indexOf(cb)])
                listOfBurgers.add(listOfItems[listOfItems.indexOf(hb)])

                itemAdapter = ItemAdapter(this, listOfBurgers)
                findViewById<GridView>(R.id.itemGridView).adapter = itemAdapter
            }

            "Chicken & Sandwiches" -> {
                findViewById<TextView>(R.id.category).text = bundle!!.getString("name")
                findViewById<TextView>(R.id.tagline).text = bundle!!.getString("tagline")

                listOfChickenAndSandwiches.clear()
                listOfChickenAndSandwiches.add(listOfItems[listOfItems.indexOf(ccs)])
                listOfChickenAndSandwiches.add(listOfItems[listOfItems.indexOf(cn)])
                listOfChickenAndSandwiches.add(listOfItems[listOfItems.indexOf(fof)])

                itemAdapter = ItemAdapter(this, listOfChickenAndSandwiches)
                findViewById<GridView>(R.id.itemGridView).adapter = itemAdapter
            }

            "Desserts & Shakes" -> {
                findViewById<TextView>(R.id.category).text = bundle!!.getString("name")
                findViewById<TextView>(R.id.tagline).text = bundle!!.getString("tagline")

                listOfDessertsAndShakes.clear()
                listOfDessertsAndShakes.add(listOfItems[listOfItems.indexOf(cs)])
                listOfDessertsAndShakes.add(listOfItems[listOfItems.indexOf(hcs)])
                listOfDessertsAndShakes.add(listOfItems[listOfItems.indexOf(bap)])
                listOfDessertsAndShakes.add(listOfItems[listOfItems.indexOf(ccc)])

                itemAdapter = ItemAdapter(this, listOfDessertsAndShakes)
                findViewById<GridView>(R.id.itemGridView).adapter = itemAdapter
            }

            "Snacks & Sides" -> {
                findViewById<TextView>(R.id.category).text = bundle!!.getString("name")
                findViewById<TextView>(R.id.tagline).text = bundle!!.getString("tagline")

                listOfSnacksAndSides.clear()
                listOfSnacksAndSides.add(listOfItems[listOfItems.indexOf(fr)])
                listOfSnacksAndSides.add(listOfItems[listOfItems.indexOf(aps)])

                itemAdapter = ItemAdapter(this, listOfSnacksAndSides)
                findViewById<GridView>(R.id.itemGridView).adapter = itemAdapter
            }
        }

        restarted = true
    }

    override fun onRestart() {
        super.onRestart()

        finish()
        startActivity(intent)
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