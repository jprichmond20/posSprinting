package edu.coe.richmond

import kotlin.toString as toString1

class Item {
    var name: String? = null
    var price:Int = 0


    constructor(){
        this.name = ""
        this.price = 0
    }

    constructor(name: String?, price: Int) {
        this.name = name
        this.price = price
    }

    var foodName: String?
        get() = name.toString1()
        set(v) {
            name = v.toString1()
        }
    var foodPrice: String
        get() = price.toString()
        set(value) {}
}