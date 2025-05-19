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
import com.craigbaumer.pigandwhistle.ui.Trains
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onEvent(TrainEvent.Start)

        enableEdgeToEdge()
        setContent {
            PigAndWhistleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Trains(
                        modifier = Modifier.padding(innerPadding),
                        trainState = viewModel.state.collectAsState().value,
                        onEvent = { viewModel.onEvent(it) },
                    )
                }
            }
        }
    }
}
