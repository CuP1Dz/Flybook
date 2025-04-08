package com.example.bookingcom.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

@Entity(
    tableName = "booking",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["id_user"],
            onDelete = ForeignKey.CASCADE
        )
    ]

)
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val id_user: Int,
    val id_flight:Int,
    val date_booking: Date,
    val status:String
)
