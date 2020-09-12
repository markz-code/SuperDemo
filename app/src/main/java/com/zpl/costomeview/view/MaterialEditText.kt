package com.zpl.costomeview.view

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import com.zpl.R
import com.zpl.utils.ScreenUtil
import kotlinx.android.synthetic.*

class MaterialEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(context, attrs) {

    private val TAG = MaterialEditText::class.simpleName
    private val TEXT_SIZE = ScreenUtil.pt2Px(12f)
    private val ORIGIN_PADDING = ScreenUtil.pt2Px(8f)
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = (resources.getColor(R.color.colorAccent))
        textSize = TEXT_SIZE.toFloat()
    }
    private var showOrHide: Boolean = false

    private var animator: ValueAnimator? = null

    private var currentValue: Float = 0f

    init {
        setPadding(
            paddingLeft,
            paddingTop + TEXT_SIZE + ORIGIN_PADDING,
            paddingRight,
            paddingBottom
        )

        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty()) {
                    // 隐藏
                    showOrHide = false
                    getValueAnimator().reverse()
                } else {
                    // 展示
                    if (showOrHide) return
                    showOrHide = true
                    getValueAnimator().start()
                }
            }
        })
    }

    fun getValueAnimator(): ValueAnimator {
        if (animator == null) {
            animator = ValueAnimator.ofFloat(0f, 1f)
            animator!!.duration = 1000
            animator!!.addUpdateListener {
                currentValue = it.animatedValue as Float
                invalidate()
            }
        }
        return animator!!
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.alpha = (currentValue * 255).toInt()
        canvas!!.drawText(
            hint.toString(),
            paddingLeft.toFloat(),
            (height - (height - TEXT_SIZE) * (currentValue)),
            paint
        )
    }
}