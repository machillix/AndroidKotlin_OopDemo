package com.example.oopdemo

open class Vehicle(val brand : String) {

    public var model_public : String = "NA"

    var model_set_get: String = ""
        get() = field
        set(value) {
            field = value

        }

    var model_private : String = ""
        private set

    init {

        if(model_private == ""){
            model_private = "Model Not Set"
        }
    }


    constructor( brand: String,  model : String):this(brand){
        model_private = model
    }

    open fun accelerate(){

    }

}