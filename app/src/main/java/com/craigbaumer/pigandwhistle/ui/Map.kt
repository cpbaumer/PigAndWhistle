package com.craigbaumer.pigandwhistle.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import com.craigbaumer.septa.data.models.TrainLocation
import com.craigbaumer.septa.data.models.TrainStop
import com.craigbaumer.septa.data.models.getDirection
import timber.log.Timber

@Composable
fun Map(
    modifier: Modifier = Modifier,
    trainLocations: List<TrainLocation>,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        elevation = CardDefaults.elevatedCardElevation(),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            TrainStop.TRAIN_STOPS.forEach { stop ->
                val active = trainLocations.find { it.nextStopId in stop.stopIds }

                if (active != null) {
                    Timber.d("Active stop: $active")
                }

                Stop(
                    name = stop.stopName,
                    active = active != null,
                    direction = active?.getDirection(),
                )
                Spacer(modifier = Modifier.size(8.dp))

            }
        }
    }
}

@PreviewLightDark
@Composable
fun MapPreview() {
    PigAndWhistleTheme {
        Map(
            trainLocations = listOf(TrainLocation.SAMPLE_LOCATION),
        )
    }
}
