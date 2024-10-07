package com.pjff.imageroom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pjff.imageroom.model.ImagesModel
import kotlinx.coroutines.flow.Flow

//Vid 253,
@Dao
interface ImagesDao {

    @Query("SELECT * FROM Images")
    fun getImages(): Flow<List<ImagesModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(item: ImagesModel)

    @Delete
    suspend fun deleteImage(item: ImagesModel)

}