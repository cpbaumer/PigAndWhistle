package com.craigbaumer.septa.data

import com.craigbaumer.septa.data.models.TrainLocations
import javax.inject.Inject

interface TrainRepository {
    suspend fun getTrainLocations(): TrainLocations
}

class TrainRepositoryImpl @Inject constructor(val client: SeptaClient) : TrainRepository {

    override suspend fun getTrainLocations(): TrainLocations {
        return client.instance.getTrainLocations()
    }
}
