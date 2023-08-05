package dev.queiroz.swedishhousemafiaeventtracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import dev.queiroz.swedishhousemafiaeventtracker.ui.screens.HomeScreen
import dev.queiroz.swedishhousemafiaeventtracker.ui.screens.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SHMApp(homeScreenViewModel: HomeScreenViewModel, modifier: Modifier) {
    val homeUiState by homeScreenViewModel.homeUiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Upcoming shows", color = Color.White) },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black)
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(homeUiState = homeUiState, modifier = modifier)
        }
    }
}