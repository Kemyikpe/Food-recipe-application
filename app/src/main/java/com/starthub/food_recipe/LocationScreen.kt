package com.starthub.food_recipe

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import com.starthub.food_recipe.databinding.LocationScreenBinding

class LocationScreen : AppCompatActivity() {
    private val binding : LocationScreenBinding by lazy {
        LocationScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList = arrayOf("Akwa Ibom","Cross River","Rivers state","Lagos","Abuja")
        val  adapter = ArrayAdapter(this, R.layout.simple_list_item_1,locationList )
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        val spinner: Spinner = binding.spinnerLocation
        spinner.adapter = adapter

    }
}