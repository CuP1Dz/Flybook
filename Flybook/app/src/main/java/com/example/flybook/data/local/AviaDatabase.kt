package com.example.bookingcom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.bookingcom.data.local.dao.FlybookDao
import com.example.bookingcom.data.local.models.Airport
import com.example.bookingcom.data.local.models.Aviacompany
import com.example.bookingcom.data.local.models.Booking
import com.example.bookingcom.data.local.models.Flights
import com.example.bookingcom.data.local.models.Payment
import com.example.bookingcom.data.local.models.User
import com.example.flybook.utils.Converters

@Database(entities = [
    Aviacompany::class,
    Airport::class,
    Booking::class,
    Flights::class,
    Payment::class,
    User::class], version = 1)
@TypeConverters(Converters::class)
abstract class AviaDatabase :RoomDatabase() {
    abstract fun flybookDao(): FlybookDao
}