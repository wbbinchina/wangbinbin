package com.example.wangbinbin

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second_.*

class Second_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_)
        val stringList=intent.getStringArrayListExtra(First)
        val adapter= stringList?.let {
            ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, it)
        }
        listview.adapter=adapter
    }
}