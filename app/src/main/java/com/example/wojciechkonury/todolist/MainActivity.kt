package com.example.wojciechkonury.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.example.todolist.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViev_todolist_main.layoutManager = LinearLayoutManager(this)

        recyclerViev_todolist_main.adapter = TodoListAdapter()
    }

    fun createNewItem(view: View){
        val intent = Intent(this, CreateNewItemActivity::class.java).apply {

        }

        startActivity(intent)
    }
}
