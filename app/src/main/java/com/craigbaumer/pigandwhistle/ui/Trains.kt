package com.craigbaumer.pigandwhistle.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.craigbaumer.pigandwhistle.R
import com.craigbaumer.pigandwhistle.TrainEvent
import com.craigbaumer.pigandwhistle.TrainState
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import com.craigbaumer.septa.data.TrainLocation
import com.craigbaumer.septa.data.TrainLocations
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Trains(
    modifier: Modifier = Modifier,
    trainState: TrainState,
    onEvent: (TrainEvent) -> Unit,
    onNavigateToDetail: (String) -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = trainState.isRefreshing,
        onRefresh = { onEvent(TrainEvent.Refresh) },
        modifier = modifier,
    ) {
        LazyColumn(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        ) {
            item {
                Row {
                    Image(
                        painter = painterResource(R.drawable.septa_logo),
                        contentDescription = stringResource(R.string.septa_logo),
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    )
                }
            }
            items(trainState.trainLocations.trainLocations) { trainLocation ->
                Train(
                    modifier = Modifier.clickable(
                        onClick = {
                            Timber.i("Navigation to $trainLocation")
                            onNavigateToDetail(trainLocation.trip) },
                    ),
                    trainLocation = trainLocation,
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
            trainState = TrainState(
                trainLocations = TrainLocations(
                    trainLocations = listOf(
                        TrainLocation.SAMPLE_LOCATION,
                        TrainLocation.SAMPLE_LOCATION,
                        TrainLocation.SAMPLE_LOCATION,
                    ),
                ),
            ),
            onEvent = {},
            onNavigateToDetail = {},
        )
    }
}
