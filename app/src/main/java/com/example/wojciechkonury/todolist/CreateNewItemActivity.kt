package com.example.wojciechkonury.todolist

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_new_item.*
import java.util.*

const val EXTRA_TODO_TITLE = "EXTRA_TODO_TITLE"
const val EXTRA_TODO_DESCRIPTION = "EXTRA_TODO_DESCRIPTION"

class CreateNewItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_item)

        // calendar
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        button_date.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, mYear, mMonth, mDay -> textView_date.setText(" " + mDay + "/" + (mMonth + 1) + "/" + mYear)
            }, year, month, day)

            dpd.show()
        }
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
