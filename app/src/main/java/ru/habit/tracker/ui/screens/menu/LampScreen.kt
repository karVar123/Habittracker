package ru.habit.tracker.ui.screens.menu


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LampScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = "Lamp", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}
