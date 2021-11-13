package com.koshake1.geolocationapp.data

interface MarkerRepository {
    fun getMarkers(): List<Marker>
    fun addMarker(newMarker: Marker)
    fun replaceMarker(newMarker: Marker)
}