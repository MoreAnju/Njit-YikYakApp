package com.example.njit_yik_yak

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class LocationPermissionActivity : AppCompatActivity() {

    private val TAG = "Location Permission"

    private val LOCATION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_permission)
    }

    fun setupPermissions (view: View) {
        Log.i("Setup permission", "IN FUNCTION")
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG,"Permission to location denied")

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            LOCATION_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")

                    // return to MainActivity
                    finish()
                }
            }
        }
    }
}
