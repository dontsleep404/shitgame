package com.example.myapplication.helper.ui

class Panel (var x : Float, var y : Float, var width : Float, var height : Float){
    private var isTouchDown : Boolean = false
    private var childs : ArrayList<Panel> = arrayListOf()
    fun update(){
        for(child in childs) child.update()
    }
    fun render(){
        for(child in childs) child.render()
    }
    fun addChild(child: Panel){
        childs.add(child)
    }
    fun onTouchDown(x : Float, y : Float){
        for(child in childs)
            if(on(x, y, child)){
                child.onTouchDown(x - child.x, y - child.y)
                child.isTouchDown = true
            }
            else{
                child.isTouchDown = false
            }
    }
    fun onTouchUp(x : Float, y : Float){
        for(child in childs){
            if(on(x, y, child) && child.isTouchDown){
                child.onTouchUp(x - child.x, y - child.y)
                child.onTouch()
            }
            child.isTouchDown = false
        }
    }
    fun onTouch(){
        println("Touch")
    }
    fun breakTouch() = true
    private fun on(x : Float, y : Float, child : Panel): Boolean {
        return x >= child.x && x <= child.x + child.width && y >= child.y && y <= child.y + child.height;
    }
}