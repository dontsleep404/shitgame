package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.example.myapplication.helper.MyTimer
import com.example.myapplication.helper.Timer


class MainActivity : AppCompatActivity() {
    lateinit var myCanvas: Canvas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.decorView.apply {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
        myCanvas = Canvas(this);
        myCanvas.invalidate()
        setContentView(myCanvas)
        var thread = Thread{
            MyTimer.init()
            var fpsLimit = Timer();
            while(true){
                MyTimer.update()
                if(fpsLimit.isUpdate(10, true)){
                    //update
                    myCanvas.update()
                    //render
                    myCanvas.draw()
                }
            }
        }.start()
    }
}
