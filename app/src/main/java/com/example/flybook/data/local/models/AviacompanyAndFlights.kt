package com.example.flybook.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bookingcom.data.local.models.Aviacompany
import com.example.bookingcom.data.local.models.Flights

data class AviacompanyAndFlights(
    @Embedded
    val aviacompany: Aviacompany,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_company"
    )
    val flights: List<Flights>
)
