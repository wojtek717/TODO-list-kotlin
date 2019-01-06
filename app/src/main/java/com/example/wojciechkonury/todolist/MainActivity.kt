package com.example.wojciechkonury.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.DatePicker
import android.widget.LinearLayout
import java.util.*

const val EXTRA_MESSAGE = "com.example.todolist.MESSAGE"


class MainActivity : AppCompatActivity() {

    var todo_item: TodoItem = TodoItem("Zakupy", "Kupic jablka")

    companion object todo_items{
        var items = mutableListOf<TodoItem>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recycler View
        recyclerViev_todolist_main.layoutManager = LinearLayoutManager(this)
        recyclerViev_todolist_main.adapter = TodoListAdapter(todo_items.items) // Set adapter


        // Receive messages from other activity
        val message_todo_title = intent.getStringExtra(EXTRA_TODO_TITLE)
        val message_todo_description = intent.getStringExtra(EXTRA_TODO_DESCRIPTION)

        val message_todo_year = intent.getIntExtra(EXTRA_TODO_YEAR, 0)
        val message_todo_month = intent.getIntExtra(EXTRA_TODO_MONTH, 0)
        val message_todo_day = intent.getIntExtra(EXTRA_TODO_DAY, 0)
        val message_todo_hour = intent.getIntExtra(EXTRA_TODO_HOUR, 0)
        val message_todo_minute = intent.getIntExtra(EXTRA_TODO_MINUTE, 0)

        // Chceck if object's parametrs are valid
        if(message_todo_description != null && message_todo_title != null)
        {
            if(message_todo_title.length > 0 && message_todo_description.length > 0)
            {
                todo_item = TodoItem(message_todo_title,
                    message_todo_description,
                    message_todo_year,
                    message_todo_month,
                    message_todo_day,
                    message_todo_hour,
                    message_todo_minute) //create object

                todo_items.items.add(todo_item) //add object to list
                todo_items.items[todo_items.items.size -1].index = todo_items.items.size -1
            }
        }
    }

    // Start new activity when button is clicked
    fun createNewItem(view: View){
        val intent = Intent(this, CreateNewItemActivity::class.java).apply {}

        startActivity(intent)
    }
}
