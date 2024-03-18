package com.example.unit_conversion_calculator

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.unit_conversion_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val units = arrayOf("Weight", "Distance")
        val spinner :Spinner = findViewById(R.id.spinnerUnits)
        val image :ImageView = findViewById(R.id.imageView)

        ArrayAdapter.createFromResource(
            this,
            R.array.conversion_units,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }

        binding.spinnerUnits.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem == "Weight") {
                    val intent = Intent(this@MainActivity, WeightActivity::class.java)
                    //startActivity(intent)
                }
                if (selectedItem == "Distance"){
                    val intent = Intent(this@MainActivity,DistanceActivity :: class.java)
                   // startActivity(intent)
                }
                if (selectedItem == "Temperature"){
                    val intent = Intent(this@MainActivity,TemperatureActivity ::class.java)

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected
            }
        }

        binding.buttonConvert.setOnClickListener {
            val selectedItem = binding.spinnerUnits.selectedItem.toString()
            when (selectedItem) {
                "Weight" -> {
                    val intent = Intent(this@MainActivity, WeightActivity::class.java)
                    startActivity(intent)
                }
                "Distance" ->{
                    val intent = Intent(this@MainActivity,DistanceActivity :: class.java)
                    startActivity(intent)
                }
                "Temperature" ->{
                    val intent = Intent(this@MainActivity,TemperatureActivity :: class.java)
                    startActivity(intent)
                }
            }
        }
    }


}
