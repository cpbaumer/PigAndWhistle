package com.craigbaumer.septa.data.models

sealed interface Direction {
    data object SixtyNinthSt : Direction
    data object Norristown : Direction
    data object Unknown : Direction
}
