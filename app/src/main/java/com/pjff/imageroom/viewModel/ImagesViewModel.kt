package com.pjff.imageroom.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.pjff.imageroom.model.ImagesModel
import com.pjff.imageroom.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File

//Vid 255,androidview model tiene acceso al backend y al frontend
class ImagesViewModel(application: Application) : AndroidViewModel(application) {

    //Construimos nuestra base de datos
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "images_database"
    ).build()

    //Nuestra lista de imagénes
    private val _imagesList = MutableStateFlow<List<ImagesModel>>(emptyList())
    val imageList = _imagesList.asStateFlow()

    init{
        viewModelScope.launch(Dispatchers.IO) {
            db.imageDao().getImages().collect { items ->
                _imagesList.value = items
            }
        }
    }

    fun insertImage(item: ImagesModel){
        viewModelScope.launch(Dispatchers.IO) {
            db.imageDao().insertImage(item)
        }
    }

    fun deleteImage(item: ImagesModel){
        viewModelScope.launch(Dispatchers.IO) {
            deletePhoto(item.ruta)
            db.imageDao().deleteImage(item)
        }
    }

    private fun deletePhoto(photoPath: String){
        val file = File(photoPath)
        if(file.exists()){
            file.delete()
        }
    }

}