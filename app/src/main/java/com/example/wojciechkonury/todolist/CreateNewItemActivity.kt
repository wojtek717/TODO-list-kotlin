package com.example.wojciechkonury.todolist

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_new_item.*
import java.util.*

const val EXTRA_TODO_TITLE = "EXTRA_TODO_TITLE"
const val EXTRA_TODO_DESCRIPTION = "EXTRA_TODO_DESCRIPTION"
const val EXTRA_TODO_YEAR = "EXTRA_TODO_YEAR"
const val EXTRA_TODO_MONTH = "EXTRA_TODO_MONTH"
const val EXTRA_TODO_DAY = "EXTRA_TODO_DAY"
const val EXTRA_TODO_HOUR = "EXTRA_TODO_HOUR"
const val EXTRA_TODO_MINUTE = "EXTRA_TODO_MINUTE"

class CreateNewItemActivity : AppCompatActivity() {

    // calendar
    val calendar = Calendar.getInstance()

    var year = calendar.get(Calendar.YEAR)
    var month = calendar.get(Calendar.MONTH)
    var day = calendar.get(Calendar.DAY_OF_MONTH)
    var hour = calendar.get(Calendar.HOUR_OF_DAY)
    var minutes = calendar.get(Calendar.MINUTE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_item)


        // when button clicked show DatePickerDialog
        button_date.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, mYear, mMonth, mDay ->
                textView_date.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear) //set textView
                year = mYear
                month = mMonth + 1
                day = mDay
            }, year, month, day)

            dpd.show() //show dialog
        }

        // When button clickes show TimePickerDialog
        button_time.setOnClickListener{
            val tpd = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                textView_time.setText("" + hourOfDay + " : " + minute) //set textView
                hour = hourOfDay
                minutes = minute
            }, hour, minutes, true)

            tpd.show() //show dialog
        }
    }

    // Back to recycler view  and send new item to it
    fun sendItem(viev: View){
        val message_title = editText_todotile.text.toString()
        val message_description = editText_todo_desciprtion.text.toString()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_TODO_TITLE, message_title)
            putExtra(EXTRA_TODO_DESCRIPTION, message_description)

            putExtra(EXTRA_TODO_YEAR, year)
            putExtra(EXTRA_TODO_MONTH, month)
            putExtra(EXTRA_TODO_DAY, day)
            putExtra(EXTRA_TODO_HOUR, hour)
            putExtra(EXTRA_TODO_MINUTE, minutes)


        }

        startActivity(intent)
    }

}
