package com.agaba.abbys

class Item(
    name: String,
    desc: String,
    price: String,
    cal: String,
    ingrd: String,
    ratg: String,
    image: Int
) {
    var name:String? = name
    var desc:String? = desc
    var price:String? = price
    var cal:String? = cal
    var ingrd:String? = ingrd
    var ratg:String? = ratg
    var image:Int? = image
    var qty:Int? =1
    var favorite:Boolean? =false
    var ordered:Boolean? =false

}
