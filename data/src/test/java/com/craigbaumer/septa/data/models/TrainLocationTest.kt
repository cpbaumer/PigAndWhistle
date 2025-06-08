package com.craigbaumer.septa.data.models

import org.junit.Assert.assertEquals
import org.junit.Test

class TrainLocationTest {

    @Test
    fun `getDirection returns Norristown when destination contains Norristown`() {
        val trainLocation = TrainLocation.SAMPLE_LOCATION.copy(destination = "Norristown Transportation Center")
        assertEquals(Direction.Norristown, trainLocation.getDirection())
    }

    @Test
    fun `getDirection returns SixtyNinthSt when destination contains 69`() {
        val trainLocation = TrainLocation.SAMPLE_LOCATION.copy(destination = "69th St Transportation Center")
        assertEquals(Direction.SixtyNinthSt, trainLocation.getDirection())
    }

    @Test
    fun `getDirection returns SixtyNinthSt when destination contains 69th`() {
        val trainLocation = TrainLocation.SAMPLE_LOCATION.copy(destination = "69th Street TC")
        assertEquals(Direction.SixtyNinthSt, trainLocation.getDirection())
    }

    @Test
    fun `getDirection returns Unknown for other destinations`() {
        val trainLocation = TrainLocation.SAMPLE_LOCATION.copy(destination = "Center City")
        assertEquals(Direction.Unknown, trainLocation.getDirection())
    }

    @Test
    fun `getDirection returns Unknown for empty destination`() {
        val trainLocation = TrainLocation.SAMPLE_LOCATION.copy(destination = "")
        assertEquals(Direction.Unknown, trainLocation.getDirection())
    }

    @Test
    fun `getDirection is case insensitive for Norristown`() {
        val trainLocation = TrainLocation.SAMPLE_LOCATION.copy(destination = "norristown express")
        assertEquals(Direction.Norristown, trainLocation.getDirection())
    }
}
