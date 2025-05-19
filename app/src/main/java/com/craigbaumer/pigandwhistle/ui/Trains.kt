package com.craigbaumer.pigandwhistle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme

@Composable
fun Trains(
    trains: List<String>
) {
    PigAndWhistleTheme {
        LazyColumn(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            items(trains) { train ->
                Text(
                    text = train,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun TrainsPreview() {
    Trains(listOf("M1", "M1"))
}