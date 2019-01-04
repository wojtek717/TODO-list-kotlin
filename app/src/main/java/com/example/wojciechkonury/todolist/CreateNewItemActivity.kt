package com.example.wojciechkonury.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_new_item.*

const val EXTRA_TODO_TITLE = "EXTRA_TODO_TITLE"
const val EXTRA_TODO_DESCRIPTION = "EXTRA_TODO_DESCRIPTION"

class CreateNewItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_item)
    }

    fun sendItem(viev: View){
        val message_title = editText_todotile.text.toString()
        val message_description = editText_todo_desciprtion.text.toString()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_TODO_TITLE, message_title)
            putExtra(EXTRA_TODO_DESCRIPTION, message_description)
        }

        startActivity(intent)
    }

}
