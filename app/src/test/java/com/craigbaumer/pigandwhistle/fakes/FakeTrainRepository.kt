package com.craigbaumer.pigandwhistle.fakes

import com.craigbaumer.septa.data.TrainRepository
import com.craigbaumer.septa.data.models.TrainLocation
import com.craigbaumer.septa.data.models.TrainLocations

class FakeTrainRepository : TrainRepository {
    override suspend fun getTrainLocations(): TrainLocations {
        return TrainLocations(listOf(TrainLocation.SAMPLE_LOCATION))
    }
}
