package com.roanderson.design_compose.texts

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun RainbowText(text: String) {
    val rainbowColors = listOf(
        Color.Red,
        Color.Magenta,
        Color.Yellow,
        Color.Green,
        Color.Blue,
        Color(0xFF4B0082), // Indigo
        Color(0xFF8B4513)  // Orange
    )

    val annotatedText = buildAnnotatedString {
        text.forEachIndexed { index, char ->
            val color = rainbowColors[index % rainbowColors.size]
            withStyle(style = SpanStyle(color = color, fontSize = 24.sp)) {
                append(char)
            }
        }
    }

    Text(text = annotatedText)
}


