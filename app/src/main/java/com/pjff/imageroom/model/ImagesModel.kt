package com.pjff.imageroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Vid 253
@Entity(tableName = "Images")
data class ImagesModel(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val ruta: String,
)
