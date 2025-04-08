package com.example.flybook.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bookingcom.data.local.models.Booking
import com.example.bookingcom.data.local.models.Flights

data class FlightsAndBooking(
    @Embedded
    val flights: Flights,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_flight"
    )
    val booking: Booking
)
