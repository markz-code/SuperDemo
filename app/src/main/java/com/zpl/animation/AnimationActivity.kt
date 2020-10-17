package com.zpl.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import com.zpl.R


class AnimationActivity : AppCompatActivity() {

    var boolean: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
    }

    fun pathMeasure(view: View) {
        startActivity(Intent(this, PathMeasureActivity::class.java))
    }

    fun svg(view: View) {
        startActivity(Intent(this, VectorDemo::class.java))
    }

    fun bezier(view: View) {
        startActivity(Intent(this, BezierMainActivity::class.java))
    }

    fun floatWindow(view: View) {
        if (boolean) {
            // 添加
            addView()
        } else {
            // 移除
            removeView()
        }
        boolean = !boolean
    }

    private var textView: TextView? = null

    private fun addView() {
        val rootView: View = window.decorView.rootView
        val contentView = rootView.findViewById<FrameLayout>(android.R.id.content)
        if (textView == null) {
            textView = TextView(this)
            textView!!.text = "hello world!"
            textView!!.measure(0, 0)

            val layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            contentView.addView(textView, layoutParams)
        }

        getAnimator(contentView).start()
    }

    private fun getAnimator(contentView: FrameLayout): ObjectAnimator {
        var animator: ObjectAnimator = ObjectAnimator.ofFloat(
            textView!!,
            "translationX",
            contentView.width.toFloat(),
            contentView.width.toFloat() - textView!!.measuredWidth
        )
        animator.duration = 500
        return animator
    }

    private fun removeView() {
        val rootView: View = window.decorView.rootView
        val contentView = rootView.findViewById<FrameLayout>(android.R.id.content)
        getAnimator(contentView).reverse()

//        contentView.removeView(textView)
    }
}
