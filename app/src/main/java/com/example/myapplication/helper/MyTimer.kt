package com.example.myapplication.helper

import java.lang.Long.max
import java.util.Date

class MyTimer {
    companion object{
        var lastUpdate : Long = 0
        var deltaTimer : Long = 1
        fun init(){
            lastUpdate = Date().time
        }
        fun update(){
            var now = Date().time
            deltaTimer = max(now - lastUpdate, 1)
            lastUpdate = now
        }
    }
}