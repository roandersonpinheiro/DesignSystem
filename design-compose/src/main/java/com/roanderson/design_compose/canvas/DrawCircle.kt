package com.roanderson.design_compose.canvas

import android.graphics.Color
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke

@Composable
fun DrawCircle() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color.Blue,
            radius = 100f,
            center = this.center,
            style = Stroke(width = 5f)
        )
    }
}
