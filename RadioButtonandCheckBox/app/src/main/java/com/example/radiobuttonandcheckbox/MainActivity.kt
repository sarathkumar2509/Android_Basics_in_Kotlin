package com.example.radiobuttonandcheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId  = rgMeat.checkedRadioButtonId
            val orderedMeat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val salad = cbSalad.isChecked
            val onion = cbOnion.isChecked
            val cheese = cbCheese.isChecked
            val listOfOrder = "You Ordered a Burger with:\n"+"${orderedMeat.text}"+
                    (if (salad) "\nSalad" else "")+
                    (if (onion) "\nOnion" else "")+
                    (if (cheese) "\nCheese" else "")

            tvOrderList.text= listOfOrder
        }
    }
}