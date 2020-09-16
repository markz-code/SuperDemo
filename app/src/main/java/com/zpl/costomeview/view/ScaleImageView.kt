package com.zpl.costomeview.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import com.zpl.utils.ScreenUtil

class ScaleImageView @JvmOverloads constructor(context: Context, attributes: AttributeSet? = null) :
    View(context, attributes), GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

    private var avatar: Bitmap = ScreenUtil.getAvatar(resources, ScreenUtil.pt2Px(100f))
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var originOffsetX: Float = 0f
    private var originOffsetY: Float = 0f
    private val gestureDetectorCompat = GestureDetectorCompat(context, this)
    private var smallScale: Float = 0f
    private var bigScale: Float = 0f


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        originOffsetX = (w - avatar.width) / 2f
        originOffsetY = (h - avatar.height) / 2f

        if ((w / avatar.width) > (h / avatar.height)) {
            smallScale = (h / avatar.height).toFloat()
            bigScale = (w / avatar.width).toFloat()
        } else {
            smallScale = (w / avatar.width).toFloat()
            bigScale = (h / avatar.height).toFloat()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetectorCompat.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.scale(smallScale, smallScale,width/2f,height/2f)
        canvas.drawBitmap(avatar, originOffsetX, originOffsetY, paint)
    }

    override fun onShowPress(e: MotionEvent?) {
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {

        return false
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        return true
    }

}