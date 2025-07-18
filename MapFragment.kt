package com.example.fuelstationfinder

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var locationHelper: LocationHelper
    private lateinit var viewModel: StationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationHelper = LocationHelper(requireContext())
        viewModel = ViewModelProvider(this)[StationViewModel::class.java]

        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true

        locationHelper.getLastLocation {
            val userLatLng = LatLng(it.latitude, it.longitude)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLng, 15f))
            viewModel.findNearbyStations(userLatLng)

            viewModel.places.observe(viewLifecycleOwner) { places ->
                for (place in places) {
                    map.addMarker(
                        MarkerOptions()
                            .position(LatLng(place.lat, place.lng))
                            .title(place.name)
                    )
                }
            }
        }
    }
}
