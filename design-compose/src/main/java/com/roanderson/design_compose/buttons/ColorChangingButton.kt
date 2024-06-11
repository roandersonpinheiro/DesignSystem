package com.roanderson.design_compose.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorChangingButton() {
    var isRed by remember { mutableStateOf(true) }

    val buttonColor = if (isRed) Color.Red else Color.Green

    Button(
        onClick = { isRed = !isRed },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Click me")
    }
}
