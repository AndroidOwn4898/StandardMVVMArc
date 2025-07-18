package com.example.fuelstationfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val center = LatLng(23.0300, 72.5800)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 13f))

        val fuelStations = listOf(
            LatLng(23.0225, 72.5714) to "Shell Fuel Station",
            LatLng(23.0300, 72.5800) to "HP Petrol Pump",
            LatLng(23.0350, 72.5650) to "Indian Oil",
            LatLng(23.0250, 72.5500) to "Reliance Pump"
        )

        for ((location, name) in fuelStations) {
            googleMap.addMarker(MarkerOptions().position(location).title(name))
        }
    }
}
