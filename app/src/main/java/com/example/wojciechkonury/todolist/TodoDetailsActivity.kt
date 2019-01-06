package com.example.wojciechkonury.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_todo_details.*

class TodoDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_details)

        val navBarTitle = intent.getStringExtra(EXTRA_DETAILS_TITLE)
        supportActionBar?.title = navBarTitle

        details_title.text = navBarTitle
    }


}
