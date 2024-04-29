package com.roanderson.design_compose.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MotionCalculator() {
    var initialVelocity by remember { mutableStateOf("") }
    var acceleration by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = initialVelocity,
            onValueChange = { initialVelocity = it },
            label = { Text("Initial Velocity (m/s)") }
        )

        OutlinedTextField(
            value = acceleration,
            onValueChange = { acceleration = it },
            label = { Text("Acceleration (m/s²)") }
        )

        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time (s)") }
        )

        Button(
            onClick = {
                val u = initialVelocity.toDoubleOrNull() ?: 0.0
                val a = acceleration.toDoubleOrNull() ?: 0.0
                val t = time.toDoubleOrNull() ?: 0.0

                val s = u * t + 0.5 * a * t * t

                AlertDialog(
                    onDismissRequest = {  },
                    title = { Text("Resultado") },
                    text = { Text("A posição final é $s metros") },
                    confirmButton = {
                        Button(
                            onClick = { /* Fechar o diálogo */ },
                        ) {
                            Text("OK")
                        }
                    }
                )
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Calcular")
        }
    }
}
