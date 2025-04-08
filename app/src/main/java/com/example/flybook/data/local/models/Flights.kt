package com.example.bookingcom.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

@Entity(
    tableName = "flights",
            foreignKeys = [
        ForeignKey(
            entity = Airport::class,
            parentColumns = ["id"],
            childColumns = ["arrival"],
            onDelete = ForeignKey.CASCADE
        ),
                ForeignKey(
                    entity = Airport::class,
                    parentColumns = ["id"],
                    childColumns = ["departure"],
                    onDelete = ForeignKey.CASCADE
                ),
                ForeignKey(
                    entity = Aviacompany::class,
                    parentColumns = ["id"],
                    childColumns = ["id_company"],
                    onDelete = ForeignKey.CASCADE
                ),
    ]
)
data class Flights(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val departure: Int,
    val arrival: Int,
    val date_flight: Date,
    val id_company: Int,
    val price: Int
)
