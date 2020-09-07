package com.zpl.animation.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import java.util.jar.Attributes

class PathPosTanView @JvmOverloads constructor(context: Context, attributes: AttributeSet? = null) :
    View(context, attributes),
    View.OnClickListener {

    private val mPath: Path = Path()
    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }
    private val mPathMeasure = PathMeasure()
    private val mPos = FloatArray(2)
    private val mTan = FloatArray(2)
    private val mAnimator: ValueAnimator
    private var mCurrentValue: Float = 0.0f

    init {
        mPath.addCircle(0f, 0f, 200f, Path.Direction.CW)
        mPathMeasure.setPath(mPath, false)
        setOnClickListener(this)
        mAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 3000
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                mCurrentValue = it.animatedValue as Float
                invalidate()
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPathMeasure.getPosTan(mCurrentValue * mPathMeasure.length, mPos, mTan)
        // 求出当前点的切线角度
        var degree = (Math.atan2(mTan[1].toDouble(), mTan[0].toDouble()) * 180 / Math.PI).toFloat()

        canvas!!.apply {
            save()
            translate(400f, 400f)
            drawPath(mPath, mPaint)
            drawCircle(mPos[0], mPos[1], 10f, mPaint)
            rotate(degree)
            drawLine(0f, -200f, 300f, -200f, mPaint)
            restore()
        }
    }

    override fun onClick(p0: View?) {
        mAnimator.start()
    }
}