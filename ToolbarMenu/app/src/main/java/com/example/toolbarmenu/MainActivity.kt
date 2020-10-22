package com.example.toolbarmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSettings -> Toast.makeText(this,"Clicked Settings",Toast.LENGTH_SHORT).show()
            R.id.mifav -> Toast.makeText(this,"Clicked Favorites",Toast.LENGTH_SHORT).show()
            R.id.mi_add_contact -> Toast.makeText(this,"Clicked Add Contact",Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this,"Clicked Feedback",Toast.LENGTH_SHORT).show()
            R.id.miclose -> finish()
        }
        return true
    }
}