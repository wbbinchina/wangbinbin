package com.example.wangbinbin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsSpinner
import kotlinx.android.synthetic.main.activity_main.*

const val First="Message"

class MainActivity : AppCompatActivity() {

    val datas= arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun result(spinner: AbsSpinner, firstNumber:Int, secondNumber:Int): Int {
            val result:Int = when(spinner.selectedItem.toString()){
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> -1
            }
            return result
            }

        button.setOnClickListener {
            val second = second_edit.text.toString().toInt()
            val first = first_edit.text.toString().toInt()
            textView.text = "= " + result(spinner,first,second).toString()
            val data=first_edit.text.toString()+spinner.selectedItem.toString()+second_edit.text.toString()+textView.text
            datas.add(data)
        }
        button3.setOnClickListener {
            val intent=Intent(this,Second_Activity::class.java)
            intent.putStringArrayListExtra(First,datas)
            startActivity(intent)
        }

    }
}

