package com.example.bookingcom.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "airport"
)
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val name: String,
    val city: String,
    val country: String
)