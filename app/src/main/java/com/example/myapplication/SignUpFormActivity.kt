package com.example.myapplication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpFormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var display: TextView
    lateinit var datePicker: EditText
    lateinit var autoCompleteTextView: AutoCompleteTextView
    var countries = arrayOf("Nepal", "China", " India", "USA", "Canada", "Australia")

    val cities = arrayOf("Kathmandu", "Lalitpur", "Bhaktapur", "Kanchanpur", "Bharatpur")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_form)
        spinner = findViewById(R.id.spinner2)
        display = findViewById(R.id.displaySpinner)
        autoCompleteTextView = findViewById(R.id.autoComplete)
        datePicker = findViewById(R.id.editTextDate)

        datePicker.isFocusable = false
        datePicker.isClickable = true

        datePicker.setOnClickListener{
            loadCalendar()
        }

        val autoCompleteAdapter = ArrayAdapter(
            this@SignUpFormActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )

        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1

        val adapter = ArrayAdapter(
            this@SignUpFormActivity,
            android.R.layout.simple_spinner_item,
            countries
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.onItemSelectedListener = this
        spinner.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SignUpFormActivity,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                datePicker.setText("$day/${month+1}/$year")
            }, year,month,day
        )

        dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent != null) {
            display.text = parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}