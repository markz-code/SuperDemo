package com.zpl.animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zpl.R

class AnimationActivity : AppCompatActivity() {

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
}
