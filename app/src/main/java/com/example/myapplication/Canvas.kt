package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Canvas(context: Context?) : View(context){
    var points : ArrayList<Point> = arrayListOf()
    override fun onDraw(canvas: Canvas?) {
        var paint = Paint()
        paint.strokeWidth = 9f
        paint.color = Color.RED
        for(point in points) {
            canvas?.drawCircle(point.x, point.y, 20f, paint)
        }
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        points.add(Point(event!!.x, event!!.y))
        return super.onTouchEvent(event)
    }

    fun update(){
        var listRemove : ArrayList<Point> = arrayListOf()
        for(point in points){
            if(point.y > height)
                listRemove.add(point)
            point.y += 10f
        }

    }
    fun draw(){
        invalidate()
    }
}
class Point(var x: Float,var y:Float){
}