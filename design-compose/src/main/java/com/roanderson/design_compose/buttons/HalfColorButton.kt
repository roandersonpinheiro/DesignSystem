package com.roanderson.design_compose.buttons

import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HalfColorButton(
    modifier: Modifier = Modifier,
    firstColor: Color,
    secondColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        // Draw content with custom colors
        drawWithContent {
            // Calculate the half width
            val halfWidth = size.width / 2f

            // Draw the first half
            canvas.drawColor(firstColor, BlendMode.SRC_OVER)
            canvas.drawRect(
                0f, 0f, halfWidth, size.height,
                Paint().apply { color = firstColor }
            )

            // Draw the second half
            canvas.drawColor(secondColor, BlendMode.SRC_OVER)
            canvas.drawRect(
                halfWidth, 0f, size.width, size.height,
                Paint().apply { color = secondColor }
            )
        }
    }
}