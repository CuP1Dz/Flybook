package com.example.flybook.data.local.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.bookingcom.data.local.models.Booking
import com.example.bookingcom.data.local.models.User

data class UserAndBooking(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_user"
    )
    val booking: Booking
)
