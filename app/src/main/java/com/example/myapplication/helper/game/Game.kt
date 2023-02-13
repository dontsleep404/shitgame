package com.example.myapplication.helper.game

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.myapplication.helper.Timer
import com.example.myapplication.helper.ui.Panel
import kotlin.random.Random

class Game(x: Float, y: Float, width: Float, height: Float) : Panel(x, y, width, height) {
    var points : ArrayList<Point> = arrayListOf()
    var timer = Timer()
    var rand = Random(333)
    init{
        for(i in 1..10){
            points.add(Point(width / 2,height/2, rand.nextFloat() * 20f - 10f, rand.nextFloat() * 20f - 10f))
        }
    }
    override fun render(canvas : Canvas){
        var paint = Paint()
        paint.strokeWidth = 9f
        paint.color = Color.GREEN
        paint.textSize = 80f
        for(point in points) {
            canvas.drawText("Lol", point.x, point.y, paint)
        }
        super.render(canvas)
    }

    override fun update() {
        for(point in points){
            if(point.x <= 0 || point.x >= width.toFloat()) point.mx = 0 - point.mx
            if(point.y <= 0 || point.y >= height.toFloat()) point.my = 0 - point.my
            point.x += point.mx
            point.y += point.my
        }
        super.update()
    }
}
class Point(var x: Float,var y:Float, var mx: Float, var my: Float){}