package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.DragEvent
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.example.myapplication.helper.game.Game
import com.example.myapplication.helper.ui.Panel

class Canvas(context: Context?) : View(context), View.OnTouchListener{
    var game : Game? = null
    init{
        setOnTouchListener(this)
    }
    override fun onDraw(canvas: Canvas?) {
        if(game == null) game = Game(0f, 0f, width.toFloat(), height.toFloat())
        game?.let{
            game?.update()
        }
        canvas?.let {
            game?.render(canvas)
        }
    }
    override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
        motionEvent!!.let {
            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> game?.onTouchDown(motionEvent.x, motionEvent.y)
                MotionEvent.ACTION_UP -> game?.onTouchUp(motionEvent.x, motionEvent.y)
                MotionEvent.ACTION_MOVE -> game?.onDrag(motionEvent.x, motionEvent.y)
                else -> {}
            }
        }
        return true
    }
}