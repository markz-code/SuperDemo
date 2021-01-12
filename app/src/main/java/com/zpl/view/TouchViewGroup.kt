package com.zpl.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import com.zpl.MainActivity

class TouchViewGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet?) :
    ViewGroup(context, attrs) {

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG);

    init {
        paint.color = Color.BLACK
        paint.textSize = 20f
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val child = getChildAt(0)
        child.layout(l / 2, t / 2, r / 2, b / 2)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName, "TouchViewGroup......dispatchTouchEvent.......")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName, "TouchViewGroup......onInterceptTouchEvent.......")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName, "TouchViewGroup......onTouchEvent.......")
        return true
    }

    // 测试invalidate是否会调用onDraw
    // 结论：每次都会调用onDraw
    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawLine(0f, 0f, 500f, 500f, paint)
        Log.e(TouchViewGroup::class.simpleName,"onDraw................")
        invalidate()
    }
}