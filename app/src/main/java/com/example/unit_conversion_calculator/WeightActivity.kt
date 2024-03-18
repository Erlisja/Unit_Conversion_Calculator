package com.example.unit_conversion_calculator
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity


import com.example.unit_conversion_calculator.databinding.WeightActivityBinding


class WeightActivity : AppCompatActivity() {

private lateinit var binding: WeightActivityBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeightActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

                val gr = binding.gEditView
                val oz = binding.ozEditView
                val ton= binding.tonEditView
                val lb = binding.lbEditView


        val grView = binding.grView
                val enteredVal = binding.valueEntered
                val ounceView = binding.ounceView
                val tonView = binding.tonView
                val lbView = binding.lbView

                // Update conversions when the user enters a value in pounds
//        lbEditView.addTextChangedListener(object : TextWatcher {
//        override fun beforeTextChanged(
//        s: CharSequence?,
//        start: Int,
//        count: Int,
//        after: Int
//        ) {
//        }
//
//        override fun onTextChanged(
//        s: CharSequence?,
//        start: Int,
//        before: Int,
//        count: Int
//        ) {
//        }
//
//        override fun afterTextChanged(s: Editable?) {
//        val kgValue = s.toString().toDoubleOrNull() ?: 0.0
//        val lbValue = kgValue * 2.20462
//        val grValue = kgValue * 1000
//                val ounceValue = kgValue * 35.274
//                val tonValue = kgValue * 0.001
//        lbView.text = String.format("%.2f lb", lbValue)
//        grView.text = String.format("%.2f g", grValue)
//        ounceView.text = String.format("%.2f ounce",ounceValue)
//        tonView.text = String.format("%.4f ton",tonValue)
//
//
//        }
//        })
                binding.convertButton.setOnClickListener {
                        val enteredValue= enteredVal.text.toString().toDoubleOrNull() ?: 0.0
                        val lbValue = enteredValue * 2.20462
                        val grValue = enteredValue * 1000
                        val ounceValue = enteredValue * 35.274
                        val tonValue = enteredValue * 0.001

                        lb.setText(String.format("%.2f ", lbValue))
                        gr.setText( String.format("%.2f ", grValue))
                        oz.setText(String.format("%.2f ",ounceValue))
                        ton.setText(String.format("%.4f ",tonValue))
                }

                val backButton = binding.backButton
                backButton.setOnClickListener {
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                }

        }
        }
