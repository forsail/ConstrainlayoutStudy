package com.example.administrator.constrainlayoutstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ListView
import android.widget.RelativeLayout
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    var rootLayout: RelativeLayout? = null
    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        textView.text = "Hello"
//        textView2.text = "Kotlin"
        rootLayout = relativeLayout {
            val edtName = editText("java") {
                id = 1
                hint = "hello"
                textSize = 16f
            }.lparams {
                alignParentLeft()
                alignParentRight()
                alignParentTop()
            }

            editText {
                id = 2
                hint = "world"
                textSize = 16f;
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
                    toast(edtName.text)
                    toast("${rootLayout?.find<EditText>(1)?.text}")
                }
            }.lparams {
                below(1)
                alignParentRight()
            }

            listView = listView {
                id = 4
            }.lparams {
                below(3)
                alignParentBottom()
            }
        }


    }
}
