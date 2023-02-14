package com.example.myapplication.helper.game

import android.graphics.Canvas
import com.example.myapplication.helper.ui.Panel

class MenuScreen(x: Float, y: Float, width: Float, height: Float) : Panel(x, y, width, height) {
    var menus : ArrayList<Menu> = arrayListOf()
    init{
        menus.add(Menu("Exit") {
            println(3)
        })
    }

    override fun render(canvas: Canvas) {
        super.render(canvas)
    }

    override fun onTouchUp(x: Float, y: Float) {
        super.onTouchUp(x, y)
    }
}
class Menu(var title: String, var action: () -> Unit){}