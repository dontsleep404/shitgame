package com.example.myapplication.helper

import com.example.myapplication.helper.MyTimer

class Timer(){
    private var lastUpdate : Long = MyTimer.lastUpdate;
    fun isUpdate(time : Long, reset : Boolean) : Boolean{
        if(time <= MyTimer.lastUpdate - lastUpdate){
            if(reset){
                lastUpdate = MyTimer.lastUpdate
            }
            return true;
        }
        return false;
    }
}