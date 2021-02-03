package com.zpl.jetpack

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver : LifecycleObserver {

   private val TAG = "Lifecycle_Test"

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun connect() {
        Log.i(TAG, "connect:")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun disConnect() {
        Log.i(TAG, "disConnect: ")
    }
}