package com.roanderson.design_compose.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CardWithFoldedCorner(
    modifier: Modifier = Modifier,
    cornerSize: Dp = 20.dp,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(cornerSize)
                .background(MaterialTheme.colors.surface),
            elevation = 4.dp
        ) {
            content()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(size.width - cornerSize.toPx(), 0f)
                lineTo(size.width, cornerSize.toPx())
                lineTo(size.width, 0f)
                close()
            }
            drawIntoCanvas { canvas ->
                canvas.drawPath(path,paint = Paint())
            }
        }
    }
}
