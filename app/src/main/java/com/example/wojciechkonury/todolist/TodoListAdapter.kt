package com.example.wojciechkonury.todolist

import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.todo_row.view.*


class TodoListAdapter(val todoItems: List<TodoItem>) : RecyclerView.Adapter<customVievHolder>(){

    val todoTitles = listOf<String>("Adding elements to list", "Make a dinner", "Do homework", "Kill teacher", "Fap")

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): customVievHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val todoLayout = layoutInflater.inflate(R.layout.todo_row, p0, false)

        return customVievHolder(todoLayout)
    }

    override fun onBindViewHolder(p0: customVievHolder, p1: Int) {

        val todoItem = todoItems.get(p1) //Get current object from list

        p0.viev.todo_title.text = todoItem.title
        p0.viev.todo_description.text = todoItem.description
        p0.viev.todo_date.text = "Date: " + todoItem.day + "/" + todoItem.month + "/" + todoItem.year
        p0.viev.todo_time.text = "Time: " + todoItem.hour + ":" + todoItem.minute

        p0.todoItem = todoItem //Set clicked object
    }

}

class customVievHolder(val viev: View, var todoItem: TodoItem? = null) : RecyclerView.ViewHolder(viev){
    init {
        viev.setOnClickListener {
            val intent = Intent(viev.context, TodoDetailsActivity::class.java).apply{
                putExtra(EXTRA_TODO_TITLE, todoItem?.title)
                putExtra(EXTRA_TODO_DESCRIPTION, todoItem?.description)

                putExtra(EXTRA_TODO_YEAR, todoItem?.year)
                putExtra(EXTRA_TODO_MONTH, todoItem?.month)
                putExtra(EXTRA_TODO_DAY, todoItem?.day)
                putExtra(EXTRA_TODO_HOUR, todoItem?.hour)
                putExtra(EXTRA_TODO_MINUTE, todoItem?.minute)

            }

            viev.context.startActivity(intent)
        }
    }
}