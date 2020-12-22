package com.hanseungheon.pencil

import android.util.Log

open class Person(var name:String, var gender:Int, var isAlive:Boolean) {
    fun walk(){
        Log.d(name, "앞으로 간다")
    }
    fun think(content:String){
        Log.d(name, "${content}에 대해 생각한다")
    }
    fun eat(menu:String):Boolean{
        Log.d(name, "${menu}을 먹는다")
        return menu=="밥" || menu=="떡볶이" || menu=="라면"
    }
}