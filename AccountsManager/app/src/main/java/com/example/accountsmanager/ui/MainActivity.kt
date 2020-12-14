package com.example.accountsmanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.accountsmanager.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
        CheckLogState()
        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }
    private fun loginUser(){
        val email = binding.userid.text.toString()
        val password = binding.password.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email,password).await()
                    val intent =  Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity,e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
        private fun CheckLogState(){
        if (auth.currentUser != null){
            val intent =  Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}