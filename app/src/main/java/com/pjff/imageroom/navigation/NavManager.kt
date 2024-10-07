package com.pjff.imageroom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pjff.imageroom.viewModel.ImagesViewModel
import com.pjff.imageroom.views.AddPhotoView
import com.pjff.imageroom.views.HomeView

//Vid 252
@Composable
fun NavManager(viewModel: ImagesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ){
        composable("Home"){
            //Vid 258, add view Model
            HomeView(navController, viewModel)
        }
        composable("AddPhotoView"){
            //Vid 257, add viewModel
            AddPhotoView(viewModel)
        }
    }
}