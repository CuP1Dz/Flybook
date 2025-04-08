package com.example.bookingcom.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aviacompany")
data class Aviacompany(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val name: String
)
