package com.example.unit_conversion_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unit_conversion_calculator.databinding.DistanceActivityBinding



class DistanceActivity: AppCompatActivity() {

    private lateinit var binding: DistanceActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DistanceActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val km = binding.kmEditView
        val cm = binding.cmEditView
        val inch = binding.inchEditView
        val miles = binding.milesEditView

        val valueEntered = binding.valueEntered
        val kmView = binding.kmView
        val cmView = binding.cmView
        val inchView = binding.inchView
        val mileView = binding.milesView

        binding.convertButton.setOnClickListener {
            val enteredValue = valueEntered.text.toString().toDoubleOrNull()?: 0.0
            val kmValue = enteredValue /1000
            val cmValue = enteredValue *100
            val mileValue = enteredValue * 0.000621371
            val inchValue = enteredValue * 39.37

            km.setText( String.format("%.3f ",kmValue))
            cm.setText( String.format("%.3f ",cmValue))
            miles.setText(String.format("%.3f",mileValue))
            inch.setText(String.format("%.3f inch",inchValue))
        }

        val backButton = binding.backButton
        backButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}