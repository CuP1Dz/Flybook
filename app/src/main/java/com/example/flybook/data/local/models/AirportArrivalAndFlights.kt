package com.example.flybook.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bookingcom.data.local.models.Airport
import com.example.bookingcom.data.local.models.Flights

data class AirportArrivalAndFlights(
    @Embedded
    val airport: Airport,
    @Relation(
        parentColumn = "id",
        entityColumn = "arrival"
    )
    val flights: List<Flights>
)
