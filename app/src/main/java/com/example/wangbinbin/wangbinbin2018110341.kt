package com.example.wangbinbin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsSpinner
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

const val First="Message"

class MainActivity : AppCompatActivity() {

    var num1 = ""
    var num2 = ""
    var cal = ""
    val datas= arrayListOf<String>()
    var isEmpty = false
    var data = ""

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
        var number = textView.text.toString()
        num2 = ""
        var button = view as Button
        when(button.id){
            button_1.id -> {
                number += "1"
                num2 += "1"
            }
            button_2.id ->
            {
                number += "2"
                num2 += "2"
            }
            button_3.id -> {
                number += "3"
                num2 += "3"
            }
            button_4.id -> {
                number += "4"
                num2 += "4"
            }
            button_5.id -> {
                number += "5"
                num2 += "5"
            }
            button_6.id -> {
                number += "6"
                num2 += "6"
            }
            button_7.id -> {
                number += "7"
                num2 += "7"
            }
            button_8.id -> {
                number += "8"
                num2 += "8"
            }
            button_9.id -> {
                number += "9"
                num2 += "9"
            }
            button_0.id -> {
                number += "0"
                num2 += "0"
            }
            button_double.id -> {
                number += "."
                num2 += "."
            }
        }
        textView.setText(number)
    }

    fun onCal(view: View) {
        var button = view as Button
        if (textView.text!="") {
            num1 = textView.text.toString()
        }
        var result = 0.0
        when(button.id){
            button_plus.id -> {
                cal = "+"
            }
            button_minus.id -> {
                cal = "-"
            }
            button_multiply.id -> {
                cal = "*"
            }
            button_divide.id -> cal = "/"
        }
        textView.text = textView.text.toString() + cal
    }

    fun onEqual(view: View) {
        var result = 0.0
        when(cal){
            "+" -> {result=num1.toDouble() + num2.toDouble()}
            "-" -> {result=num1.toDouble() - num2.toDouble()}
            "*" -> {result=num1.toDouble() * num2.toDouble()}
            "/" -> {result=num1.toDouble() / num2.toDouble()}
        }
        textView_result.text=result.toString()
        data = textView.text.toString() + cal + " = " + result.toString()
        datas.add(data)
    }

    fun onClear(view: View) {
        num1=""
        num2=""
        textView.text=""
        textView_result.text=""
    }

    fun onBack(view: View) {
        var num = textView.text.toString().toInt()
        num /= 10
        textView.text = num.toString()
    }

    fun onPercent(view: View) {
        var num = 0.0
        if (cal == ""){
            num = textView.text.toString().toDouble()
            num *= 0.01
            textView.text = num.toString()
        }
        else{
            num = num2.toDouble()
            num *= 0.01
            num2 = num.toString()
        }
    }
}

