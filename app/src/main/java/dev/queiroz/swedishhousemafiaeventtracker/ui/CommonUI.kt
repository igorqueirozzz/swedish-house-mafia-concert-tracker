package dev.queiroz.swedishhousemafiaeventtracker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.queiroz.swedishhousemafiaeventtracker.R
import dev.queiroz.swedishhousemafiaeventtracker.model.Event

@Composable
//@Preview(showBackground = true)
fun EventCard(modifier: Modifier = Modifier, event: Event) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 30.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F0F0F))
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            Image(
                painter = painterResource(
                    id = getImageFromName(event.name)
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.drawWithCache {
                    val brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 150f,
                        endY = Float.POSITIVE_INFINITY
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(brush)
                    }
                }
            )

            Text(
                text = event.name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, bottom = 10.dp),
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            val primaryColor = MaterialTheme.colorScheme.primary
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = event.location, color = primaryColor)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.DateRange,
                        contentDescription = null,
                        tint = primaryColor
                    )
                    Text(text = event.date, color = primaryColor)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        tint = primaryColor
                    )
                    Text(text = event.city, color = primaryColor)
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.LocalActivity,
                        contentDescription = null
                    )
                    Text(text = "Tickets")

                }
            }
        }
    }
}


private fun getImageFromName(name: String): Int {
    if (name.equals("swedish house mafia", ignoreCase = true)) {
        return R.drawable.swedishhousemafia
    } else if (name.equals("steve angello", ignoreCase = true)) {
        return R.drawable.steveangello
    } else if (name.equals("axwell + ingrosso", ignoreCase = true)) {
        return R.drawable.axwellingrosso
    } else if (name.equals("axwell", ignoreCase = true)) {
        return R.drawable.axwell
    } else if (name.equals("sebastian ingrosso", ignoreCase = true)) {
        return R.drawable.sebastianingrosso
    } else {
        return R.drawable.swedishhousemafia
    }
}