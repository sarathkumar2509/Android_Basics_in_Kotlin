package com.example.passingdatabetweenactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       val personDetails = intent.getSerializableExtra("EXTRA_PERSON") as PersonDataClass

        val Details = " ${personDetails.name}  is ${personDetails.age} old from ${personDetails.country}"
        tvDetails.text = Details
    }
}