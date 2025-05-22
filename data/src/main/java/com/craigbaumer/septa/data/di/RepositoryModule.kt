package com.craigbaumer.septa.data.di

import com.craigbaumer.septa.data.TrainRepository
import com.craigbaumer.septa.data.TrainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    abstract fun bindsTrainRepository(
        trainRepositoryImpl: TrainRepositoryImpl,
    ): TrainRepository
}