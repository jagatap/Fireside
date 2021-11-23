package com.a.fire

import android.icu.text.DateFormat
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.lang.String.format


class MainActivity : AppCompatActivity() {
    private var btn_frag: TextView? = null
    private var latitude: Double? = null
    private var longitude: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_frag = findViewById(R.id.btn_frag)
        getLocation()
        btn_frag?.setOnClickListener {
            btn_frag!!.visibility = View.GONE
            val b = Bundle()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val myFragment = WeatherFragment()
            b.putString("latitude", latitude.toString())
            b.putString("longitude", longitude.toString())
            myFragment.setArguments(b)
            fragmentTransaction.replace(R.id.nav_fragment, myFragment).commit()
        }
    }
    fun getLocation() {
        val gpsTracker = GpsTracker(this)
        if (gpsTracker.canGetLocation()) {
            latitude = gpsTracker.getLatitude()
            longitude = gpsTracker.getLongitude()
        } else {
            gpsTracker.showSettingsAlert()
        }
    }

}