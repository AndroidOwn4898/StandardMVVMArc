package com.example.fuelstationfinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.example.fuelstationfinder.model.Place

class StationViewModel : ViewModel() {
    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> = _places

    fun findNearbyStations(latLng: LatLng) {
        val placesClient: PlacesClient = Places.createClient(App.instance)
        val token = AutocompleteSessionToken.newInstance()

        val bounds = RectangularBounds.newInstance(
            LatLng(latLng.latitude - 0.05, latLng.longitude - 0.05),
            LatLng(latLng.latitude + 0.05, latLng.longitude + 0.05)
        )

        val request = FindAutocompletePredictionsRequest.builder()
            .setLocationBias(bounds)
            .setTypeFilter(TypeFilter.ESTABLISHMENT)
            .setQuery("fuel station")
            .setSessionToken(token)
            .build()

        placesClient.findAutocompletePredictions(request)
            .addOnSuccessListener { response ->
                val result = response.autocompletePredictions.map {
                    Place(it.getPrimaryText(null).toString(), it.getFullText(null).toString(), latLng.latitude, latLng.longitude)
                }
                _places.postValue(result)
            }
    }
}
