package com.example.simpleworkoutdiary.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.simpleworkoutdiary.databinding.ActivityMainBinding
import java.text.DateFormat
import java.util.*

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel:MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.saveButton.setOnClickListener {

            viewModel.validateFields(
                exercise = binding.editTextExercise.text.toString(),
                sets = binding.editTextNumberSets.text.toString(),
                reps = binding.editTextNumberReps.text.toString()
            )

            viewModel.saveWorkout()
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
        }

    }


}