package com.treysongrange.plantfinalproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.treysongrange.plantfinalproject.models.Plant

@Dao
interface PlantDao {
    @Query("SELECT * FROM plant")
    suspend fun getAllPlants(): List<Plant>

    @Insert
    suspend fun createPlant(plant: Plant): Long

    @Update
    suspend fun updatePlant(plant: Plant)
}