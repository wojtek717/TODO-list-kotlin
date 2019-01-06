package com.example.wojciechkonury.todolist

import java.time.LocalDate
import java.util.*

class TodoItem(Tit: String, Desc: String,
               Year: Int = Calendar.getInstance().get(Calendar.YEAR),
               Month: Int = Calendar.getInstance().get(Calendar.MONTH) + 1,
               Day: Int = Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
               Hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
               Minute: Int = Calendar.getInstance().get(Calendar.MINUTE)) {


    var title = Tit
    var description = Desc

    var year = Year
    var month = Month
    var day = Day

    var hour = Hour
    var minute = Minute

    var index: Int = 0
    var done: Boolean = false
}