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

/**
 * 路径动画（getSegment）
 */
class PathTracingView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null
) :
    View(context, attributes),
    View.OnClickListener {

    private val mDst = Path()
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
    private var mLength: Float

    init {
        mPath.addCircle(400f, 400f, 100f, Path.Direction.CW)
        mPathMeasure.setPath(mPath, true)
        mLength = mPathMeasure.length
        setOnClickListener(this)
        mAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                mCurrentValue = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mDst.reset()
        // 此处不加好像有bug
        mDst.lineTo(0f, 0f)
        var stop = mLength * mCurrentValue
        var start = stop - (0.5f - Math.abs(mCurrentValue - 0.5)) * mLength

        mPathMeasure.getSegment(start.toFloat(), stop, mDst, true)
        canvas!!.drawPath(mDst, mPaint)
    }

    override fun onClick(p0: View?) {

    }
}