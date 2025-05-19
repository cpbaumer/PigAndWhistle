package com.craigbaumer.pigandwhistle

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.craigbaumer.pigandwhistle.ui.Trains
import com.craigbaumer.pigandwhistle.ui.theme.PigAndWhistleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTrainLocations() // TODO

        enableEdgeToEdge()
        setContent {
            PigAndWhistleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Trains(
                        modifier = Modifier.padding(innerPadding),
                        trainLocations = viewModel.state.collectAsState().value,
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PigAndWhistleTheme {
        Greeting("Android")
    }
}