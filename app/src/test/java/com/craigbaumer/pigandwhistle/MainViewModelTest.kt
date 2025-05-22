package com.craigbaumer.pigandwhistle

import app.cash.turbine.test
import com.craigbaumer.pigandwhistle.fakes.FakeTrainRepository
import com.craigbaumer.septa.data.models.TrainLocation
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(trainRepository = FakeTrainRepository())
    }

    @Test
    fun `Test valid API response`() = runTest {
        viewModel.state.test {
            assertThat(awaitItem().isRefreshing).isFalse()
            viewModel.onEvent(TrainEvent.Start)
            assertThat(awaitItem().isRefreshing).isTrue()
            assertThat(awaitItem().trainLocations.trainLocations.first()).isEqualTo(TrainLocation.SAMPLE_LOCATION)
        }
    }

    @Test
    fun `Test getTripLocation with a valid id`() = runTest {
        viewModel.state.test {
            assertThat(awaitItem().isRefreshing).isFalse()
            viewModel.onEvent(TrainEvent.Start)
            assertThat(awaitItem().isRefreshing).isTrue()
            assertThat(awaitItem().trainLocations.trainLocations.size).isEqualTo(1)

            assertThat(viewModel.getTripLocation("71328"))
                .isEqualTo(TrainLocation.SAMPLE_LOCATION)
        }
    }

    @Test
    fun `Test getTripLocation with an invalid id`() = runTest {
        viewModel.state.test {
            assertThat(awaitItem().isRefreshing).isFalse()
            viewModel.onEvent(TrainEvent.Start)
            assertThat(awaitItem().isRefreshing).isTrue()
            assertThat(awaitItem().trainLocations.trainLocations.size).isEqualTo(1)

            assertThat(viewModel.getTripLocation("invalid_id"))
                .isNull()
        }
    }
}
