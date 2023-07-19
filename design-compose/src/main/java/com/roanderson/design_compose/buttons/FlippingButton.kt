package com.roanderson.design_compose.buttons

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun FlippingButton() {
    var isFlipped by remember { mutableStateOf(false) }
    
    val rotationX = animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = TweenSpec(durationMillis = 500)
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .widthIn(max = 200.dp)
            .heightIn(max = 100.dp)
            .animateContentSize()
            .rotate(rotationX.value)
    ) {
        Button(
            onClick = { isFlipped = !isFlipped },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Click me!")
        }
        Button(
            onClick = { isFlipped = !isFlipped },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Click me!")
        }
    }
}
