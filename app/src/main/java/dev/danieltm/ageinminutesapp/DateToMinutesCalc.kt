package dev.danieltm.ageinminutesapp

import java.text.SimpleDateFormat
import java.util.*

class DateToMinutesCalc {

    fun calculateAgeInMin(selectedDate: Date) : Long{

        // Gets an instance of the local calendar
        val myCalendar = Calendar.getInstance()
        // Gets the current year
        val year = myCalendar.get(Calendar.YEAR)
        // Gets the current month
        val month = myCalendar.get(Calendar.MONTH)
        // Gets the current day of month
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

        val currentDate = "$dayOfMonth/${month+1}/$year"

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val parsedCurrentDate = sdf.parse(currentDate)

        val diff: Long = parsedCurrentDate.time - selectedDate.time

        val seconds = diff / 1000
        val ageInMinutes = seconds / 60

        return ageInMinutes


    }
}