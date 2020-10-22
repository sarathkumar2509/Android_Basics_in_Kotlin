package com.example.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            val firstNum = etNumber1.text.toString().toInt()
            val secondNum = etNumber2.text.toString().toInt()
            val result = firstNum+secondNum
            tvResult.text = result.toString()
        }
    }
}