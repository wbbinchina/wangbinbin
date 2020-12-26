package com.example.wangbinbin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsSpinner
import kotlinx.android.synthetic.main.activity_main.*

const val First="Message"

class MainActivity : AppCompatActivity() {

    val datas= arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_record.setOnClickListener {
            val intent=Intent(this,Second_Activity::class.java)
            intent.putStringArrayListExtra(First,datas)
            startActivity(intent)
        }
    }

    fun onNumber(view: View) {

    }
}

