package com.agaba.abbys

class Item {
    var name:String? =null
    var desc:String? =null
    var price:Int? =null
    var cal:String? =null
    var ingrd:String? =null
    var ratg:Int? =null
    var img:Int? =null

    constructor(name:String, desc:String, price:Int, cal:String, ingrd:String, ratg:Int, img:Int){
        this.name=name
        this.desc=desc
        this.price=price
        this.cal=cal
        this.ingrd=ingrd
        this.ratg=ratg
        this.img=img
    }
}