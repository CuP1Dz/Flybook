package com.example.bookingcom.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payment")
data class Payment(
@PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val id_booking: Int,
    val status: String,
    val details: String
)
