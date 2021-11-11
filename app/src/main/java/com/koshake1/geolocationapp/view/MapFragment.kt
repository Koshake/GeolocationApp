package com.koshake1.geolocationapp.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.koshake1.geolocationapp.R

class MapFragment : Fragment(), OnMapReadyCallback {

    companion object {
        fun newInstance() = MapFragment()

        const val MAP_ZOOM = 5f
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()
        setHasOptionsMenu(true)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.setOnMapClickListener { latlng ->

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, MAP_ZOOM))

            val location = LatLng(latlng.latitude, latlng.longitude)
            googleMap.addMarker(MarkerOptions()
                .position(location)
                .title("${latlng.latitude} : ${latlng.longitude}"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun initMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }
}