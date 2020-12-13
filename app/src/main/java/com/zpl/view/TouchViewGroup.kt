package com.zpl.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import com.zpl.MainActivity

class TouchViewGroup @JvmOverloads constructor(context: Context, attrs: AttributeSet?) :
    ViewGroup(context, attrs) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val child = getChildAt(0)
        child.layout(l / 2, t / 2, r / 2, b / 2)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName,"TouchViewGroup......dispatchTouchEvent.......")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName,"TouchViewGroup......onInterceptTouchEvent.......")
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName,"TouchViewGroup......onTouchEvent.......")
        return true
    }
}