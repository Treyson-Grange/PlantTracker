package com.treysongrange.plantfinalproject

import androidx.room.Room
import com.treysongrange.plantfinalproject.models.Plant

object PlantRepository {
    private val db: AppDatabase;
    private var cacheInitialized = false;
    private val plantCache = mutableListOf<Plant>()
    init {
        db = Room.databaseBuilder(
            PlantApplication.getInstance(),
            AppDatabase::class.java,
            "plants-database"
        ).build()
    }
    suspend fun createPlant(plant: Plant) {
        plant.id = db.getPlantDao().createPlant(plant)
        plantCache.add(plant)
    }

    suspend fun getAllPlants(): List<Plant> {
        if(!cacheInitialized) {
            plantCache.addAll(db.getPlantDao().getAllPlants())
            cacheInitialized = true
        }
        return plantCache
    }
    suspend fun update(plant: Plant) {
        db.getPlantDao().updatePlant(plant)
        plantCache[plantCache.indexOfFirst {
            it.id == plant.id
        }] = plant
    }

}