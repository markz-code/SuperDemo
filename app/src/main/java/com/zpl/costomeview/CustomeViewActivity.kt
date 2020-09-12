package com.zpl.costomeview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zpl.R
import com.zpl.costomeview.view.MaterialEditText

class CustomeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custome_view)
    }

    fun editext(view: View) {
        startActivity(Intent(this,MaterialEditextActivity::class.java))
    }
}
