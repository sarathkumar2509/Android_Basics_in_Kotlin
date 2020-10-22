package com.example.passingdatabetweenactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDone.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val country = etCountry.text.toString()
            val personDetails = PersonDataClass(name, age, country)
            Intent(this,SecondActivity::class.java).also {
                it.putExtra("EXTRA_PERSON",personDetails)
                startActivity(it)
            }

        }
    }
}