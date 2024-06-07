package com.roanderson.design_compose.icons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BlinkingIcon() {
    var isRed by remember { mutableStateOf(true) }
    
    val color by animateColorAsState(
        targetValue = if (isRed) Color.Red else Color.Green,
        animationSpec = tween(durationMillis = 500)
    )

    LaunchedEffect(Unit) {
        while (true) {
            isRed = !isRed
            kotlinx.coroutines.delay(1000) // 1 second delay
        }
    }

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color)
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite Icon",
            tint = Color.White,
            modifier = Modifier.size(100.dp)
        )
    }
}