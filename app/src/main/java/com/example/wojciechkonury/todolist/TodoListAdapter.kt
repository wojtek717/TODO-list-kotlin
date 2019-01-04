package com.example.wojciechkonury.todolist

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
        p0.viev.todo_title.text = todoItems.get(p1).title
        p0.viev.todo_description.text = todoItems.get(p1).description
    }
}

class customVievHolder(val viev: View) : RecyclerView.ViewHolder(viev){

}