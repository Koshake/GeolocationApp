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
import com.koshake1.geolocationapp.data.Marker
import com.koshake1.geolocationapp.viewmodel.MarkersViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    companion object {
        fun newInstance() = MapFragment()

        const val MAP_ZOOM = 5f
    }

    private val viewModel: MarkersViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()
        setHasOptionsMenu(true)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.setOnMapClickListener { latlng ->

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, MAP_ZOOM))

            val location = LatLng(latlng.latitude, latlng.longitude)
            googleMap.addMarker(
                MarkerOptions()
                    .position(location)
                    .title("${latlng.latitude} : ${latlng.longitude}")
            )

            viewModel.addMarkerData(Marker(latlng.latitude, latlng.longitude))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_markers_list ->
                (requireActivity() as MainActivity).navigateTo(MarkersFragment.newInstance())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }
}