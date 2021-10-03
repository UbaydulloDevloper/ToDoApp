package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        todolist.setOnClickListener {
            startActivity(Intent(this, toDolist::class.java))
        }
        addtodo.setOnClickListener {
            startActivity(Intent(this, AddTodo::class.java))
        }
    }
}