package com.roanderson.design_compose.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun DiceRoller() {
    val (lastRoll, setLastRoll) = remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Último número rolado: $lastRoll")

        Button(onClick = {
            val randomNumber = Random.nextInt(1, 7)
            setLastRoll(randomNumber)
        }) {
            Text(text = "Rolar Dado")
        }
    }
}