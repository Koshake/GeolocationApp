package com.koshake1.geolocationapp.view.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.koshake1.geolocationapp.R
import com.koshake1.geolocationapp.data.Marker
import com.koshake1.geolocationapp.viewmodel.MarkersViewModel

class MarkerAdapter(
    private val viewModel: MarkersViewModel,
    private val markersList: List<Marker>
) : RecyclerView.Adapter<MarkerAdapter.MarkerViewHolder>() {

    inner class MarkerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val annotationTextView: TextView = itemView.findViewById(R.id.body)
        private val lonLatTextView: TextView = itemView.findViewById(R.id.lat_lon)

        fun bind(currentItem: Marker) {
            titleTextView.text = currentItem.header
            titleTextView.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    viewModel.replaceMarkerData(currentItem.copy(header = p0.toString()))
                }
            })
            annotationTextView.text = currentItem.annotation

            annotationTextView.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    viewModel.replaceMarkerData(currentItem.copy(annotation = p0.toString()))
                }
            })

            lonLatTextView.text = itemView
                .context
                .resources.getString(
                    R.string.Lat_Lon_text, currentItem.latitude,
                    currentItem.longitude
                )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_marker,
            parent, false
        )

        return MarkerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MarkerViewHolder, position: Int) {
        holder.bind(markersList[position])
    }

    override fun getItemCount() = markersList.size
}