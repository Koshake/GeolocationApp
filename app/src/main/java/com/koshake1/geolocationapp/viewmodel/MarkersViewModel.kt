package com.koshake1.geolocationapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.koshake1.geolocationapp.App
import com.koshake1.geolocationapp.data.Marker
import com.koshake1.geolocationapp.data.MarkerRepository

class MarkersViewModel(private val markersRepository: MarkerRepository) : ViewModel() {

    private val markersLiveData: MutableLiveData<List<Marker>> = MutableLiveData()

    fun getMarkersData(): LiveData<List<Marker>> {
        return markersLiveData
    }

    fun addMarkerData(newMarker: Marker) {
        markersRepository.addMarker(newMarker)
        markersLiveData.value = markersRepository.getMarkers()
    }

    fun replaceMarkerData(newMarker: Marker) {
        markersRepository.replaceMarker(newMarker)
        markersLiveData.value = markersRepository.getMarkers()
    }
}