package com.shady8.lightmeter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shady8.lightmeter.ui.theme.SHADY8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SHADY8Theme {
                var stopInfo by remember { mutableStateOf("Loading...") }
                val meter = remember { LightMeter(applicationContext) }
                LaunchedEffect(Unit) {
                    meter.startListening { stop ->
                        stopInfo = stop
                    }
                }
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "Exposure: $stopInfo", style = MaterialTheme.typography.headlineMedium)
                    }
                }
            }
        }
    }
}