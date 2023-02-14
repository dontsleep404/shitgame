package com.example.myapplication.helper.game

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.example.myapplication.helper.ui.Panel

class MenuScreen(x: Float, y: Float, width: Float, height: Float) : Panel(x, y, width, height) {
    init{
        addChild(Menu(100f, 100f, width - 200f, 80f, "Start"){
            GameActivity.currentScreen = GameScreen(0f, 0f, GameActivity.width, GameActivity.height)
        })
        addChild(Menu(100f, 200f, width - 200f, 80f, "Menu 1"){
            println("Menu 1")
        })
        addChild(Menu(100f, 300f, width - 200f, 80f, "Menu 2"){
            println("Menu 2")
        })
        addChild(Menu(100f, 400f, width - 200f, 80f, "Menu 3"){
            println("Menu 3")
        })
        addChild(Menu(100f, 500f, width - 200f, 80f, "Menu 4"){
            println("Menu 4")
        })
    }

    override fun render(canvas: Canvas) {
        super.render(canvas)
    }

    override fun onTouchUp(x: Float, y: Float) {
        super.onTouchUp(x, y)
    }

    override fun breakTouch(): Boolean {
        return false
    }
}
class Menu(x: Float, y: Float, width: Float, height: Float,var title: String, var action : () -> Unit) : Panel(x, y, width, height) {
    override fun render(canvas: Canvas) {
        var paint = Paint()
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.textSize = 60f
        canvas.drawRoundRect(0f, 0f, width, height, 10f, 10f, paint)

        paint.style = Paint.Style.FILL
        var bounds = Rect()
        paint.getTextBounds(title, 0, title.length, bounds)
        canvas.drawText(title,width /2 - bounds.width() / 2 , height/2 + bounds.height()/2, paint)
    }
    override fun onTouchUp(x: Float, y: Float) {
        action()
    }
}