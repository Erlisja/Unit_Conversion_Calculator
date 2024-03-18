package com.example.unit_conversion_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unit_conversion_calculator.databinding.TemperatureActivityBinding


class TemperatureActivity: AppCompatActivity() {

    private lateinit var binding: TemperatureActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TemperatureActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val cView = binding.cEditView

        val valueEntered= binding.valueEntered
        val celciusView = binding.cView

        binding.convertButton.setOnClickListener {
            val enteredValue = valueEntered.text.toString().toDoubleOrNull()?: 0.0
            val celciusValue = (enteredValue - 32) *(5.0/9.0)

            cView.setText(String.format("%.3f",celciusValue))
        }
        val backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }




}




