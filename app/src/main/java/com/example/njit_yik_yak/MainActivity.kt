package com.example.njit_yik_yak

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val LOCATION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check for location permission before asserting the view
        checkLocationPermission()

        setContentView(R.layout.activity_main)

        val listview =findViewById<ListView>(R.id.Home_page)

        listview.adapter= MycustomeAdaptor(this)
    }

    private class MycustomeAdaptor (context : Context): BaseAdapter(){
        private val mContext: Context


        init{
            this.mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup : ViewGroup?): View {
            val layoutInflater= LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.main_row, viewGroup,false)

            val postTime = rowMain.findViewById<TextView>(R.id.texttime)

            postTime.text= "Post time"
            return rowMain

            /* val textview= TextView(mContext)
                     textview.text="This is text for list view"
                     return textview;
         */
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        // how many rows in my list
        override fun getCount(): Int {
            return 20
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun getItemId(position: Int): Long {
            return position.toLong();
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun getItem(position: Int): Any {
            return "Text String"

            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


    }

    private fun checkLocationPermission() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            val locationIntent = Intent(this, LocationPermissionActivity::class.java)

            // Start the new activity.
            startActivity(locationIntent)
        }
    }

    /* fun toastMe(view: View) {
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
    } */
}
