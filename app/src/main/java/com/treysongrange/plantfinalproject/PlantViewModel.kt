package com.treysongrange.plantfinalproject

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.treysongrange.plantfinalproject.models.Plant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PlantViewModel: ViewModel() {
    val plants = ObservableArrayList<Plant>()
    init {
        loadPlants()
    }
    private fun loadPlants() {
        viewModelScope.launch {
            val loadedPlants = PlantRepository.getAllPlants()
            plants.addAll(loadedPlants)
        }
    }
}