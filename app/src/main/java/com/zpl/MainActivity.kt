package com.zpl

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zpl.animation.AnimationActivity
import com.zpl.costomeview.CustomeViewActivity
import com.zpl.jetpack.JetpackDemoActivity
import com.zpl.sqlite.SqliteActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun animation(view: View) {
        startActivity(Intent(this, AnimationActivity::class.java))
    }

    fun customeView(view: View) {
        startActivity(Intent(this, CustomeViewActivity::class.java))
    }

    fun sqlite(view: View) {
        startActivity(Intent(this, SqliteActivity::class.java))
    }

    fun jetpack(view: View) {
        startActivity(Intent(this, JetpackDemoActivity::class.java))
    }

}
