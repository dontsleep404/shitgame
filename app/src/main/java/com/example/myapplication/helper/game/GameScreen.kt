package com.example.myapplication.helper.game

import com.example.myapplication.helper.ui.JoyStick
import com.example.myapplication.helper.ui.Panel

class GameScreen(x: Float, y: Float, width: Float, height: Float) : Panel(x, y, width, height) {
    var joyStick: JoyStick = JoyStick(x, y, width, height)
    var entityList : ArrayList<Entity> = arrayListOf()
    init{
        addChild(joyStick)
    }
    override fun update() {
        var angle = joyStick.getAngle()
        angle?.let {

        }
        super.update()
    }
    override fun breakTouch(): Boolean {
        return false
    }
}