package com.craigbaumer.pigandwhistle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.craigbaumer.pigandwhistle.navigation.Detail
import com.craigbaumer.pigandwhistle.navigation.Home
import com.craigbaumer.pigandwhistle.ui.TrainDetail
import com.craigbaumer.pigandwhistle.ui.Trains
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import com.craigbaumer.septa.data.TrainLocation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        viewModel.onEvent(TrainEvent.Start)

        setContent {
            PigAndWhistleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Home,
                    ) {
                        composable<Home> {
                            Trains(
                                modifier = Modifier.padding(innerPadding),
                                trainState = viewModel.state.collectAsState().value,
                                onEvent = { viewModel.onEvent(it) },
                                onNavigateToDetail = { trip ->
                                    navController.navigate(Detail(trip))
                                },
                            )
                        }

                        composable<Detail> { backStackEntry ->
                            val detail: Detail = backStackEntry.toRoute()
                            val trainLocation = viewModel.getTripLocation(detail.trip)
                            if (trainLocation != null) {
                                TrainDetail(
                                    modifier = Modifier.padding(innerPadding),
                                    trainLocation = trainLocation,
                                )
                            } else {
                                error("Couldn't find trip!")
                            }
                        }
                    }
                }
            }
        }
    }
}
