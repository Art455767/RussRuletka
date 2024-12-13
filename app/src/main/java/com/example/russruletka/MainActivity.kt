package com.example.russruletka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.russruletka.rr.RR
import com.example.russruletka.ui.theme.Green
import com.example.russruletka.ui.theme.RussRuletkaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RussRuletkaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    RR()
                }
            }
        }
    }
}


