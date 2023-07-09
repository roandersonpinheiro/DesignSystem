package com.roanderson.design_compose.badge

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun AnimatedBadge(
    text: String,
    backgroundColor: Color,
    contentColor: Color
) {
    var animationState by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            animationState = true
            delay(1000)
            animationState = false
            delay(1000)
        }
    }

    Surface(
        shape = CircleShape,
        color = backgroundColor
    ) {
        Text(
            text = text,
            color = contentColor,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .scale(if (animationState) 1.2f else 1f)
        )
    }
}
