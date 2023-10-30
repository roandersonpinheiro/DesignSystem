package com.roanderson.design_compose.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun CountdownButton() {
    var secondsLeft by remember { mutableStateOf(60) }
    var buttonEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (buttonEnabled) {
            Button(
                onClick = {
                    // Ação a ser executada após o clique
                }
            ) {
                Text(text = "Clique aqui")
            }
        } else {
            Text(
                text = "Continuar em $secondsLeft segundos",
                style = MaterialTheme.typography.h4
            )
        }
    }

    LaunchedEffect(Unit) {
        repeat(60) { // Contagem regressiva de 60 segundos
            secondsLeft--
            delay(1000)
        }
        buttonEnabled = true
    }
}
