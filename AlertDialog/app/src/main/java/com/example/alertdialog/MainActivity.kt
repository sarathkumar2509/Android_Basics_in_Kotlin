package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes"){ _,_: Int ->
                Toast.makeText(this,"Contact Added",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_ : Int->
             Toast.makeText(this,"Contact not Added",Toast.LENGTH_SHORT).show()
            }
            .create()
        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }


        val options = arrayOf("First Option","Second Option","Third Option")
        val singleOptionDialog = AlertDialog.Builder(this)
            .setTitle("Choose any of these")
            .setSingleChoiceItems(options,0){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"You Clicked ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _: DialogInterface, _: Int ->
                Toast.makeText(this,"Your Choice Accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"You Choice Declined",Toast.LENGTH_SHORT).show()
            }
            .create()

        btnDialog2.setOnClickListener {
            singleOptionDialog.show()
        }


        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose any of these")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ _: DialogInterface, i: Int, isChecked: Boolean ->
                if (isChecked){
                    Toast.makeText(this,"You Checked ${options[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You UnChecked ${options[i]}",Toast.LENGTH_SHORT).show()

                }

            }
            .setPositiveButton("Accept") { _: DialogInterface, _: Int ->
                Toast.makeText(this,"Your MultiChoice Accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this,"You MultiChoice Declined",Toast.LENGTH_SHORT).show()
            }
            .create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}