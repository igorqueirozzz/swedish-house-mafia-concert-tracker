package dev.queiroz.swedishhousemafiaeventtracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.queiroz.swedishhousemafiaeventtracker.ui.EventCard

@OptIn()
@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    modifier: Modifier
) {

    when (homeUiState) {
        is HomeUiState.Success -> LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(homeUiState.events) { event ->
                EventCard(modifier = Modifier.padding(10.dp), event = event)
            }
        }

        is HomeUiState.Loading -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }

        is HomeUiState.Error -> Text(text = homeUiState.message)
    }
}