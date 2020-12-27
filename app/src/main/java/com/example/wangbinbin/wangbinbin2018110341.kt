package com.example.wangbinbin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsSpinner
import android.widget.Button
import androidx.annotation.IntegerRes
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.*

const val First="Message"

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    var num1 = ""
    var num2 = ""
    var cal = ""
    val datas = arrayListOf<String>()
    var data = ""
    var result = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //十六进制
        button_hex.setOnClickListener {
            textView_decimal.text ="Hex:"  + toHexString(result.toInt())
        }
        //八进制
        button_octal.setOnClickListener {
            textView_decimal.text = "Octal:" + toOctalString(result.toInt())
        }
        //二进制
        button_binary.setOnClickListener {
            textView_decimal.text = "Binary:" + toBinaryString(result.toInt())
        }
        //历史记录
        button_record.setOnClickListener {
            val intent = Intent(this, Second_Activity::class.java)
            intent.putStringArrayListExtra(First, datas)
            startActivity(intent)
        }
    }

        //显示数字
        fun onNumber(view: View) {
            var number = textView.text.toString()
            val button = view as Button
            when (button.id) {
                button_1.id -> {
                    number += "1"
                    num2 += "1"
                }
                button_2.id -> {
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
                    if (number != "" && num2 != "") {
                        number += "0"
                        num2 += "0"
                    }
                }
                button_double.id -> {
                    if (number != "" && num2 != "") {
                        number += "."
                        num2 += "."
                    }
                }
                button_negative.id -> {
                    number = "-$number"
                    num2 = "-$num2"
                }
            }
            if (cal == "") {
                num2 = ""
            }
            textView.setText(number)
        }


        //显示运算符号
        fun onCal(view: View) {
            val button = view as Button
            if (textView.text != "") {
                num1 = textView.text.toString()
            }

            //若已计算过，在原式上进行计算
            if (textView_result.text != "") {
                num1 = textView_result.text.toString()
                num2 = ""
                textView_result.text = ""
            }

            when (button.id) {
                button_plus.id -> cal = "+"
                button_minus.id -> cal = "-"
                button_multiply.id -> cal = "*"
                button_divide.id -> cal = "/"
            }
            textView.text = num1 + cal
        }


        //计算
        fun onEqual(view: View) {
            result = 0.0
            when (cal) {
                "+" -> {
                    result = num1.toDouble() + num2.toDouble()
                }
                "-" -> {
                    result = num1.toDouble() - num2.toDouble()
                }
                "*" -> {
                    result = num1.toDouble() * num2.toDouble()
                }
                "/" -> {
                    result = num1.toDouble() / num2.toDouble()
                }
            }
            textView_result.text = result.toString()
            data = textView.text.toString() + "=" + result.toString()
            datas.add(data)
        }

        //清空数据
        fun onClear(view: View) {
            num1 = ""
            num2 = ""
            cal = ""
            result = 0.0
            textView.text = ""
            textView_result.text = ""
        }

        //回退
        fun onBack(view: View) {
            if (cal == "") {
//            var num = textView.text.toString().toInt()
//            num /= 10
                num1 = (textView.text.toString().toInt() / 10).toString()
                textView.text = num1
            } else if (num2 != "") {
                num2 = (num2.toInt() / 10).toString()
                textView.text = num1 + cal + num2
            } else {
                cal = ""
                textView.text = num1
            }
        }

        //%
        fun onPercent(view: View) {
            var num = 0.0
            if (cal == "") {
                num = textView.text.toString().toDouble()
                num *= 0.01
                textView.text = num.toString()
            } else {
                num = num2.toDouble()
                num *= 0.01
                num2 = num.toString()
                textView.text = num1 + cal + num2
            }
        }
}

