package com.zpl.jetpack

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zpl.R


class JetpackDemoActivity : AppCompatActivity() {

    private val TAG = "Lifecycle_Test"

//    private  var mLiveData : MutableLiveData<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_demo)

        //Lifecycle 生命周期
        lifecycle.addObserver(MyObserver())
        Log.i(TAG, "onCreate: ")

        //liveData基本使用
        //liveData基本使用
//        mLiveData = MutableLiveData()
//        mLiveData!!.observe(this, object : Observer<String?> {
//
//            override fun onChanged(t: String?) {
//                Log.i(TAG, "onChanged: $t")
//            }
//        })
//        // //activity是非活跃状态，不会回调onChanged。变为活跃时，value被onStart中的value覆盖
//        mLiveData!!.setValue("onCreate")

        val tvUserName = findViewById<TextView>(R.id.textView)
        val pbLoading = findViewById<ProgressBar>(R.id.pb_loading)
        //获取ViewModel实例

//        val viewModelProvider = ViewModelProvider(
//            this)
        val userViewModel: UserViewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(UserViewModel::class.java)

        //观察 用户信息
        userViewModel.getUserLiveData()!!
            .observe(this, Observer { s -> // update ui.
                tvUserName.text = s
            })

        userViewModel.getLoadingLiveData()!!
            .observe(this,
                Observer { aBoolean ->
                    pbLoading.visibility = if (aBoolean) View.VISIBLE else View.GONE
                })

        //点击按钮获取用户信息
        findViewById<View>(R.id.button).setOnClickListener { userViewModel.getUserInfo() }
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
        //活跃状态，会回调onChanged。并且value会覆盖onCreate、onStop中设置的value
//        mLiveData!!.value = "onStart"
    }

}

