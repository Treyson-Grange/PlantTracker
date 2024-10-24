package com.treysongrange.plantfinalproject

import android.app.Application

class PlantApplication: Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: Application? = null

        fun getInstance(): Application {
            return instance!!
        }
    }
}