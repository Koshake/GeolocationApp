package com.koshake1.geolocationapp.data

import android.util.Log

class MarkerRepositoryImpl : MarkerRepository {

    val TAG = "MARKER"

    private val markers: MutableList<Marker> = mutableListOf()

    override fun getMarkers():List<Marker> {
        return markers
    }

    override fun addMarker(newMarker: Marker) {
        markers.add(newMarker)
        Log.d(TAG, "add ${newMarker.header}  ")
    }

    override fun replaceMarker(newMarker: Marker) {
        markers.find {
            (it.id == newMarker.id)
        }?.let {
            if (it == newMarker) return

            markers.remove(it)
        }

        markers.add(newMarker)
    }
}