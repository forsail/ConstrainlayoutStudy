package com.example.administrator.constrainlayoutstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.RelativeLayout
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    var rootLayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        textView.text = "Hello"
//        textView2.text = "Kotlin"
        rootLayout = relativeLayout {
            val edtName = editText("gl") {
                id = 1
                hint = "hello"
                textSize = 20f
            }.lparams {
                alignParentLeft()
                alignParentRight()
                alignParentTop()
            }

            editText {
                id = 2
                hint = "world"
                textSize = 20f
            }.lparams {
                alignParentLeft()
                below(1)
                leftOf(3)
            }

            button("btn1") {
                id = 3
                width = wrapContent
                height = wrapContent
                padding = 10
                onClick {
                    toast("${rootLayout?.find<EditText>(1)?.text}")
                }
            }.lparams {
                below(1)
                alignParentRight()
            }

            button("btn3") {
                id = 4
                onClick {
                    toast(edtName.text)
                }
            }.lparams {
                alignParentBottom()
                alignParentLeft()
                alignParentRight()
            }
        }
    }
}
