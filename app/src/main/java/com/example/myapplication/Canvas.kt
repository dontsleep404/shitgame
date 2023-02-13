package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import com.example.myapplication.helper.game.Game

class Canvas(context: Context?) : View(context){
    var game : Game? = null
    override fun onDraw(canvas: Canvas?) {
        if(game == null) game = Game(0f, 0f, width.toFloat(), height.toFloat())
        canvas?.let {
            game?.render(canvas)
        }
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    fun update(){
        game?.let{
            game?.update()
        }
    }
    fun draw(){
        invalidate()
    }
}