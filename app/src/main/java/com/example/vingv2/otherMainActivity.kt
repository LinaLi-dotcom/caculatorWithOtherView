package com.example.vingv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class otherMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_main)

        var theNumber = intent.getIntExtra("counter", 0)
        var textView = findViewById<TextView>(R.id.theOtherTextView)
        textView.text = theNumber.toString()
    }
}