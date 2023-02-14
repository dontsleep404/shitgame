package com.example.myapplication.helper.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.math.*

class JoyStick(x: Float, y: Float, width: Float, height: Float) : Panel(x, y, width, height) {
    var oldTouch : Touch? = null
    var newTouch : Touch? = null
    override fun breakTouch(): Boolean {
        return false
    }

    override fun render(canvas: Canvas) {
        var paint = Paint()
        paint.strokeWidth = 10f
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        oldTouch?.let {
            canvas.drawCircle(oldTouch!!.posX, oldTouch!!.posY, 200f, paint)
            newTouch?.let {
                var angle = oldTouch!!.getAngle(newTouch!!)
                if(newTouch!!.getDist(oldTouch!!) >= 200f)
                    canvas.drawCircle(200f * cos(angle) + oldTouch!!.posX, 200f * sin(angle) + oldTouch!!.posY, 100f, paint)
                else{
                    canvas.drawCircle(newTouch!!.posX, newTouch!!.posY, 100f, paint)
                }
            }
        }


        super.render(canvas)
    }
    fun getAngle() : Float?{
        if(newTouch != null && oldTouch != null)
            return oldTouch!!.getAngle(newTouch!!)
        return null;
    }
    override fun update() {
        super.update()
    }

    override fun onTouchDown(x: Float, y: Float) {
        oldTouch = Touch(x, y)
        super.onTouchDown(x, y)
    }

    override fun onTouchUp(x: Float, y: Float) {
        oldTouch = null
        newTouch = null
        super.onTouchUp(x, y)
    }

    override fun onDrag(x: Float, y: Float) {
        newTouch = Touch(x, y)
        super.onDrag(x, y)
    }
}