package com.treysongrange.plantfinalproject.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Plant(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo var name: String,
    @ColumnInfo var light: String,
    @ColumnInfo var humid: String
)
