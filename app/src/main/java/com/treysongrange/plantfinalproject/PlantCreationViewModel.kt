package com.treysongrange.plantfinalproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.treysongrange.plantfinalproject.models.Plant
import kotlinx.coroutines.launch

class PlantCreationViewModel: ViewModel() {
    val done = MutableLiveData(false)
    fun createPlant(name: String,light:String,humid:String) {
        viewModelScope.launch {
            val plant = Plant(id = 0,name = name, light = light, humid = humid)
            PlantRepository.createPlant(plant)
            done.value = true
        }
    }
}