package com.zpl.jetpack

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel:ViewModel() {

    private var userLiveData: MutableLiveData<String>? = null
    private var loadingLiveData: MutableLiveData<Boolean>? = null

    fun UserViewModel() {
        userLiveData = MutableLiveData()
        loadingLiveData = MutableLiveData()
    }

    //获取用户信息,假装网络请求 2s后 返回用户信息
    fun getUserInfo() {
        loadingLiveData!!.setValue(true)
        object : AsyncTask<Void?, Void?, String>() {
            override fun onPostExecute(s: String) {
                loadingLiveData!!.setValue(false)
                userLiveData!!.setValue(s) //抛出用户信息
            }
            override fun doInBackground(vararg params: Void?): String {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                return "我是胡飞洋，公众号名字也是胡飞洋，欢迎关注~"
            }
        }.execute()
    }

    fun getUserLiveData(): LiveData<String>? {
        return userLiveData
    }

    fun getLoadingLiveData(): LiveData<Boolean>? {
        return loadingLiveData
    }

}