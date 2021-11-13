package com.koshake1.geolocationapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.koshake1.geolocationapp.R
import com.koshake1.geolocationapp.view.adapter.MarkerAdapter
import com.koshake1.geolocationapp.viewmodel.MarkersViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class MarkersFragment : Fragment(R.layout.fragment_marker) {

    companion object {
        fun newInstance() = MarkersFragment()
    }

    private val viewModel: MarkersViewModel by sharedViewModel()

    private lateinit var rv: RecyclerView
    private lateinit var adapter: MarkerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.markers_recyclerView)
        rv.layoutManager = LinearLayoutManager(context)

        adapter = MarkerAdapter(viewModel, viewModel.getMarkersData().value!!)
        rv.adapter = adapter
    }
}