package com.craigbaumer.pigandwhistle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import com.craigbaumer.septa.data.TrainLocation
import com.craigbaumer.septa.data.TrainLocations

@Composable
fun Trains(
    modifier: Modifier = Modifier,
    trainLocations: TrainLocations
) {
    LazyColumn(
        modifier = modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        items(trainLocations.trainLocations) { train ->
            Card(
                elevation = CardDefaults.elevatedCardElevation(),
            ) {
                Text(
                    text = train.nextStopName,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun TrainsPreview() {
    PigAndWhistleTheme {
        Trains(
            trainLocations = TrainLocations(
                trainLocations = listOf(
                    TrainLocation(
                        lat = "40.050251",
                        lng = "-75.347250",
                        label = "136",
                        routeId = "M1",
                        trip = "71328",
                        vehicleID = "136",
                        blockID = "4019",
                        direction = "N/A",
                        destination = "69th Street Transit Center",
                        late = 2,
                        nextStopId = "32192",
                        nextStopName = "Radnor - NHSL",
                        nextStopSequence = 7,
                        estimatedSeatAvailability = "NOT_AVAILABLE",
                        offset = 2,
                        offsetSec = "102",
                        timestamp = 1747685589,
                    ),
                ),
            ),
        )
    }
}