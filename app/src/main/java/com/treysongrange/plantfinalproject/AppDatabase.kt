package com.treysongrange.plantfinalproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.treysongrange.plantfinalproject.models.Plant

@Database(entities = [Plant::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPlantDao(): PlantDao
}