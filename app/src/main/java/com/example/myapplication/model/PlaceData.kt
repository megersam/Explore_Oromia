package com.example.myapplication.model

class PlaceData {
    // set data
    var name :String? = null
    var info :String? = null
    var img :String? = null
    constructor()

    constructor(
        name: String?,
        info: String?,
        img: String?
    ){
        this.name = name
        this.info = info
        this.img = img
    }
}