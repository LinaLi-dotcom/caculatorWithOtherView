package com.example.vingv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {


    var counterNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counterView = findViewById<TextView>(R.id.theTextView)
        counterView.text = "0"



        var plusButton = findViewById<Button>(R.id.plusButton)
        plusButton.setOnClickListener {

            calculateNumber("plus")

        }

        var minusButton = findViewById<Button>(R.id.minusButton)
        minusButton.setOnClickListener {
            calculateNumber("minus")
        }

        var resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {
            counterView.text = "0"
        }

        var setButton = findViewById<Button>(R.id.setButton)
        setButton.setOnClickListener {
            var numberEditText = findViewById<EditText>(R.id.NumberEditText)
            var enteredText = numberEditText.text.toString()
            Log.d("PIA9Debug", enteredText)

            //?.let = if let (in swift)

            makeNumber(enteredText)?. let { enteredNumber ->
                counterNumber = enteredNumber
        }
            counterView.text = counterNumber.toString()
            numberEditText.setText("")

        }

        var nextViewButton = findViewById<Button>(R.id.goToNextViewbutton)
        nextViewButton.setOnClickListener {
            Log.d("PIA9DeBUG", "go to the other view")

            var intent = Intent(this, otherMainActivity:: class.java)
            intent.putExtra("counter", counterNumber)
            startActivity(intent)

        }


    }

    fun calculateNumber(calMode: String)
    {
        if (calMode == "plus")
        {
            counterNumber += 1
        }
        if (calMode == "minus")
        {
            counterNumber -= 1
        }
        if (counterNumber < 0)
        {
            counterNumber = 0
        }

        var counterView = findViewById<TextView>(R.id.theTextView)
        counterView.text = counterNumber. toString()

    }


    fun makeNumber(numberText: String): Int?
    {
        var theNumber = numberText.toIntOrNull()

        if( theNumber == null)
        {
            var errorTextView = findViewById<TextView>(R.id.errorTextView)
            errorTextView.visibility = View.VISIBLE

        } else {

            var errorTextView = findViewById<TextView>(R.id.errorTextView)
            errorTextView.visibility = View.GONE

        }

        return theNumber

    }
}