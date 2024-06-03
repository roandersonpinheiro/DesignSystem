package com.roanderson.design_compose.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientCard() {
    val gradientColors = listOf(Color(0xFFE91E63), Color(0xFF2196F3))
    val gradientBrush = Brush.linearGradient(colors = gradientColors)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(brush = gradientBrush),
        elevation = 8.dp
    ) {
        Box(modifier = Modifier.padding(16.dp)) {

        }
    }
}
