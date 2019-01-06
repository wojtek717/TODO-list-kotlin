package com.example.wojciechkonury.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_todo_details.*

class TodoDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_details)

        val title = intent.getStringExtra(EXTRA_TODO_TITLE)
        val description = intent.getStringExtra(EXTRA_TODO_DESCRIPTION)

        val year = intent.getIntExtra(EXTRA_TODO_YEAR, 0)
        val month = intent.getIntExtra(EXTRA_TODO_MONTH, 0)
        val day = intent.getIntExtra(EXTRA_TODO_DAY, 0)

        val hour = intent.getIntExtra(EXTRA_TODO_HOUR, 0)
        val minute = intent.getIntExtra(EXTRA_TODO_MINUTE, 0)

        supportActionBar?.title = title

        details_title.text = title
        details_description.text = description

        details_date.text = "Date: " + day + "/" + month + "/" + year
        details_time.text = "Time: " + hour + ":" + minute

    }


}
