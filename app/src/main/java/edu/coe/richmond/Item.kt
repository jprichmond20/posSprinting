package edu.coe.richmond

import kotlin.toString as toString1

class Item {
    var name: String? = null
    var price:Double = 0.00


    constructor(){
        this.name = ""
        this.price = 0.00
    }

    constructor(name: String?, price: Double) {
        this.name = name
        this.price = price.toDouble()
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