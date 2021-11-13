package com.koshake1.geolocationapp.data

import kotlin.random.Random

private val idRandom = Random(0)
val noteId: Long
    get() = idRandom.nextLong()

data class Marker(
    val latitude: Double,
    val longitude: Double,
    val id : Long = noteId,
    val header : String = "",
    val annotation: String = "",
)
