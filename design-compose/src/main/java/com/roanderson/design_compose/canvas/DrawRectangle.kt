package com.roanderson.design_compose.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawRect

@Composable
fun DrawRectangle() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(
            color = Color.Red,
            size = androidx.compose.ui.geometry.Size(200f, 100f),
            topLeft = center.copy(x = center.x - 100f, y = center.y - 50f)
        )
    }
}
