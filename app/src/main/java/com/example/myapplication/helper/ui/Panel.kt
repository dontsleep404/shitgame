package com.example.myapplication.helper.ui

import android.graphics.Canvas

open class Panel (var x : Float, var y : Float, var width : Float, var height : Float){
    private var isTouchDown : Boolean = false
    private var childs : ArrayList<Panel> = arrayListOf()
    open fun update(){
        for(child in childs) child.update()
    }
    open fun render(canvas : Canvas){
        for(child in childs) child.render(canvas)
    }
    fun addChild(child: Panel){
        childs.add(child)
    }
    open fun onTouchDown(x : Float, y : Float){
        var touch = false;
        for(child in childs)
            if(on(x, y, child) && !touch){
                child.onTouchDown(x - child.x, y - child.y)
                child.isTouchDown = true
                if(breakTouch()) touch = true
            }
            else{
                child.isTouchDown = false
            }
    }
    open fun onTouchUp(x : Float, y : Float){
        for(child in childs){
            if(on(x, y, child) && child.isTouchDown){
                child.onTouchUp(x - child.x, y - child.y)
                child.onTouch()
            }
            child.isTouchDown = false
        }
    }
    open fun onTouch(){
        println("Touch")
    }
    open fun breakTouch() = true
    private fun on(x : Float, y : Float, child : Panel): Boolean {
        return x >= child.x && x <= child.x + child.width && y >= child.y && y <= child.y + child.height;
    }
}