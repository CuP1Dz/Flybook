package com.example.flybook.data.local

import android.app.Application
import androidx.room.Room
import com.example.bookingcom.data.local.AviaDatabase

class FlybookApp : Application() {
    companion object {
        private var _database: AviaDatabase? = null
        val database: AviaDatabase? = _database
    }
    override fun onCreate() {
        super.onCreate()
        _database = Room.databaseBuilder(
            this,
            AviaDatabase::class.java,
            "flybook_database"
        ).build()
    }
}