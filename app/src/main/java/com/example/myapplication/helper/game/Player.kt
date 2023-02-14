package com.example.myapplication.helper.game

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Player : Entity() {
    override fun update() {
        super.update()
    }

    override fun render(canvas: Canvas) {
        var paint = Paint()
        paint.strokeWidth = 10f
        paint.color = Color.GREEN
        paint.style = Paint.Style.STROKE
        canvas.drawCircle(x, y, 10f, paint)
    }
}