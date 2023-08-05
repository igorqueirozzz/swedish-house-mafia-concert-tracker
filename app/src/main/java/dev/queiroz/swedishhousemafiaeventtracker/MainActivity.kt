package dev.queiroz.swedishhousemafiaeventtracker

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import dev.queiroz.swedishhousemafiaeventtracker.ui.SHMApp
import dev.queiroz.swedishhousemafiaeventtracker.ui.screens.HomeScreenViewModel
import dev.queiroz.swedishhousemafiaeventtracker.ui.theme.SwedishHouseMafiaEventTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContent {
            val homeScreenViewModel: HomeScreenViewModel =
                viewModel(factory = HomeScreenViewModel.Factory)
            SwedishHouseMafiaEventTrackerTheme {
                SHMApp(
                    homeScreenViewModel = homeScreenViewModel,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                )
            }
        }
    }
}
