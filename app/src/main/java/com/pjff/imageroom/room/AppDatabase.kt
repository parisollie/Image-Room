package com.pjff.imageroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pjff.imageroom.model.ImagesModel

//Vid 253
@Database(entities = [ImagesModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imageDao(): ImagesDao
}