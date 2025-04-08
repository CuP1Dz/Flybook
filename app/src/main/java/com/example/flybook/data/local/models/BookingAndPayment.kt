package com.example.flybook.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bookingcom.data.local.models.Booking
import com.example.bookingcom.data.local.models.Payment

data class BookingAndPayment(
    @Embedded
    val booking: Booking,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_booking"
    )
    val payment: List<Payment>
)
