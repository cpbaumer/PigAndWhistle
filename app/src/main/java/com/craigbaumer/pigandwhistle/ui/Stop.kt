package com.craigbaumer.pigandwhistle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import com.craigbaumer.septa.data.models.Direction


@Composable
fun Stop(
    name: String,
    active: Boolean,
    direction: Direction?,
) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .background(
                    color = if (active) {
                        MaterialTheme.colorScheme.surfaceBright
                    } else {
                        MaterialTheme.colorScheme.surfaceDim
                    },
                    shape = CircleShape,
                )
                .size(32.dp),
            contentAlignment = Alignment.Center,
        ) {
            if (active) {
                when (direction) {
                    Direction.SixtyNinthSt -> {
                        Icon(
                            Icons.Filled.KeyboardArrowDown,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            contentDescription = null, // TODO
                        )
                    }

                    Direction.Norristown -> {
                        Icon(
                            Icons.Filled.KeyboardArrowUp,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            contentDescription = null, // TODO
                        )
                    }
                    else -> {}
                }
            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}

@PreviewLightDark
@Composable
fun StopPreview() {
    PigAndWhistleTheme {
        Stop(
            name = "Ardmore Station",
            active = true,
            direction = Direction.Norristown,
        )
    }
}

@PreviewLightDark
@Composable
fun StopPreviewNotActive() {
    PigAndWhistleTheme {
        Stop(
            name = "Ardmore Station",
            active = false,
            direction = Direction.SixtyNinthSt,
        )

    }
}
