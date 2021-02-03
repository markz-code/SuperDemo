package com.zpl.jetpack

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zpl.R

class JetpackDemoActivity : AppCompatActivity() {

    private val TAG = "Lifecycle_Test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_demo)

        //Lifecycle 生命周期
        lifecycle.addObserver(MyObserver())
        Log.i(TAG, "onCreate: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }
}