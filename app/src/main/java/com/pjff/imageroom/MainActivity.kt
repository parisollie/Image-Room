package com.pjff.imageroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pjff.imageroom.navigation.NavManager
import com.pjff.imageroom.ui.theme.ImageRoomTheme
import com.pjff.imageroom.viewModel.ImagesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viud 257
        val viewModel: ImagesViewModel by viewModels()
        setContent {
            ImageRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Vid 252 bide 257 add viewModel
                    NavManager(viewModel)
                }
            }
        }
    }
}

