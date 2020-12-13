package com.zpl.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.zpl.MainActivity

class Touch @JvmOverloads constructor(context: Context, attrs: AttributeSet?) :
    View(context, attrs) {

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        Log.e(MainActivity::class.simpleName, "Touch......dispatchTouchEvent.......")
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e(
            MainActivity::class.simpleName,
            "Touch......onTouchEvent......."
        )
        return false
    }
}