package com.craigbaumer.pigandwhistle.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.craigbaumer.pigandwhistle.R
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import com.craigbaumer.septa.data.TrainLocation

@Composable
fun Train(
    modifier: Modifier = Modifier,
    trainLocation: TrainLocation,
) {
    Card(
        modifier = modifier.padding(8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        elevation = CardDefaults.elevatedCardElevation(),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            val nextStopName = trainLocation.nextStopName
            val nextStopString = if (nextStopName != null) {
                stringResource(R.string.next_stop, nextStopName)
            } else {
                stringResource(R.string.none)
            }
            Text(
                text = nextStopString,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.destination, trainLocation.destination),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyMedium,
            )
            if (trainLocation.late > 0) {
                Text(
                    text = stringResource(R.string.late_minutes, trainLocation.late),
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun TrainPreview() {
    PigAndWhistleTheme {
        Train(
            modifier = Modifier,
            trainLocation = TrainLocation.SAMPLE_LOCATION,
        )
    }
}
