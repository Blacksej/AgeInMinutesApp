package dev.danieltm.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnDatePicker = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener {
                view -> clickDatePicker(view)
        }
    }

    fun clickDatePicker(view: View){

        // Gets an instance of the local calendar
        val myCalendar = Calendar.getInstance()
        // Gets the current year
        val year = myCalendar.get(Calendar.YEAR)
        // Gets the current month
        val month = myCalendar.get(Calendar.MONTH)
        // Gets the current day of month
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val parsedDate = sdf.parse(selectedDate)

                // Set the text to display the selected date
                tvSelectedDate.setText(selectedDate)

                var dateToMinutesCalc = DateToMinutesCalc()
                var ageInMinutes: Long = dateToMinutesCalc.calculateAgeInMin(parsedDate)

                val tvAgeInMinutes = findViewById<TextView>(R.id.tvSelectedAgeInMinutes)
                tvAgeInMinutes.setText(ageInMinutes.toString())
            },
            year, month, dayOfMonth).show()
    }
}