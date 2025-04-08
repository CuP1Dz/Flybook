package com.example.bookingcom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bookingcom.data.local.models.Aviacompany
import com.example.bookingcom.data.local.models.User


@Dao
interface FlybookDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Insert
    suspend fun insert_user(user: User)

    @Delete
    suspend fun delete_user(user: User)

    // -----------------------------------

    @Query("SELECT * FROM aviacompany")
    suspend fun getAllCompanys(): List<Aviacompany>

    @Insert
    suspend fun insert_avia(aviacompany: Aviacompany)

    @Delete
    suspend fun delete_avia(aviacompany: Aviacompany)


}