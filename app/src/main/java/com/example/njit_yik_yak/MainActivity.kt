package com.example.njit_yik_yak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe (view: View) {
        // Get the text view
        val showCountTextView = findViewById<TextView>(R.id.textView2)

        // Get the value of the text view.
        val countString = showCountTextView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        // Display the new value in the text view.
        showCountTextView.text = count.toString()
    }

    fun randomMe (view: View) {// Get the text view
        // ®val textView = findViewById<TextView>(R.id.textView)

        // Get the current value of the text view.
        // val countString = textView.text.toString()

        // Convert the count to an int
        // val count = Integer.parseInt(countString)

        // Create an Intent to start the second activity
        // val randomIntent = Intent(this, Main2Activity::class.java)

        // Add the count to the extras for the Intent.
        // randomIntent.putExtra(Main2Activity.TOTAL_COUNT, count)
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, Main2Activity::class.java)

        // Start the new activity.
        startActivity(randomIntent)
    }
}
