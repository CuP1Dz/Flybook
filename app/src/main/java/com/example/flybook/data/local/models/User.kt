package com.example.bookingcom.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val email: String,
    val password: String,
    val fname: String,
    val lname:String
)
