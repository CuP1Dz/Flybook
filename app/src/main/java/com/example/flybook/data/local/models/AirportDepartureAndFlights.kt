package com.example.flybook.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bookingcom.data.local.models.Airport
import com.example.bookingcom.data.local.models.Flights

data class AirportDepartureAndFlights(
    @Embedded
    val airport: Airport,
    @Relation(
        parentColumn = "id",
        entityColumn = "departure"
    )
    val flights: List<Flights>
)
