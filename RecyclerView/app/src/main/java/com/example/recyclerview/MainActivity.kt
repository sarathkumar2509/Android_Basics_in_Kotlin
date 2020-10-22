package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            Todo("Your First Todo",false),
            Todo("Your Second Todo",false),
            Todo("Your Third Todo",false)
        )

        val adapter = TodoAdapter(todoList)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)


        btnAdd.setOnClickListener {
            val title = etTodoText.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            etTodoText.text.clear()
            adapter.notifyItemInserted(todoList.size - 1)
        }



    }

}