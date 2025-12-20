package com.example

import java.util.Locale
import java.util.Locale.getDefault

fun main(){
    val s: String = readln()

    var u = 0
    var l = 0

    for (i in s){
        if (i in 'A'..'B'){
            u++
        }else{
            l++
        }
    }

    if (u> l){
        println(s.uppercase(getDefault()))
    }else{
        println(s.lowercase())
    }
}